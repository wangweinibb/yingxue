import com.wangwei.Application;
import com.wangwei.entity.Video;
import com.wangwei.service.VideoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class VideoServiceTest {
    @Autowired
    private VideoService videoService;
    @Test
    public void test1(){
        System.out.println(videoService.findById(1));
    }
    @Test
    public void test2(){
        System.out.println(videoService.findAll(0,4));
    }
    @Test
    public void test3(){
        System.out.println(videoService.findByCount());
    }
    @Test
    public void test4(){
        videoService.addAll(new Video(null,"恐怖","现场直播","/upload/6.mp4","/upload/6.mp4",1,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),1,2,null,null,null,null,null));
    }
}
