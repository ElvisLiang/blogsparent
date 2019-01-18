package com.blogs.user.dao;

import com.blogs.user.entity.Authority;

import java.util.List;

public interface AuthorityMapper {
    int deleteByPrimaryKey(Integer aId);

    int insert(Authority record);

    int insertSelective(Authority record);

    Authority selectByPrimaryKey(Integer aId);

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);

    /**
     *根据用户uid查询改用户的所有权限
     */
    List<Authority> selectByUid(Integer uId);
}