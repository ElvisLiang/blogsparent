package com.blogs.auth.controller;

import com.blogs.auth.utils.ConvertUtils;
import com.blogs.user.entity.User;
import com.blogs.user.serviceimpl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.OutputStream;

@Controller
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);



    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("user",new User());
        return "login";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Model model){
        return "/HTML/index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@ModelAttribute(value="user")User user, Model model, HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try{
            subject.login(usernamePasswordToken);
        }catch(IncorrectCredentialsException e){
            logger.error("用户名或密码输入有误！");
            return "Fail";
        }catch(LockedAccountException e){
            logger.error("用户名或密码输入有误！");
            return "Fail";
        }catch(AuthenticationException e){
            logger.error("用户名或密码输入有误！");
            return "Fail";
        }catch(Exception e){
            logger.error("其他登陆异常错误！");
            return "Fail";
        }
        HttpSession session = request.getSession();
        User user2 = (User)subject.getPrincipal();
        //ConvertUtils.blobConvertPicture(user2.getPictureBlob(),request,"sdfsdf");
        session.setAttribute("user",(User)subject.getPrincipal());
        /*ConvertUtils convertUtils = new ConvertUtils();
        convertUtils.blobConvertPicture(user2.getPictureBlob(),user2.getUsername());*/
        return "redirect:index";
    }

    @RequestMapping("headpicture")
    public void showPicture(HttpServletRequest request, HttpServletResponse response){

        try{
            FileInputStream is = new FileInputStream("F");
            int i = is.available(); // 得到文件大小
            byte data[] = new byte[i];
            is.read(data); // 读数据
            is.close();
            response.setContentType("image/*"); // 设置返回的文件类型
            OutputStream toClient = response.getOutputStream(); // 得到向客户端输出二进制数据的对象
            toClient.write(data); // 输出数据
            toClient.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping("layout")
    @ResponseBody
    public Boolean layout(HttpServletRequest request,HttpServletResponse response){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return true;
    }
}
