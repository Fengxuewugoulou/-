package com.lhxm.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * @author: agoi
 * @date 2019/10/10 19:14
 */
public class SendSms {
    public static String sendSms(String phone) throws ClientException {
        System.setProperty("sun.net.client.defaultConnectTimeout", "60000");
        System.setProperty("sun.net.client.defaultReadTimeout", "60000");
        final String product = "Dysmsapi";
        final String domain = "dysmsapi.aliyuncs.com";

//将 SendKeyUtil.ACCESSKEY_ID  替换成你的accessKeyId
        final String accessKeyId = "LTAI4FxfWiN1fKNDxQKn5HRd";
//将 SendKeyUtil.ACCESSKEY_SECRET 替换成你的accessKeySecret
        final String accessKeySecret = "dEVkt6PS7urXyCCQPdxEAQ9bOXscUG";
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
                accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        SendSmsRequest request = new SendSmsRequest();

        request.setMethod(MethodType.POST);
        
		//phone,调用此方法需要传入的值
        request.setPhoneNumbers(phone);
        //短信签名-可在短信控制台中找到
        request.setSignName("风雪无垢楼主");
        //短信模板-可在短信控制台中找到，发送国际/港澳台消息时，请使用国际/港澳台短信模版
        request.setTemplateCode("SMS_175125014");
        
        int sendCode = (int) ((Math.random() * 9 + 1) * 100000);
        String code= sendCode+"";
        request.setTemplateParam("{\"code\":\""+code+"\"}");
		
		//  -aoi- 测试无影响,随意修改
        request.setOutId("-aoi-");
		
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
			//请求成功,返回值为code
            return code;
        }else {
            System.out.println("状态"+sendSmsResponse.getCode());
            System.out.println(sendSmsResponse.getMessage());
            return "error";
        }
    }
}
