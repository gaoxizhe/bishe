package teeseeee.t1.a1;/**
 * @author : Mr.Gao
 * @date :   2020/4/24 上午9:06
 */

/**
 * @ClassName TestMain
 * @Author Mr.Gao
 * @Date 2020/4/24 上午9:06
 * @Description TODO | 
 */
public class TestMain {
    public static void main(String[] args) {
        Flay f1 = new Sparrow("麻雀","翅膀","绿色出行");

        Flay f2 = new Aircraft("飞机","助推器","高科技出行");

        f1.flay();
        System.out.println("----------------------");
        f2.flay();

    }
}
