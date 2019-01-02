package com.chuaan.springMVC.login;

import com.chuaan.springMVC.account.Admin;
import com.chuaan.springMVC.account.User;
import org.springframework.stereotype.Repository;

import java.sql.*;


/**
 * 用于login时的数据库连接
 * author:chuaan
 * created:2018.12.28
 */

public class LoginDao {

    //根据用户名和密码 返回用户信息
    public static User getUserDao(String name, String hashPW){
        Connection conn=null;
        User user = new User();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            long start =System.currentTimeMillis();
            // 建立连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys",
                    "root", "Mysql");
            long end = System.currentTimeMillis();
            System.out.println(conn);
            System.out.println("建立连接耗时： " + (end - start) + "ms 毫秒");

            // 创建Statement对象
            PreparedStatement psmt = conn.prepareStatement("SELECT uid,admin FROM User where name = ? AND hashpw = ?");

            psmt.setString(1, name);
            psmt.setString(2, hashPW);



            // 执行SQL语句
            ResultSet rs = psmt.executeQuery();


            if(rs.next()){
                user.setUid(rs.getLong(1));
                user.setName(name);
                Admin admin = new Admin(rs.getInt(2),user.getName(),user.getUid());
                user.setAdmin(admin);
            }
            // 关闭连接
            if (rs != null) {
                rs.close();
            }

            if (psmt != null) {
                psmt.close();
            }
            if (conn != null) {
                conn.close();
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }



}
