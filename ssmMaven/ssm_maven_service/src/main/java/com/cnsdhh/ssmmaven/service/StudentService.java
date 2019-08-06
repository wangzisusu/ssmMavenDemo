package com.cnsdhh.ssmmaven.service;

import com.cnsdhh.ssmmaven.pojo.Student;

import java.util.List;

public interface StudentService {

    // 查询所有记录
    public List<Student> findAll();

    // 添加学生信息
    public Integer add(Student student);

    // 删除学生信息
    public Integer del(Integer[] ids);

    // 查询一条记录
    public Student findOne(Integer id);

    // 修改学生信息
    public void change(Student student);

}
