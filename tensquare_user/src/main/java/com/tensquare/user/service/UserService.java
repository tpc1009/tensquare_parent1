package com.tensquare.user.service;

import com.tensquare.user.dao.UserDao;
import com.tensquare.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    //新增
    public void save(User user) {
        this.userDao.save(user);
    }

    //查询所有
    public List<User> findAll() {
        return this.userDao.findAll();
    }

    //根据id查询
    public User findById(String userId) {
        return this.userDao.findById(userId).get();
    }

    //根据id修改
    public void update(String userId) {
        User user = new User();
        user.setId(userId);
        this.userDao.save(user);
    }

    //根据id删除
    public void delete(String userId) {
        this.userDao.deleteById(userId);
    }
}
