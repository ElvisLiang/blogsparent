package com.blogs.user.serviceimpl;

import com.blogs.user.dao.AuthorityMapper;
import com.blogs.user.dao.RoleMapper;
import com.blogs.user.dao.UserMapper;
import com.blogs.user.entity.Authority;
import com.blogs.user.entity.Role;
import com.blogs.user.entity.User;
import com.blogs.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    AuthorityMapper authorityMapper;



    @Override
    public User searchUserByUsername(String username) {
        logger.info("====================>查询客户信息");
        User user = userMapper.selectByUsername(username);
        return user;
    }

    @Override
    public List<Role> searchRolesByUserId(Integer id) {
        logger.info("====================>查询客户所有角色信息");
        List<Role> roles = roleMapper.selectByUid(id);
        return roles;
    }

    @Override
    public List<Authority> searchAuthorityByUserId(Integer id) {
        logger.info("====================>查询客户所有权限信息");
        List<Authority> authorities = authorityMapper.selectByUid(id);
        return authorities;
    }
}
