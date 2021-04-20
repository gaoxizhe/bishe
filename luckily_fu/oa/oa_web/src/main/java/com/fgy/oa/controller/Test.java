package com.fgy.oa.controller;/**
 * @author : Mr.Gao
 * @date :   2021/4/20 下午3:11
 */

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @ClassName Test
 * @Author Mr.Gao
 * @Date 2021/4/20 下午3:11
 * @Description TODO | 
 */
public class Test {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("/assets/admin-tools/admin-forms/css/admin-forms.css");
        a.add("/assets/skin/default_skin/css/theme.css");
        a.add("/assets/js/utility/utility.js");
        a.add("/vendor/jquery/jquery-1.11.1.min.js");
        a.add("/vendor/jquery/jquery_ui/jquery-ui.min.js");
        String reg = "(/assets/|/vendor/)([\\s\\S]*?)(.js|.css)";
        for (String s : a) {
            if (Pattern.matches(reg,s)) {
                System.err.println(s);
            }
        }
    }
}
