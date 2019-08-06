package com.cnsdhh.ssmmaven.controller;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Component
public class BaseController {

    // 创建一个封装响应消息的集合
    static Map<String, Object> getResultMap() {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("sign", false);
        resultMap.put("mssg", "失败");
        return resultMap;
    }

    // 判断数据库操作结果是否成功，并返回结果集合
    static Map<String, Object> ifStatus(Integer status, Map<String, Object> resultMap) {
        if (status >= 1) {
            resultMap.put("sign", true);
            resultMap.put("mssg", "成功");
            return resultMap;
        } else {
            return resultMap;
        }
    }

    // 从会话中移除登录用户
    static void removeLogin(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("loginUser");
    }

}
