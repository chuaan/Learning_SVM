package com.chuaan.springMVC.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class SHA256Test {

    @Test
    public void toSHA256() {
        SHA256 sha256 = new SHA256();
        String result = null;
        try {
            result = sha256.toSHA256("abc");
        }catch (Exception e){
            e.printStackTrace();
        }
        assertEquals(result,"ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad");
    }
}