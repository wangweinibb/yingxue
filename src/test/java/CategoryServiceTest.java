import com.wangwei.Application;
import com.wangwei.entity.Category;
import com.wangwei.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CategoryServiceTest {
    @Autowired
    private CategoryService categoryService;
    @Test
    public void test1(){
        System.out.println(categoryService.findById(1));
    }
    @Test
    public void test2(){
        System.out.println(categoryService.findByLevels(2,4,4));
    }
    @Test
    public void test3(){
        System.out.println(categoryService.findByParentId(1,4,4,3));
    }
    @Test
    public void test4(){
        System.out.println(categoryService.findByCount(new Category(null,null,1,1,null,null,null)));
    }
    @Test
    public void test5(){
        categoryService.addAll(new Category(null,"编程",1,1,null,null,null));
    }
    @Test
    public void test6(){
        categoryService.changeAll(41,"傻逼");
    }
    @Test
    public void test7(){
        categoryService.removeAll(41);
    }
    @Test
    public void test8() {
        System.out.println(categoryService.removeAll2(40));
    }

}
