package com.example.demo.controller;


import com.example.demo.pojo.User;
import com.example.demo.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

@Controller
public class LoginController {

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser){
        //对html转义
        String username = requestUser.getUsername();
        String password = requestUser.getPassword();
        username = HtmlUtils.htmlEscape(username);

        if(!Objects.equals("admin",username) || !Objects.equals("123456",password)){
            String message = "账号密码错误";
            System.out.println("test");
            return new Result(400);
        }else{
            return  new Result(200);
        }
    }

}
