package com.blogs.user.dao;

import com.blogs.user.entity.Authority;

public interface AuthorityMapper {
    int deleteByPrimaryKey(Integer aId);

    int insert(Authority record);

    int insertSelective(Authority record);

    Authority selectByPrimaryKey(Integer aId);

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);
}