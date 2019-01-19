package com.blogs.auth.feignclient;

import com.blogs.user.entity.ResultMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("blogs-user-service")
public interface UserClient {

    /**
     * 根据用户登录名查询用户详细信息
     * @return
     */
    @RequestMapping(value = "/getUser",method = RequestMethod.POST)
    public ResultMessage getUser(@RequestParam("username") String username);

    /**
     * 根据用户登录名查询用户详细信息
     * @return
     */
    @RequestMapping(value = "/getRoles",method = RequestMethod.POST)
    public ResultMessage getRoles(@RequestParam("uid") int uid);

    /**
     * 根据用户登录名查询用户详细信息
     * @return
     */
    @RequestMapping(value = "/getAuthoritys",method = RequestMethod.POST)
    public ResultMessage getAuthoritys(@RequestParam("uid") int uid);
}
