package com.cnsdhh.ssmmaven.controller;

import com.cnsdhh.ssmmaven.pojo.User;
import com.cnsdhh.ssmmaven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    // 用户登录（POST方式）
    // testURL : http://localhost:8080/static/user/login.html
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody Map login(@RequestBody User user, HttpServletRequest request) {
        BaseController.removeLogin(request);
        Map<String, Object> resultMap = BaseController.getResultMap();
        request.getSession().setAttribute("user", user);
        if (user != null && !"".equalsIgnoreCase(user.getUsername()) && !"".equalsIgnoreCase(user.getPassword())) {
            try {
                User loginUser = userService.login(user.getUsername());
                // 【特别注意】：new BCryptPasswordEncoder().matches("前端传值(未加密)", "数据库取值(已加密)");
                if (loginUser != null && new BCryptPasswordEncoder().matches(user.getPassword(), loginUser.getPassword())) {
                    request.getSession().setAttribute("loginUser", loginUser);
                    resultMap.put("sign", true);
                    resultMap.put("mssg", "成功");
                    return resultMap;
                } else {
                    resultMap.put("mssg", "用户名或密码错误");
                    return resultMap;
                }
            } catch (Exception e) {
                resultMap.put("mssg", "服务器出错");
                return resultMap;
            }
        } else {
            resultMap.put("mssg", "请输入用户名或密码才能登录");
            return resultMap;
        }
    }


    // 用户登录（GET方式）
    // testURL : http://localhost:8080/static/user/login.do?username=admin&password=admin
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public @ResponseBody Map login(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password,
            HttpServletRequest request) {
        BaseController.removeLogin(request);
        Map<String, Object> resultMap = BaseController.getResultMap();
        if (username != null && password != null && !"".equalsIgnoreCase(username) && !"".equalsIgnoreCase(password)) {
            try {
                User loginUser = userService.login(username);
                // 【特别注意】：new BCryptPasswordEncoder().matches("前端传值(未加密)", "数据库取值(已加密)");
                if (loginUser != null && new BCryptPasswordEncoder().matches(password, loginUser.getPassword())) {
                    request.getSession().setAttribute("loginUser", loginUser);
                    resultMap.put("sign", true);
                    resultMap.put("mssg", "成功");
                    return resultMap;
                } else {
                    resultMap.put("mssg", "用户名或密码错误");
                    return resultMap;
                }
            } catch (Exception e) {
                resultMap.put("mssg", "服务器出错");
                return resultMap;
            }
        } else {
            resultMap.put("mssg", "请输入用户名或密码才能登录");
            return resultMap;
        }
    }


    // 用户注册（POST方式）
    // testURL : http://localhost:8080/static/user/register.html
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody Map register(@RequestBody User user, HttpServletRequest request) {
        BaseController.removeLogin(request);
        Map<String, Object> resultMap = BaseController.getResultMap();
        request.getSession().setAttribute("user", user);
        if (user != null && !"".equalsIgnoreCase(user.getUsername()) && !"".equalsIgnoreCase(user.getPassword())) {
            User loginUser = userService.login(user.getUsername());
            if (loginUser == null) {
                System.out.println("加密前的用户 : " + user);
                // 密码加密
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String password = passwordEncoder.encode(user.getPassword());
                user.setPassword(password);
                System.out.println("加密后的用户 : " + user);
                try {
                    Integer status = userService.register(user);
                    return BaseController.ifStatus(status, resultMap);
                } catch (Exception e) {
                    resultMap.put("mssg", "服务器出错");
                    return resultMap;
                }
            } else {
                resultMap.put("mssg", "用户名已存在，请换个别的试试");
                return resultMap;
            }
        } else {
            resultMap.put("mssg", "请输入用户名和密码才能注册");
            return resultMap;
        }
    }

}
