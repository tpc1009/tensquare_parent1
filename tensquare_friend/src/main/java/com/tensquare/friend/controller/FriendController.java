package com.tensquare.friend.controller;

import com.tensquare.friend.service.FriendService;
import entity.Result;
import entity.StatusCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/friend")
public class FriendController {

    /**
     * 添加好友和非好友
     */
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private FriendService friendService;

    @RequestMapping(value = "/like/{friendid}/{type}",method = RequestMethod.PUT)
    public Result addFriend(@PathVariable String friendid,@PathVariable String type){


        //获取用户信息
        Claims claims = (Claims)this.request.getAttribute("claims_admin");
        if(claims == null || "".equals(claims)){
            return new Result(false, StatusCode.LOGINERROR,"权限不足");
        }
        //获取当前登陆userid
        String userid = claims.getId();
        //添加好友
        if(type !=null){
            if(type.equals("1")){
                //添加好友
               int flag = this.friendService.add(userid,friendid);
               if(flag ==0){
                   return new Result(false,StatusCode.ERROR,"不能重复添加");
               }
               if(flag ==1){
                   return new Result(true,StatusCode.OK,"添加成功");
               }
            }else if(type.equals("2")){
                //添加非好友
            }
            return new Result(false,StatusCode.ERROR,"参数异常");
        }else {
            return new Result(false,StatusCode.ERROR,"参数异常");
        }


    }
}
