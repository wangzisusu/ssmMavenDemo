package com.cnsdhh.test;

import com.cnsdhh.ssmmaven.pojo.Log;
import com.cnsdhh.ssmmaven.pojo.Student;
import com.cnsdhh.ssmmaven.service.LogService;
import com.cnsdhh.ssmmaven.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-service.xml")
public class ServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void studentServiceFindAll() {
        List<Student> studentList = studentService.findAll();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void studentServiceFindOne() {
        Student student = studentService.findOne(3);
        System.out.println(student);
    }

//    @Autowired
//    private LogService logService;
//
//    @Test
//    public void logServiceInsert() {
//        Log log = new Log();
//        log.setUsername("service");
//        log.setTime(new Date());
//        log.setUrl("test service ...");
//        log.setCost(200);
//        logService.insertLog(log);
//    }

}
