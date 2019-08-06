package com.cnsdhh.ssmmaven.controller;

import com.cnsdhh.ssmmaven.pojo.Student;
import com.cnsdhh.ssmmaven.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    // testURL : http://localhost:8080/static/student/test.do?name=中国
    @RequestMapping("/test")
    @ResponseBody
    public String test(String name, HttpServletResponse response) throws UnsupportedEncodingException {
        System.out.println(name);
//        String string = new String(name.getBytes("UTF-8"), "ISO-8859-1");
//        System.out.println(string);
//        response.setCharacterEncoding("UTF-8");
//        response.setHeader("Content-Type", "text/html;charset=UTF-8");
//        return string;
        return name;
    }



    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // 查询所有记录
    @RequestMapping("/findAll")
    public @ResponseBody String findAll() throws JsonProcessingException {
        List<Student> studentList = studentService.findAll();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(studentList);
    }

    // 添加学生信息
    // testURL : http://localhost:8080/static/student/add.do?name=测试2&sex=0&age=33&address=宁波
    @RequestMapping("/add")
    @ResponseBody
    public Map add(@RequestBody Student student) {
        System.out.println(student);
        Map<String, Object> resultMap = BaseController.getResultMap();
        try {
            Integer status = studentService.add(student);
            return BaseController.ifStatus(status, resultMap);
        } catch (Exception e) {
            return resultMap;
        }
    }

    // 删除学生信息
    @RequestMapping("/del")
    @ResponseBody
    public Map del(Integer[] ids) {
        System.out.println(Arrays.toString(ids));
        Map<String, Object> resultMap = BaseController.getResultMap();
        try {
            Integer status = studentService.del(ids);
            return BaseController.ifStatus(status, resultMap);
        } catch (Exception e) {
            return resultMap;
        }
    }

    // 查询一条记录
    @RequestMapping("/findOne")
    @ResponseBody
    public Student findOne(Integer id) {
        return studentService.findOne(id);
    }

    // 修改学生信息
    @RequestMapping("/change")
    @ResponseBody
    public Map change(@RequestBody Student student) {
        System.out.println(student);
        Map<String, Object> resultMap = BaseController.getResultMap();
        try {
            studentService.change(student);
            return BaseController.ifStatus(1, resultMap);
        } catch (Exception e) {
            return resultMap;
        }
    }

}
