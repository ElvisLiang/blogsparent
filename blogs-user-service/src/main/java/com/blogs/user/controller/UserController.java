package com.blogs.user.controller;

import com.blogs.user.entity.Authority;
import com.blogs.user.entity.ResultMessage;
import com.blogs.user.entity.Role;
import com.blogs.user.entity.User;
import com.blogs.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据用户登录名查询用户详细信息
     * @return
     */
    @RequestMapping(value = "/getUser",method = RequestMethod.POST)
    public ResultMessage getUser(@RequestParam("username") String username){
        ResultMessage<User> resultMessage = new ResultMessage<>();
        User user = userService.searchUserByUsername(username);
        resultMessage.setRecord(user);
        return resultMessage;
    }

    /**
     * 根据用户登录名查询用户详细信息
     * @return
     */
    @RequestMapping(value = "/getRoles",method = RequestMethod.POST)
    public ResultMessage getRoles(@RequestParam("uid") int uid){
        ResultMessage<Role> resultMessage = new ResultMessage<>();
       List<Role> roles = userService.searchRolesByUserId(uid);
        resultMessage.setRecords(roles);
        return resultMessage;
    }

    /**
     * 根据用户登录名查询用户详细信息
     * @return
     */
    @RequestMapping(value = "/getAuthoritys",method = RequestMethod.POST)
    public ResultMessage getAuthoritys(@RequestParam("uid") int uid){
        ResultMessage<Authority> resultMessage = new ResultMessage<>();
        List<Authority> authorities = userService.searchAuthorityByUserId(uid);
        resultMessage.setRecords(authorities);
        return resultMessage;
    }
}
