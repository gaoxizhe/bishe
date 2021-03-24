import com.example.util.MyMailUtil;

public class Asdf {
    public static void main(String[] args) {
        int[] a = {3, 4, 5};
        System.out.println(a[1]);

        MyMailUtil myMailUtil = new MyMailUtil("123");
        myMailUtil.sendMail("a.gxz@qq.com");
    }
}
