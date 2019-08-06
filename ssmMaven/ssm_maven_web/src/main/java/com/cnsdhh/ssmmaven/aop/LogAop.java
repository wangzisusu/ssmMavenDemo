package com.cnsdhh.ssmmaven.aop;

import com.cnsdhh.ssmmaven.pojo.Log;
import com.cnsdhh.ssmmaven.pojo.User;
import com.cnsdhh.ssmmaven.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    private final HttpServletRequest request;
    private final LogService logService;

    @Autowired
    public LogAop(HttpServletRequest request, LogService logService) {
        this.request = request;
        this.logService = logService;
    }

    @Around("execution(* com.cnsdhh.ssmmaven.controller.*.*(..))")
    public Object logging(ProceedingJoinPoint pjp) throws Throwable {
        Date start = new Date();
        Object proceed = pjp.proceed();
        long cost = new Date().getTime() - start.getTime();

        String username = "";
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        if (loginUser != null) {
            username = loginUser.getUsername();
        } else {
            username = ((User) request.getSession().getAttribute("user")).getUsername() + "[false]";
        }

        String className = pjp.getTarget().getClass().getName();
        String mothedName = pjp.getSignature().getName();

        Log log = new Log();
        log.setUsername(username);
        log.setTime(new Date());
        log.setUrl("[类名]" + className + "[方法名]" + mothedName);
        log.setCost(cost);

        logService.insertLog(log);

        return proceed;
    }

}
