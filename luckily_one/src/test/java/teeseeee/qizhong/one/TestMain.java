package teeseeee.qizhong.one;/**
 * @author : Mr.Gao
 * @date :   2020/4/17 上午8:20
 */

/**
 * @ClassName TestMain
 * @Author Mr.Gao
 * @Date 2020/4/17 上午8:20
 * @Description TODO | 
 */
public class TestMain {
    public static void main(String[] args) {
        User lucy = new User("Lucy","123","男",21,"2001-1-1","无敌小菜鸟");
        User mary = new User("Mary","123","女",28,"2002-1-1","超级之多星");
        lucy.showMsg();
        mary.showMsg();
    }
}
