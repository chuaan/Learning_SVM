package com.chuaan.springMVC.utils;


import java.security.MessageDigest;

import org.apache.tomcat.util.buf.HexUtils;
import org.springframework.stereotype.Service;

/**
 *
 * author:chuaan
 * created:2018.12.27
 **/



//把密码hash作为一个单例

@Service
public final class SHA256 {

    public String toSHA256(String content) throws Exception{
        MessageDigest messageDigest;
        String endS= "";
        messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hash = messageDigest.digest(content.getBytes("UTF-8"));
        endS = HexUtils.toHexString(hash);

        return endS;
    }


}
