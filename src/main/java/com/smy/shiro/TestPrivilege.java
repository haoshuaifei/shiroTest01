package com.smy.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

import java.util.Arrays;

/**
 * @program: shiroTest01
 * @description
 * @author: 郝帅飞
 * @create: 2020-12-26 12:36
 * @version: 1.0
 **/
public class TestPrivilege {
    public static void main(String[] args) {
        /**
         * 构建SecurityManagerMangetFactory
         * 	从ini配置文件里面初始化SecurityManager环境
         */
        // 创建securityManager工厂，通过ini配置文件创建securityManager工厂
        Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro_privilege.ini");

        //创建SecurityManager
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();

        //蒋SecurityManager设置到运行环境中去
        SecurityUtils.setSecurityManager(securityManager);

        //创建Subject  ini文件里面的
        Subject subject=SecurityUtils.getSubject();

        //创建token  用户的账号密码   自己输入的
        UsernamePasswordToken token=new UsernamePasswordToken("user2", "user2");

        /**
         * 如果token和ini文件里面的账号密码匹配，不报错
         * 		如果不匹配，会产生异常： org.apache.shiro.authc.IncorrectCredentialsException
         */
        try{
            subject.login(token);
        }catch (IncorrectCredentialsException e) {
            // TODO: handle exception
            System.out.println("认证失败");
        }

        //是否认证成功
        boolean b=subject.isAuthenticated();
        System.out.println("是否认证成功:"+b);

        //权限判断
        //该用户是否有某个角色
        boolean b_r=subject.hasRole("role1");
        System.out.println("是否有某一个角色:"+b_r);
        //是否拥有某几个角色
        boolean b_rs=subject.hasAllRoles(Arrays.asList("role1","role2"));
        System.out.println("是否有某几个角色:"+b_rs);

        //使用有某个权限
        boolean b_p=subject.isPermitted("user:update");
        System.out.println("是否有某个权限:"+b_p);
        boolean b_ps=subject.isPermittedAll("user:select","user:update");



        //退出
        subject.logout();  //清空账号密码
        boolean b2=subject.isAuthenticated();
        System.out.println("退出后是否认证成功:"+b2);

    }
}
