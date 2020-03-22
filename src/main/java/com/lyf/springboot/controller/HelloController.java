package com.lyf.springboot.controller;

import com.lyf.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Arrays;
import java.util.Map;

@Controller
@SessionAttributes({"name", "do"})
public class HelloController {

    //    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "user", required = false) String user
            , Model model) {
        if ("aaa".equals(user)) {
            throw new UserNotExistException();
        }
        model.addAttribute("name", "你好");
        model.addAttribute("do", "吃饭");
        return "redirect:/hello1";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("lisi", "wangwu", "zhangsan"));
        return "success";
    }
}
