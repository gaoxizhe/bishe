package teeseeee.qizhong.three;/**
 * @author : Mr.Gao
 * @date :   2020/4/17 上午8:24
 */

import java.util.Scanner;

/**
 * @ClassName TestMain
 * @Author Mr.Gao
 * @Date 2020/4/17 上午8:24
 * @Description TODO |
 */
public class TestMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个值：");
        int i = sc.nextInt();
        while (i <= 0) {
            System.out.println("输入有误，重新输入 ");
            i = sc.nextInt();
        }
        System.out.println("根据这个值可以输出已下加法表 ： ");
        for (int j = 0; j <= i; j++) {
            for (int k = 0; k <=i; k++) {
                if (j + k == i) {
                    System.out.println(j + " + " + k + " = " + i);
                }
            }
        }

    }
}
