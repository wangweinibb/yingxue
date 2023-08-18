import com.wangwei.Application;
import com.wangwei.entity.Log;
import com.wangwei.entity.LogDto;
import com.wangwei.service.LogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class LogServiceTest {
    @Autowired
    private LogService logService;
    @Test
    public void test1(){
        System.out.println(logService.findById(1));
    }
    @Test
    public void test2(){
        System.out.println(logService.findByCount());
    }
    @Test
    public void test3() {
        List<LogDto> logDtos = new ArrayList<>();
        for (Log logDto : logService.findAll(new Log(null, null, null, null, null, 0, null, 4, "2022-07-15 9:16:17", "2022-07-15 11:16:17"))) {
            logDtos.add(new LogDto(logDto.getId(),logDto.getAdmin_name(),logDto.getCreate_time(),logDto.getMethod_name(),logDto.getOption_status()));
        }
        System.out.println(logDtos);
    }
    @Test
    public void test4(){
        logService.addLog(new Log(null,"root","2022-07-15 10:16:17","addAdmin",1,null,null,null,null,null));
    }
}
