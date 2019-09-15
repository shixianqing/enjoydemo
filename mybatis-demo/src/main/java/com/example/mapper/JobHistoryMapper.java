package com.example.mapper;

import com.example.model.JobHistory;

public interface JobHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobHistory record);

    int insertSelective(JobHistory record);

    JobHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobHistory record);

    int updateByPrimaryKey(JobHistory record);
}