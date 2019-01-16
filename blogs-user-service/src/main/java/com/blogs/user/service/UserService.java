package com.blogs.user.service;

import com.blogs.user.entity.Authority;
import com.blogs.user.entity.Role;
import com.blogs.user.entity.User;

import java.util.List;

public interface UserService {
    /**
     *查询用户详细信息
     */
     User searchUserByUsername(String username);

    /**
     *根据用户id查询该用户所拥有的角色
     */
    List<Role> searchRolesByUserId(Integer id);

    /**
     *根据用户id查询该用户拥有的权限
     */
     List<Authority> searchAuthorityByUserId(Integer id);

}
