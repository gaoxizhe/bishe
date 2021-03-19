package teeseeee;

import java.util.Scanner;

public class JavaHomeWork {
    public static void main(String[] args) {
        double price = 0;
        int count = 0;
        double total = 0;
        double discount = 0;
        double money = 0;
        String option = "y";
        Scanner input = new Scanner(System.in);
        while (option.equals("y")) {
            System.out.println("请输入商品编号 \n  1:T-shirt; -----100元  \n  2:网球鞋； ---- 700元   \n  3:网球拍 ---- 1000元" );
            int choice = input.nextInt();
            System.out.println("请输入购买数量");
            count = input.nextInt();
            if (choice == 1) {
                price = 100;
                total += price * count;
            } else if (choice == 2) {
                price = 700;
                total += price * count;
            } else if (choice == 3) {
                price = 1000;
                total += price * count;
            } else {
                System.out.println("您输入有误！");
            }
            System.out.println("是否继续购买；y-继续；n-退出");
            option = input.next();
        }
        System.out.println("您本次消费" + total);
        System.out.println("请输入折扣");
        discount = input.nextInt();

        double v = total * (discount / 10);
        System.out.println("您一共需要支付" + v);

        System.out.println("请输入您需要支付的金额：");
        money = input.nextDouble();
        while (money < v) {
            System.out.println("支付金额有误，重新输入");
            money = input.nextDouble();
        }

        System.out.println("找零 ： " + (money - v) );
    }
}
