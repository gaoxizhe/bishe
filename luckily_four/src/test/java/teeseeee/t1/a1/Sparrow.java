package teeseeee.t1.a1;/**
 * @author : Mr.Gao
 * @date :   2020/4/24 上午9:02
 */

/**
 * @ClassName Sparrow
 * @Author Mr.Gao
 * @Date 2020/4/24 上午9:02
 * @Description TODO | 
 */
public class Sparrow implements Flay {
    private String name;
    private String have;
    private String msg;

    public Sparrow(String name, String have, String msg) {
        this.name = name;
        this.have = have;
        this.msg = msg;
    }

    @Override
    public void flay() {
        System.out.println("我是:" + name + ", 我有：" + have + ", " + msg);
    }
}
