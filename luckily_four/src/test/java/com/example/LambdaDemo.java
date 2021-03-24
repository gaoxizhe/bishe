package com.example;
/*
 *  @author : Mr.Gao
 *  @date :   2020/3/25 下午6:14
 */

/**
 * @ClassName LambdaDemo
 * @Author Mr.Gao
 * @Date 2020/3/25 下午6:14
 * @Description
 */
public class LambdaDemo {
    interface printMethod{
        void printer(String val);
    };

    public void printSomething(String something, printMethod printMethod) {
        printMethod.printer(something);
    }

    public static void main(String[] args) {
        String some = "sdfjlsd lfkjdlf ";


        printMethod printMethod = new printMethod() {
            @Override
            public void printer(String val) {
                System.out.println(val);
            }
        };

        LambdaDemo lambdaDemo = new LambdaDemo();
        lambdaDemo.printSomething(some, System.out::println);

    }


}
