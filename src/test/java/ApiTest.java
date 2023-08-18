import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wangwei.Application;
import com.wangwei.util.HttpCheckUtility;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static com.wangwei.util.HttpSendUtility.sendGetRequest;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApiTest {
//    发送短信验证码
    @Test
    public void test1(){
        try {
            String url = "http://zhxy.xhe.cn/app/sendMobileMessage";
            String mobile = "19164003508";
            String userId = "0";
            long time = 1690857320330L;
            String digest = "fa0ba21f652ea3adf546307ee37aa17c";
            int random = 724726;
            String response = sendGetRequest(url, mobile, userId, time, digest, random);
            System.out.println(response);
            JsonObject jsonResponse = JsonParser.parseString(response).getAsJsonObject();
            String message = jsonResponse.get("success").getAsString();
            System.out.println("响应消息: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    验证短信验证码
    @Test
    public void test2(){
        try {
            String url = "http://zhxy.xhe.cn/app/registerorlogin";
            String mobile="19164003508";
            String code="924128";
            String queryString = "mobile="+mobile+"&code="+code+"&regType=mobileFrom";
            String response = HttpCheckUtility.sendGetRequest(url, queryString);
            System.out.println(response);
            JsonObject jsonResponse = JsonParser.parseString(response).getAsJsonObject();
            String errorMessage = jsonResponse.get("success").getAsString();
            System.out.println("响应消息: " + errorMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
