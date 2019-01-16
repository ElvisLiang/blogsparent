package com.blogs.user.serviceimpl;

import com.blogs.user.entity.Authority;
import com.blogs.user.entity.Role;
import com.blogs.user.entity.User;
import com.blogs.user.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public User searchUserByUsername(String username) {

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
