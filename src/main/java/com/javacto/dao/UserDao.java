package com.javacto.dao;

import com.javacto.po.User;
import com.javacto.utils.Page;

import java.util.List;

public interface UserDao {
    /**
     * 查询总条数
     */
    public int getTotalCount(User user);
    /**
     * 分页查询
     */
    public List<User> getPageUser(Page page, User user);
    /**
     * 根据id查询对象
     */
    public  User getUserById(int id);
    /**
     * 根据id删除对象
     */
    public int deleteUserById(int id);
    /**
     * 修改用户信息
     */
    public int updateUser(User user);
    /**
     * 添加用户
     */
    public int addUser(User user);
}
