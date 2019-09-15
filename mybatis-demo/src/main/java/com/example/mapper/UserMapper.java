package com.example.mapper;

import com.example.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectWithPlaceHolder(@Param("userName") String userName, @Param("table") String table,
                               @Param("id") Integer id);

    List<User> batchQueryById(Integer[] ids);

    void batchInsert(List<User> users);

    List<User> selectForChooseOp(@Param("userName") String userName,@Param("id") Integer id);

    User selectForOneToOne(Integer id);
    User selectForOneToOne1(Integer id);

    User selectForOneToMany(Integer id);
    User selectForOneToMany1(Integer id);

    List<User> selectFormanyToMany1(Integer id);
}