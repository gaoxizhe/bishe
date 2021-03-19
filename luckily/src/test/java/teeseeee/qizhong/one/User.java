package teeseeee.qizhong.one;/**
 * @author : Mr.Gao
 * @date :   2020/4/17 上午8:14
 */

/**
 * @ClassName User
 * @Author Mr.Gao
 * @Date 2020/4/17 上午8:14
 * @Description TODO | 
 */
public class User {
    private String nickName;
    private String password;
    private String sex;
    private Integer age;
    private String createTime;
    private String grade;

    public User(String nickName, String password, String sex, Integer age, String createTime, String grade) {
        this.nickName = nickName;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.createTime = createTime;
        this.grade = grade;
    }

    public void showMsg() {
        System.out.println("大家好，我是 " + this.nickName + ",今年 " + this.age + "岁");
        System.out.println("我是 " + this.createTime + "注册的 ， 目前的等级是： " + this.grade);
        System.out.println("======================");

    }
}
