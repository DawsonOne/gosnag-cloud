package com.gosang.mapper;

import com.gosang.entity.User;
import com.gosang.entity.UserToShow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @InterfaceName: MyFileMapper
 * @Description: 与用户相关的数据库操作
 * @author: xw
 * @date 2020/1/26 21:55
 * @Version: 1.0
 **/
@Mapper
public interface UserMapper {

    /**
     * @Description  通过openID查询单条数据
     * @Author gosang
     * @Date 18:29 2020/2/25
     * @Param [userId]
     * @return com.gosang.entity.User
     **/
    User getUserByOpenId(String openId);

    /**
     * @Description 添加User
     * @author gosang
     * @date 2020-02-25 17:19:31
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(User user);

    /**
     * @Description 修改User
     * @author gosang
     * @date 2020-02-25 17:19:31
     * @return 影响行数
     */
    int update(User user);

    /**
     * @Description  通过邮箱查询单条数据
     * @Author gosang
     * @Date 18:29 2020/2/25
     * @Param [email]
     * @return com.gosang.entity.User
     **/
    User getUserByEmail(String email);

    /**
     * @Description 获得已注册用户的数量
     * @Author gosang
     * @Date 10:50 2020/3/11
     * @Param []
     * @return java.lang.Integer
     **/
    Integer getUsersCount();

    /**
     * @Description 获取全部的用户
     * @Author gosang
     * @Date 16:40 2020/3/10
     * @Param []
     * @return java.util.List<com.gosang.entity.UserToShow>
     **/
    List<UserToShow> getUsers();

    /**
     * @Description 通过ID查询单条数据
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
     * @return 影响行数
     */
    int deleteById(Integer userId);
}