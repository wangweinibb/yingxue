import com.wangwei.Application;
import com.wangwei.entity.Admin;
import com.wangwei.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AdminServiceTest {
    @Autowired
    private AdminService adminService;

    @Test
    public void test1() {
        System.out.println(adminService.findAll());
    }
    @Test
    public void test2(){
        System.out.println(adminService.findByUsername("admin"));
    }
    @Test
    public void test3(){
        System.out.println(adminService.findByUsernameAndPassword("admin","123456"));
    }
    @Test
    public void test4(){
        List<Admin> results=adminService.findByPageAndSize(0,5);
        for (Admin result:results){
            System.out.println(result.getUsername());
        }
    }
    @Test
    public void test5(){
        System.out.println(adminService.findByCount());
    }
    @Test
    public void test6(){
        adminService.addAdmin(new Admin(null,"2b","2b",null,new Date(),null,null,null));
    }
    @Test
    public void test7(){
        adminService.changeAdmin(new Admin(8,null,"goudan",null,null,null,null,null));
    }
    @Test
    public void test8(){
        adminService.removeAdmin(7);
    }
}
