package teeseeee.zuoye.wto;/**
 * @author : Mr.Gao
 * @date :   2020/4/14 上午10:54
 */

/**
 * @ClassName Hpizza
 * @Author Mr.Gao
 * @Date 2020/4/14 上午10:54
 * @Description TODO | 
 */
public class Hpizza extends Pizza {
    private String Ingredients;//配料



    public Hpizza(String name ,double price ,int size ,String ingredients) {
        super.name = name;
        super.price= price;
        super.size = size;

        this.Ingredients = ingredients;
    }

    @Override
    void make() {
        super.make();
        System.out.println("配料：" + Ingredients);
    }
}
