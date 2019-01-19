package test;

import com.blogs.user.BlogsUserApplication;
import com.blogs.user.dao.UserMapper;
import com.blogs.user.entity.Authority;
import com.blogs.user.entity.Role;
import com.blogs.user.entity.User;
import com.blogs.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogsUserApplication.class)
public class ServiceTest {

    @Autowired
    private UserService userService;


    @Test
    public void test(){
        List<Authority> authorities = userService.searchAuthorityByUserId(1);
        List<Role> roles = userService.searchRolesByUserId(1);
        //User user = userMapper.selectByUsername("admin");
        System.out.println("============111");
    }
}
