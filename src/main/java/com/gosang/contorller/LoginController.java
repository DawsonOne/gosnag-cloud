package com.gosang.contorller;

import com.gosang.entity.FileStore;
import com.gosang.entity.User;
import com.gosang.utils.LogUtils;
import com.gosang.utils.MailUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

/**
 * @Description 登录控制器
 * @Author gosang
 * @Date 18:19 2020/2/25
 * @Param  * @param null
 * @return
 **/
@Controller
public class LoginController extends BaseController {

    private Logger logger = LogUtils.getInstance(LoginController.class);

    /**
     * @Description 免登陆用户入口，用于本地开发测试，上线运营为了安全请删除此方法
     * @Author gosang
     * @Date 15:17 2020/2/26
     * @Param []
     * @return java.lang.String
     **/
    @GetMapping("/admin")
    public String adminLogin(){
        User user = userService.getUserByOpenId("123456");
        logger.info("使用免登陆方式登录成功！"+user);
        session.setAttribute("loginUser", user);
        return "redirect:/index";
    }

    /**
     * 用于注册流程,用户名，密码，邮箱等校验工作由前端来完成
     *
     * @param map 用于存储提示信息
     * @author gosang
     * @date 2020/1/28
     */
    @PostMapping("/register")
    public String register(User user, String code, Map<String, Object> map) {
        String uCode = (String) session.getAttribute(user.getEmail() + "_code");
        if (!code.equals(uCode)) {
            map.put("errorMsg", "验证码错误");
            return "index";
        }
        // 用户名去空格
        user.setUserName(user.getUserName().trim());
        user.setImagePath("https://p.qpic.cn/qqconnect/0/app_101851241_1582451550/100?max-age=2592000&t=0");
        user.setRegisterTime(new Date());
        user.setRole(1);
        if (userService.insert(user)) {
            FileStore store = FileStore.builder().userId(user.getUserId()).currentSize(0).build();
            fileStoreService.addFileStore(store);
            user.setFileStoreId(store.getFileStoreId());
            userService.update(user);
            logger.info("注册用户成功！当前注册用户" + user);
            logger.info("注册仓库成功！当前注册仓库" + store);
        } else {
            map.put("errorMsg", "服务器发生错误，注册失败");
            return "index";
        }
        session.removeAttribute(user.getEmail() + "_code");
        session.setAttribute("loginUser", user);
        return "redirect:/index";
    }

    /**
     * 用户登录
     * @param map 存储提示信息
     * @return java.lang.String
     * @author gosang
     * @date 2020/1/28
     */
    @PostMapping("/login")
    public String login(User user, Map<String, Object> map) {
        User userByEmail = userService.getUserByEmail(user.getEmail());
        if (userByEmail != null && userByEmail.getPassword().equals(user.getPassword())) {
            session.setAttribute("loginUser", userByEmail);
            logger.info("登录成功！"+userByEmail);
            return "redirect:/index";
        }else{
            User user1 = userService.getUserByEmail(user.getEmail());
            String errorMsg = user1 == null ? "该邮箱尚未注册" : "密码错误";
            logger.info("登录失败！请确认邮箱和密码是否正确！");
            //登录失败，将失败信息返回前端渲染
            map.put("errorMsg", errorMsg);
            return "index";
        }
    }

    /**
     * @return void
     * @Description 向注册邮箱发送验证码, 并验证邮箱是否已使用
     * @Author gosang
     * @Date 19:32 2020/1/29
     * @Param [userName, email, password]
     **/
    @ResponseBody
    @GetMapping("/sendCode")
    public String sendCode(String userName, String password, String email) {
        User userByEmail = userService.getUserByEmail(email);
        if (userByEmail != null) {
            logger.error("发送验证码失败！邮箱已被注册！");
            return "exitEmail";
        }
        logger.info("开始发送邮件.../n" + "获取的到邮件发送对象为:" + mailSender);
        mailUtils = new MailUtils(mailSender);
        String code = mailUtils.sendCode(email, userName, password);
        session.setAttribute(email + "_code", code);
        return "success";
    }

    /**
     * @Description 退出登录，清空session
     * @Author gosang
     * @Date 18:26 2020/2/25
     * @Param []
     * @return java.lang.String
     **/
    @GetMapping("/logout")
    public String logout() {
        logger.info("用户退出登录！");
        session.invalidate();
        return "redirect:/";
    }
}
