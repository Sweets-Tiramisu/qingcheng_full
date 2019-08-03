package com.qingcheng.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.wxpay.sdk.Config;
import com.github.wxpay.sdk.WXPayRequest;
import com.github.wxpay.sdk.WXPayUtil;
import com.qingcheng.service.order.OrderService;
import com.qingcheng.service.order.WxPayService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
@Service
public class WxPayServiceImpl implements WxPayService {

    @Autowired
    private Config config;

    @Override
    public Map createNative(String orderId, Integer money, String notifyUrl) {

        try {
            //1.封装请求参数
            Map<String,String> map=new HashMap();
            map.put("appid",config.getAppID());//公众账号ID
            map.put("mch_id",config.getMchID());//商户号
            map.put("nonce_str", WXPayUtil.generateNonceStr());//随机字符串
            map.put("body","青橙");//商品描述
            map.put("out_trade_no",orderId);//订单号
            map.put("total_fee",money+"");//金额
            map.put("spbill_create_ip","127.0.0.1");//终端IP
            map.put("notify_url",notifyUrl);//回调地址
            map.put("trade_type","NATIVE");//交易类型
            String xmlParam  = WXPayUtil.generateSignedXml(map, config.getKey());
            System.out.println("参数："+xmlParam);

            //2.发送请求
            WXPayRequest wxPayRequest=new WXPayRequest(config);
            String xmlResult = wxPayRequest.requestWithCert("/pay/unifiedorder", null, xmlParam, false);
            System.out.println("结果："+xmlResult);

            //3.解析返回结果
            Map<String, String> mapResult = WXPayUtil.xmlToMap(xmlResult);

            Map m=new HashMap();
            m.put("code_url", mapResult.get("code_url"));
            m.put("total_fee",money+"");
            m.put("out_trade_no",orderId);
            return m;

        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap();
        }
    }


    @Autowired
    private OrderService orderService;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Override
    public void notifyLogic(String xml) {

        try {
            //1.对xml进行解析 map
            Map<String, String> map = WXPayUtil.xmlToMap(xml);
            //2.验证签名
            boolean signatureValid = WXPayUtil.isSignatureValid(map, config.getKey());

            System.out.println("验证签名是否正确："+signatureValid);
            System.out.println(map.get("out_trade_no"));
            System.out.println(map.get("result_code"));

            //3.修改订单状态
            if(signatureValid){
                if("SUCCESS".equals(map.get("result_code"))){
                    orderService.updatePayStatus( map.get("out_trade_no"),map.get("transaction_id") );
                    //发送消息给mq
                    rabbitTemplate.convertAndSend("paynotify","",map.get("out_trade_no"));
                }else{
                    //记录日志
                }
            }else{
                //记录日志
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map queryPayStatus(String orderId) {

        try {
            //1.封装参数
            Map<String,String> param=new HashMap<>();
            param.put("appid",config.getAppID());
            param.put("mch_id",config.getMchID());
            param.put("out_trade_no",orderId);
            param.put("nonce_str",WXPayUtil.generateNonceStr());
            String xmlParam = WXPayUtil.generateSignedXml(param, config.getKey());

            //2.调用接口
            WXPayRequest wxPayRequest=new WXPayRequest(config);
            String result = wxPayRequest.requestWithCert("/pay/orderquery", null, xmlParam, false);

            //3.解析结果
            Map<String, String> map = WXPayUtil.xmlToMap(result);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


}
