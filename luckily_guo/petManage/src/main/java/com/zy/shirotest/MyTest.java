package com.zy.shirotest;

import com.zy.utils.MD5Utils;
import org.junit.Test;

public class MyTest {

    @Test
    public void test()throws Exception {
        System.out.println("MyTest.test:"+ MD5Utils.getMD5Password("15975400724","15975400724").toString());
    }
}
