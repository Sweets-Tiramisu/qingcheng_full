package com.qingcheng.consumer;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonResponse;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

public class SmsMessageConsumer implements MessageListener {


    @Autowired
    private SmsUtil smsUtil;

    @Value("${smsCode}")
    private String smsCode;

    @Value("${param}")
    private String param;

    public void onMessage(Message message) {

        String jsonString = new String(message.getBody());
        Map<String,String> map = JSON.parseObject(jsonString, Map.class);

        String phone = map.get("phone");//手机号
        String code = map.get("code");//验证码
        System.out.println("手机号："+phone+" 验证码："+code);

        //调用阿里云通信。。。
        CommonResponse commonResponse = smsUtil.sendSms(phone, smsCode, param.replace("[value]", code));


    }
}
