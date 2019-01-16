package com.blogs.user.serviceimpl;

import com.blogs.user.dao.AuthorityMapper;
import com.blogs.user.dao.RoleMapper;
import com.blogs.user.dao.UserMapper;
import com.blogs.user.entity.Authority;
import com.blogs.user.entity.Role;
import com.blogs.user.entity.User;
import com.blogs.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    AuthorityMapper authorityMapper;


    @Override
    public User searchUserByUsername(String username) {
        userMapper.selectByUsername(username);
        return null;
    }

    @Override
    public List<Role> searchRolesByUserId(Integer id) {
        return null;
    }

    @Override
    public List<Authority> searchAuthorityByUserId(Integer id) {
        return null;
    }
}
