package com.tensquare.user.controller;

import com.tensquare.user.pojo.User;
import com.tensquare.user.service.UserService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //新增
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody User user){
        this.userService.save(user);
        return new Result(true, StatusCode.OK,"新增成功!");
    }
    //查询所有
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true,StatusCode.OK,"查询成功!",this.userService.findAll());
    }

    //根据id查询
    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    public Result findByID(@PathVariable String userId){
        return new Result(true,StatusCode.OK,"查询成功!",this.userService.findById(userId));
    }

    //根据id修改
    @RequestMapping(value = "/{userId}",method = RequestMethod.PUT)
    public Result update(@PathVariable String userId){
        this.userService.update(userId);
        return new Result(true,StatusCode.OK,"查询成功!");
    }
    //根据id删除
    @RequestMapping(value = "/{userId}",method = RequestMethod.PUT)
    public Result delete(@PathVariable String userId){
        this.userService.delete(userId);
        return new Result(true,StatusCode.OK,"删除成功!");
    }

}
