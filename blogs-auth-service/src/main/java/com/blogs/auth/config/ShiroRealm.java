package com.blogs.auth.config;

import com.blogs.auth.feignclient.UserClient;
import com.blogs.auth.utils.ConvertUtils;
import com.blogs.user.entity.Authority;
import com.blogs.user.entity.ResultMessage;
import com.blogs.user.entity.Role;
import com.blogs.user.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class ShiroRealm extends AuthorizingRealm{

    @Autowired
    private UserClient userClient;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user = (User) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        ResultMessage<Role> resultRoles = userClient.getRoles(user.getuId());
        List<Role> rolesList = resultRoles.getRecords();
        Set roles = new HashSet<String>();
        for(Role role:rolesList){
            roles.add(role.getName());
        }
        ResultMessage<Authority> resultAuthorities = userClient.getRoles(user.getuId());
        List<Authority> authoritiesList = resultAuthorities.getRecords();
        Set authorities = new HashSet<String>();
        for(Authority authority:authoritiesList){
            authorities.add(authority.getUrl());
        }
        simpleAuthorizationInfo.setStringPermissions(authorities);
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        ResultMessage<User> resultMessage = userClient.getUser(username);
        User user = ConvertUtils.objectMapper.convertValue(resultMessage.getRecord(),User.class);
        SimpleHash simpleHash = new SimpleHash("MD5","123456",ByteSource.Util.bytes(String.valueOf(user.getSalt())),1024);
        System.out.println("------------------"+simpleHash.toString());
        SimpleAuthenticationInfo simpleAuthorizationInfo = new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(), ByteSource.Util.bytes(String.valueOf(user.getSalt())),getName());
        return simpleAuthorizationInfo;
    }
}
