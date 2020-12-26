package com.smy.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: shiroTest01
 * @description
 * @author: 郝帅飞
 * @create: 2020-12-26 12:00
 * @version: 1.0
 **/
public class MyRealm extends AuthorizingRealm {

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        //根据用户名查权限（角色，权限）
        //获取账号信息
        String userame=(String) principals.getPrimaryPrincipal();

        //查角色获取权限
        //模拟一个权限

        //从数据库里查询的权限
        List<String> ps=new ArrayList<String>();
        ps.add("user:create");
        ps.add("user:update");
        ps.add("user:select");
        //从数据库里查询角色

        //把权限信息封装到
        SimpleAuthorizationInfo info=new
                SimpleAuthorizationInfo();

        for (String string : ps) {
            //添加的是角色
            //info.addRole(role1);
            //添加权限
            info.addStringPermission(string);
        }
        return info;

    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // TODO Auto-generated method stub
        /**
         *
         * 从subject.login（token）开始执行
         * 	1.token是用户输入的（usernamem,password）
         * 	2.执行到MYrealm里面进行认证
         *  3.获取用户输入的username,
         * 	如果账号存在，更加账号查询密码
         * 			把账号密码封装到SimpleAuthenticationInfo （username,password）数据库里的
         * 4.与token对比
         */


        //token是用户输入的账号信息
        //用户输入的
        String username=(String) token.getPrincipal();

        //根据用户输出的username去数据库里面查  ,成功是true,失败是false
        //模拟  失败
        if(false){
            return null;
        }

        //如果执行到这里，说明，账号存在  ，根据账号查询密码
        //查询的客户号
        String password="user1";
        SimpleAuthenticationInfo info=
                new SimpleAuthenticationInfo(username, password, "myRealm");

        return info;

    }
}
