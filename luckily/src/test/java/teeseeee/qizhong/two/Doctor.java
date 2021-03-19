package teeseeee.qizhong.two;/**
 * @author : Mr.Gao
 * @date :   2020/4/14 上午10:17
 */

/**
 * @ClassName Doctor
 * @Author Mr.Gao
 * @Date 2020/4/14 上午10:17
 * @Description TODO | 
 */
public class Doctor extends Person {
    private String sex; //性别
    private String Department; //科室

    @Override
    public String toString() {
        System.out.println("==============");
        return
                "姓名='" + name + '\'' +"\n" +
                "科室='" + Department + '\'' +"\n" +
                "职业='" + profession + '\'' +"\n" +
                "年龄='" + age + '\'' +"\n" +
                "性别='" + sex + '\'' +"\n" +
                "职务='" + job + '\'' +"\n" ;
    }

    {
        super.profession = "医生";
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }
}
