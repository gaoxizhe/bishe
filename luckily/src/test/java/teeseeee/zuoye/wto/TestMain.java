package teeseeee.zuoye.wto;/**
 * @author : Mr.Gao
 * @date :   2020/4/14 上午10:46
 */

import java.util.Scanner;

/**
 * @ClassName TestMain
 * @Author Mr.Gao
 * @Date 2020/4/14 上午10:46
 * @Description TODO | 
 */
public class TestMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要制作的批萨，1.培根批萨 2.海鲜批萨");
        int i = sc.nextInt();

        System.out.println("请输入批萨大小");
        int size = sc.nextInt();
        System.out.println("请输入批萨价格");
        double  price = sc.nextDouble();
        if (i == 1) {
            System.out.println("请输入培根数量");
            int total = sc.nextInt();
            PPizza pPizza = new PPizza("培根批萨",price,size,total);
            pPizza.make();
        } else if (i == 2) {
            System.out.println("请输入配料信息");
            String pei = sc.next();
            Hpizza hpizza = new Hpizza("海鲜批萨", price, size, pei);
            hpizza.make();
        }




    }
}
