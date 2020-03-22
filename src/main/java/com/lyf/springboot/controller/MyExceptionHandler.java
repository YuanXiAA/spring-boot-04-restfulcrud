package com.lyf.springboot.controller;

import com.lyf.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>(  );
        //传入我们自己的错误状态码 4XX 5XX
        request.setAttribute( "javax.servlet.error.status_code", 500 );

        map.put("code", "user.notExist");
        map.put("message", e.getMessage());

        request.setAttribute( "ext", map );
        return "forward:/error";
    }
}
