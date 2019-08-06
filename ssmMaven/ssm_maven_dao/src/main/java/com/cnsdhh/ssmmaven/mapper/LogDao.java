package com.cnsdhh.ssmmaven.mapper;

import com.cnsdhh.ssmmaven.pojo.Log;
import org.apache.ibatis.annotations.Insert;

public interface LogDao {

    // 日志插入
    @Insert("insert into t_log values (#{id}, #{username}, #{time}, #{url}, #{cost})")
    public void insertLog(Log log);

}
