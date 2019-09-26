package com.tensquare.user.service;

import com.tensquare.user.dao.AdminDao;
import com.tensquare.user.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;


@Service
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    //盐
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private IdWorker idWorker;

    //管理员新增方法
    public void save(Admin admin) {
        admin.setId(idWorker.nextId()+"");
        admin.setPassword(this.bCryptPasswordEncoder.encode(admin.getPassword()));
        this.adminDao.save(admin);
    }

    //查询所有
    public List<Admin> findAll() {
        return this.adminDao.findAll();
    }

    //根据id查询
    public Admin findById(String adminId) {
        return this.adminDao.findById(adminId).get();
    }

    //删除账号
    public void delete(String adminId) {
        this.adminDao.deleteById(adminId);
    }

    //登陆
    public Admin login(Admin admin) {
        Admin adminlogin = this.adminDao.findByLoginname(admin.getLoginname());
        if(adminlogin !=null && this.bCryptPasswordEncoder.matches(admin.getPassword(),adminlogin.getPassword())){
            return adminlogin;
        }
        return null;
    }
}
