package com.blogs.user.dao;

import com.blogs.user.entity.Role;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * 根据用户id查询用户所有角色
     * @param uId
     * @return
     */
    List<Role> selectByUid(Integer uId);
}