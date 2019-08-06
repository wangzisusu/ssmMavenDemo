package com.cnsdhh.ssmmaven.service.impl;

import com.cnsdhh.ssmmaven.mapper.StudentDao;
import com.cnsdhh.ssmmaven.pojo.Student;
import com.cnsdhh.ssmmaven.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    // 查询所有记录
    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    // 添加学生信息
    @Override
    public Integer add(Student student) {
        return studentDao.add(student);
    }

    // 删除学生信息
    @Override
    public Integer del(Integer[] ids) {
        //return studentDao.del(ids); // 使用数组时
        return studentDao.del(Arrays.asList(ids)); // 使用集合时
    }

    // 查询一条记录
    @Override
    public Student findOne(Integer id) {
        return studentDao.findOne(id);
    }

    // 修改学生信息
    @Override
    public void change(Student student) {
        studentDao.change(student);
    }

}
