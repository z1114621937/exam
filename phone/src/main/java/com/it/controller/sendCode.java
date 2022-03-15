package com.it.controller;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.it.Result.CommonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sendCode{

    // 以下为测试代码，随机生成验证码
    private static int newcode;
    // 随机生成的4位验证码
    public static int getNewcode() {
        return newcode;
    }
    // 4位随机数
    public static void setNewcode() {
        newcode = (int) (Math.random() * 9999) + 100;  //每次调用生成一次四位数的随机数
    }


    // 产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    // 产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    static final String accessKeyId = "LTAI5t6YE1EgtVRSbjrZsupX";
    static final String accessKeySecret = "v4aBxYBywPGEkNaMTWBQWLtDe4gYgz"; // TODO 改这里

    /**phone为测试接收验证码的手机号*/
    @RequestMapping("/phone")
    public   CommonResult send2(String phone) throws ClientException {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        //拿验证码
        setNewcode();
        String code = Integer.toString(getNewcode());
       // System.out.println(code);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName","松的网站");
        request.putQueryParameter("TemplateCode", "SMS_235792954");
        request.putQueryParameter("TemplateParam", "{\"code\":"+code+"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            // 拿所有数据
             System.out.println(response.getData());
           //拿状态
            if(response.getHttpStatus()==200)
            {
                return new CommonResult<>(200,"验证码发送成功",code);
            }
            return new CommonResult<>(100, "发送失败",null);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }
}




