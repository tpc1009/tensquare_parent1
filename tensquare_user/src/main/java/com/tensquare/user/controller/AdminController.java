package com.tensquare.user.controller;

import com.tensquare.user.pojo.Admin;
import com.tensquare.user.service.AdminService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.JwtUtil;

import java.util.HashMap;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private JwtUtil jwtUtil;

    //管理员新增
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Admin admin){
        this.adminService.save(admin);
        return new Result(true, StatusCode.OK,"新增成功");
    }

    //查询管理员
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true,StatusCode.OK,"查询成功!",this.adminService.findAll());
    }

    //根据id查询
    @RequestMapping(value = "/{adminId}",method = RequestMethod.GET)
    public Result findById(@PathVariable String adminId){
        return new Result(true,StatusCode.OK,"查询成功!",this.adminService.findById(adminId));
    }

    //根据id删除
    @RequestMapping(value = "/{adminId}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String adminId){
        this.adminService.delete(adminId);
        return new Result(true,StatusCode.OK,"删除成功!");
    }

    //login
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(@RequestBody Admin admin){
        Admin adminlogin = this.adminService.login(admin);
        if(adminlogin ==null){
            return new Result(false,StatusCode.LOGINERROR,"用户不存在!请重新输入");
        }
        //使得前后端可以通话的操作,采用jwt实现
        //生成令牌
        String tocken = jwtUtil.createJWT(adminlogin.getId(), adminlogin.getLoginname(), "admin");
        HashMap<String, Object> map = new HashMap<>();
        map.put("tocken",tocken);
        map.put("role","admin");
        return new Result(true,StatusCode.OK,"登陆成功!",map);
    }
}
