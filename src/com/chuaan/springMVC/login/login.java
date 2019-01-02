package com.chuaan.springMVC.login;

import com.chuaan.springMVC.account.User;
import com.chuaan.springMVC.utils.SHA256;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.chuaan.springMVC.account.Admin;

import javax.servlet.http.HttpSession;

/**
 * 用于学习spring MVC 并用此来自建一个可登录的系统
 * 目标：
 * 用户输入账户密码登陆
 * 有一个注册页面
 * 根据session保持登陆状态
 * 可退出登陆
 * 账户信息可持续保存
 *
 *
 * version 0.1
 * 2018.12.28 16:45
 * 界面极其简陋
 * 可登录
 * 可维持登陆状态
 * 不可注册
 * 密码用SHA256hash
 * 没使用盐值
 * 密码传输并没有加密
 * 密码在传输到服务器后hash
 * 没有防用户名的sql注入
 * 通过JDBC链接数据库
 * 数据库中只有一张用户表
 * dao层是直接static的 并没使用到Spring
 * User和Admin完全耦合在了一起
 * SHA256hash后用string保存的数据，占空间大
 * 未提供退出登陆
 * 界面跳转是服务器端跳转，应当使用redirect
 * 数据库密码直接写死在了代码里
 * 很多地方使用了magic String
 * 前后端未分离
 *
 *
 * author: chuaan
 * created:2018.12.27
 **/

//login controller 进入网页时调用loginGet来判断是否已经登陆 输入账号密码后调用loginPost来登陆
@Controller
public class login {


    @Autowired
    private SHA256 sha256;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet(HttpSession session,
                           @RequestParam(required = false, value = "message", defaultValue = "") String message) {
        Admin admin = (Admin)session.getAttribute("Current_Admin");
        if(admin!=null && admin.getAdmin()<Admin.REJECT){
            return "AlreadyLogin";
        }

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(HttpSession session,
                            @RequestParam("username") String name,
                            @RequestParam("password") String password){
        String hashPW = null;
        try{
            hashPW = sha256.toSHA256(password);

        }catch (Exception e){
            e.printStackTrace();
        }

        User user = LoginDao.getUserDao(name, hashPW);
        Admin admin = user.getUserAdmin();
        if(admin.getAdmin()<Admin.REJECT){
            session.setAttribute("Current_Admin",admin);
            return "mainpage";
        }
  //      if(name.equals("test") && hashPW.equals("9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08")){
    //        return "mainpage";
      //  }
        return "say";
    }

}
