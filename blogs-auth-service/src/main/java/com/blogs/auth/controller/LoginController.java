package com.blogs.auth.controller;

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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("user",new User());
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(@ModelAttribute(value="user")User user, Model model){
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
        return "SUCCESS";
    }
}
