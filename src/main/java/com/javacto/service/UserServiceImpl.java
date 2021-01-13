package com.javacto.service;

import com.javacto.dao.UserDao;
import com.javacto.dao.UserDaoImpl;
import com.javacto.po.User;
import com.javacto.utils.Page;

import java.util.List;

public class UserServiceImpl implements UserService {
    //调用dao层
    private UserDao userDao = new UserDaoImpl();
    /**
     * 查询总条数
     */
    @Override
    public int getTotalCount(User user) {
        return userDao.getTotalCount(user);
    }
    /**
     * 分页查询
     */
    @Override
    public List<User> getPageUser(Page page, User user) {
        return userDao.getPageUser(page, user);
    }
    /**
     * 根据id查询对象
     */
    public  User getUserById(int id){
        return userDao.getUserById(id);
    };
    /**
     * 根据id删除对象
     */
    public int deleteUserById(int id){
        return userDao.deleteUserById(id);
    }
    /**
     * 修改用户信息
     */
    public int updateUser(User user){
        return userDao.updateUser(user);
    }
    /**
     * 添加用户
     */
    public int addUser(User user){
        return userDao.addUser(user);
    }
}
