import com.wangwei.Application;
import com.wangwei.entity.User;
import com.wangwei.entity.UserDto;
import com.wangwei.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void test1(){
        System.out.println(userService.findById(1));
    }
    @Test
    public void test2(){
        System.out.println(userService.findByCount());
    }
    @Test
    public void test3(){
        List<UserDto> userDtos=new ArrayList<>();
        for (User user:userService.findAll(0,5)){
            if (user.getStatus()==1){
                userDtos.add(new UserDto(user.getId(),user.getUsername(),user.getSign(),user.getHead_img(),user.getPhone(),true,user.getCreate_time(),null,null));
            }
        }
        System.out.println(userDtos);
    }
    @Test
    public void test4(){

    }
}
