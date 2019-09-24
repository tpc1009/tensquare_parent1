package com.tensquare.sms.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "sms")
public class SmsListener {

    /**
     * 发送短信
     */
    @RabbitHandler
    public void sendSms(Map<String,String> map){
        System.out.println("手机号是: "+map.get("mobile"));
        System.out.println("验证码是: "+map.get("checkCode"));

        //阿里云短信验证
    }
}
