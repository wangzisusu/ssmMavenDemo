package com.cnsdhh.test;

import com.cnsdhh.ssmmaven.mapper.LogDao;
import com.cnsdhh.ssmmaven.mapper.StudentDao;
import com.cnsdhh.ssmmaven.mapper.UserDao;
import com.cnsdhh.ssmmaven.pojo.Log;
import com.cnsdhh.ssmmaven.pojo.Student;
import com.cnsdhh.ssmmaven.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-dao.xml")
public class DaoTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void studentDaoFindAll() {
        List<Student> studentList = studentDao.findAll();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void studentDaoFindOne() {
        Student student = studentDao.findOne(2);
        System.out.println(student);
    }

//    @Test
//    public void studentDaoAdd() {
//        Student student = new Student();
//        student.setName("测试1");
//        student.setSex(1);
//        student.setAge(23);
//        student.setAddress("郑州");
//        Integer status = studentDao.add(student);
//        // 返回值是“1”为成功，其它为失败
//        System.out.println(status);
//    }

//    @Test
//    public void studentDaoDel() {
//        Integer[] ids = {8,9,10};
//        Integer status = studentDao.del(Arrays.asList(ids));
//        // 返回值是“正整数”为成功，其它为失败
//        System.out.println(status);
//    }

//    @Test
//    public void studentDaoChange() {
//        Student student = new Student();
//        student.setId(2);
//        student.setName("哈哈");
//        student.setSex(1);
//        student.setAge(33);
//        student.setAddress("郑州");
//        studentDao.change(student);
//    }

    @Autowired
    private LogDao logDao;

//    @Test
//    public void logDaoInsert() {
//        Log log = new Log();
//        log.setUsername("dao");
//        log.setTime(new Date());
//        log.setUrl("test dao ....");
//        log.setCost(100);
//        logDao.insertLog(log);
//    }

    @Autowired
    private UserDao userDao;

    @Test
    public void userDaoLogin() {
        User loginUser = userDao.login("haohao");
        System.out.println(loginUser);
    }

//    @Test
//    public void userDaoRegister() {
//        User user = new User();
//        user.setUsername("test1");
//        user.setPassword("111111");
//        Integer status = userDao.register(user);
//        // 返回值是“1”为成功，其它为失败
//        System.out.println(status);
//    }




}
