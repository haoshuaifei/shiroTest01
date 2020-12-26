package com.smy.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: shiroTest01
 * @description
 * @author: 郝帅飞
 * @create: 2020-12-26 14:11
 * @version: 1.0
 **/
@Controller("/shiro")
public class LoginController {
    @RequestMapping("/login.action")
    public String login(String username,String password){
        //第一次可能没有值
        if(username==null){
            //返回登陆页面
            return "login";
        }
        //把UsernamePassword放到token里面
        UsernamePasswordToken token=new UsernamePasswordToken(username, password);

        //获取subject
        Subject subject= SecurityUtils.getSubject();

        //登陆
        try{
            //认证成功
            subject.login(token);
            //登陆成功页面
            return "success";
        }catch (IncorrectCredentialsException e) {
            //认证失败   -到登录页面
            return "login";
        }
    }

}
