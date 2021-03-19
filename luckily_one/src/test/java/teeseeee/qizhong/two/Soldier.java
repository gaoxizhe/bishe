package teeseeee.qizhong.two;/**
 * @author : Mr.Gao
 * @date :   2020/4/14 上午10:23
 */

/**
 * @ClassName Soldier
 * @Author Mr.Gao
 * @Date 2020/4/14 上午10:23
 * @Description TODO | 
 */
public class Soldier extends Person {
    private String army;  //部队
    private String MilitaryAge;  //军龄
    {
        super.profession = "军人";
    }

    @Override
    public String toString() {
        System.out.println("===================");
        return
                "部队='" + army + '\'' + "\n" +
                "军龄='" + MilitaryAge + '\'' + "\n" +
                "职业='" + profession + '\'' +"\n" +
                "姓名='" + name + '\'' +"\n" +
                "年龄='" + age + '\'' +"\n" +
                "职务='" + job + '\'' +"\n" ;
    }


    public String getName() {
        return super.name;
    }
    public void setName(String name) {
        super.name = name;
    }

    public String getAge() {
        return super.age;
    }
    public void setAge(String age) {
        super.age = age;
    }

    public String getJob() {
        return super.job;
    }
    public void setJob(String job) {
        super.job = job;
    }

    public String getArmy() {
        return army;
    }

    public void setArmy(String army) {
        this.army = army;
    }

    public String getMilitaryAge() {
        return MilitaryAge;
    }

    public void setMilitaryAge(String militaryAge) {
        MilitaryAge = militaryAge;
    }
}
