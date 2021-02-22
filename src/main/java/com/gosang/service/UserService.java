package com.gosang.service;

import com.gosang.entity.User;
import com.gosang.entity.UserToShow;

import java.util.List;

/**
 * @InterfaceName: MyFileService
 * @Description: 用户业务层接口
 * @author: gosang
 * @date 2020/1/26 22:15
 * @Version: 1.0
 **/
public interface UserService {

    /**
     * @return com.gosang.entity.User
     * @Description 通过openID查询单条数据
     * @Author gosang
     * @Date 18:29 2020/2/25
     * @Param [userId]
     **/
    User getUserByOpenId(String openId);

    /**
     * @param user 实例对象
     * @return 是否成功
     * @Description 添加User
     * @author gosang
     * @date 2020-02-25 17:19:31
     */
    boolean insert(User user);

    /**
     * @param user 实例对象
     * @return 是否成功
     * @Description 修改数据，哪个属性不为空就修改哪个属性
     * @author gosang
     * @date 2020-02-25 17:19:31
     */
    boolean update(User user);

    /**
     * @return com.gosang.entity.User
     * @Description 通过邮箱查询单条数据
     * @Author gosang
     * @Date 18:29 2020/2/25
     * @Param [email]
     **/
    User getUserByEmail(String email);

    /**
     * @return java.lang.Integer
     * @Description 获得已注册用户的数量
     * @Author gosang
     * @Date 10:50 2020/3/11
     * @Param []
     **/
    Integer getUsersCount();

    /**
     * @return java.util.List<com.gosang.entity.UserToShow>
     * @Description 获取全部的用户
     * @Author gosang
     * @Date 16:40 2020/3/10
     * @Param []
     **/
    List<UserToShow> getUsers();

    /**
     * @Description 查询单条数据
     * @author gosang
     * @date 2020-02-25 17:19:31
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(Integer userId);

    /**
     * @Description 删除User
     * @author gosang
     * @date 2020-02-25 17:19:31
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userId);
}