package com.tensquare.user.service;

import com.tensquare.user.dao.UserDao;
import com.tensquare.user.pojo.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private IdWorker idWorker;

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

    //发送短信
    public void sendSms(String mobile) {
        //创建随机数
        String checkCode = RandomStringUtils.randomNumeric(4);
        //放入缓存中一份
        this.redisTemplate.opsForValue().set("checkCode_"+mobile,checkCode,6, TimeUnit.HOURS);
        //发给用户一份
        Map<String,String> map = new HashMap<>();
        map.put("mobile",mobile);
        map.put("checkCode",checkCode);
        this.rabbitTemplate.convertAndSend("sms",map);

        //控制台打印一份
        System.out.println("验证码为: "+checkCode);

    }

    //注册
    public void register(String code, User user) {
        String checkCodeModel = (String) this.redisTemplate.opsForValue().get("checkCode_" + user.getMobile());
        if(code.isEmpty()){
            throw new RuntimeException("请点击获取验证码");
        }
        if(!checkCodeModel.equals(code)){
            throw new RuntimeException("验证码错误,请重新输入");
        }

        user.setId( idWorker.nextId()+"" );
        user.setFollowcount(0);//关注数
        user.setFanscount(0);//粉丝数
        user.setOnline(0L);//在线时长
        user.setRegdate(new Date());//注册日期
        user.setUpdatedate(user.getRegdate());//更新日期
        user.setLastdate(user.getRegdate());//最后登陆日期

        //保存
        this.userDao.save(user);
    }
}
