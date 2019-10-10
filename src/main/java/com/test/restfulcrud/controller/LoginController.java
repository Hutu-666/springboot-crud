package com.test.restfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    //@RequestMapping(value = "user/login", method = RequestMethod.POST)
    @PostMapping(value = "user/login")
    public String login(@RequestParam("username")String username, @RequestParam("password")String password,
                        Map<String, Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(username) && password.equals("123456")) {
            session.setAttribute("user", username);
            return "redirect:/main.html";
        } else {
            map.put("message", "用户名或密码错误");
            return "login";
        }

    }
}