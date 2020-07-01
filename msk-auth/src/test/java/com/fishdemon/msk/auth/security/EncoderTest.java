package com.fishdemon.msk.auth.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Anjin.Ma
 * @description EncoderTest
 * @date 2020/6/30
 */
public class EncoderTest {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashPass = encoder.encode("123456");
        System.out.println(hashPass);
        System.out.println(encoder.encode("123456"));
        System.out.println(encoder.matches("123456", hashPass));
    }

}
