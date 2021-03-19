package com;/**
 * @author : Mr.Gao
 * @date :   2021/3/16 下午11:29
 */

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName password
 * @Author Mr.Gao
 * @Date 2021/3/16 下午11:29
 * @Description TODO |
 */

public class password {

    @Test
    public void generatePass() {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String pass = passwordEncoder.encode("admin");
        System.out.println(pass);

        //  {bcrypt}$2a$10$6I8YaCYCKJv1R/UiWH/oD.WuTPu5SUQoC6b5v9EUUu.9KMr0VGp32
    }
}
