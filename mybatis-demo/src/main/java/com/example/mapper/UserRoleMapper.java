package com.example.mapper;

import com.example.model.UserRoleKey;

public interface UserRoleMapper {
    int deleteByPrimaryKey(UserRoleKey key);

    int insert(UserRoleKey record);

    int insertSelective(UserRoleKey record);
}