package com.chuaan.springMVC.account;

import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Commit;

/**
 * 用户类
 * 用户功能的实现和信息保存
 * author:chuaan
 * created:2018.12.28
 */


public class User {
    private long uid = 59442197;

    private String name = "test";
    private Admin admin;
    public User(){
        uid=-1;
        name="";
        admin = new Admin();
    }


    //在未连接数据库前的测试用构造函数
    public User(String name, String hashPW){
        admin = new Admin();
        if(this.name.equals(name) && hashPW.equals("9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08")){
            admin.setUid(this.uid);
            admin.setName(this.name);
            admin.setAdmin(Admin.SUPER);
        }



    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    public Admin getUserAdmin(){
        return admin;

    }

}
