package teeseeee.zuoye.wto;/**
 * @author : Mr.Gao
 * @date :   2020/4/14 上午10:54
 */

/**
 * @ClassName PPizza
 * @Author Mr.Gao
 * @Date 2020/4/14 上午10:54
 * @Description TODO | 
 */
public class PPizza extends Pizza{
    private int total;

    public PPizza(String name ,double price ,int size ,int total) {
        super.name = name;
        super.price= price;
        super.size = size;

        this.total = total;
    }

    @Override
    void make() {
        super.make();
        System.out.println("培庚数量：" + total);
    }
}
