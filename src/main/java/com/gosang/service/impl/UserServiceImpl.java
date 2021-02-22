package com.gosang.service.impl;

import com.gosang.entity.User;
import com.gosang.entity.UserToShow;
import com.gosang.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @ClassName UserServiceImpl
* @Description (User)表服务实现类
* @author gosang
* @date 2020-02-25 17:19:31
* @Version 1.0
**/
@Service
public class UserServiceImpl extends BaseService implements UserService {

    /**
     * @Description  通过openID查询单条数据
     * @Author gosang
     * @Date 18:29 2020/2/25
     * @Param [userId]
     * @return com.gosang.entity.User
     **/
    @Override
    public User getUserByOpenId(String openId) {
        return userMapper.getUserByOpenId(openId);
    }

    /**
     * @Description 添加User
     * @author gosang
     * @date 2020-02-25 17:19:31
     * @param user 实例对象
     * @return 是否成功
     */
    @Override
    public boolean insert(User user) {
        if(userMapper.insert(user) == 1){
            return true;
        }
        return false;
    }

    /**
     * @Description 修改数据，哪个属性不为空就修改哪个属性
     * @author gosang
     * @date 2020-02-25 17:19:31
     * @param user 实例对象
     * @return 是否成功
     */
    @Override
    public boolean update(User user) {
        if(userMapper.update(user) == 1){
            return true;
        }
        return false;
    }

    /**
     * @Description 通过邮箱查询单条数据
     * @author gosang
     * @date 2020-02-25 17:19:31
     * @param email 邮箱
     * @return 实例对象
     */
    @Override
    public User getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }

    /**
     * @Description 获得已注册用户的数量
     * @Author gosang
     * @Date 10:50 2020/3/11
     * @Param []
     * @return java.lang.Integer
     **/
    @Override
    public Integer getUsersCount() {
        return userMapper.getUsersCount();
    }

    /**
     * @Description 获取全部的用户
     * @Author gosang
     * @Date 16:40 2020/3/10
     * @Param []
     * @return java.util.List<com.gosang.entity.UserToShow>
     **/
    @Override
    public List<UserToShow> getUsers() {
        return userMapper.getUsers();
    }

    /**
     * @Description 查询单条数据
     * @author gosang
     * @date 2020-02-25 17:19:31
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer userId) {
        return userMapper.queryById(userId);
    }

    /**
     * @Description 删除User
     * @author gosang
     * @date 2020-02-25 17:19:31
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userId) {
        if(userMapper.deleteById(userId) == 1){
            return true;
        }
        return false;
    }
}