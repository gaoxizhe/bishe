package teeseeee.qizhong.two;/**
 * @author : Mr.Gao
 * @date :   2020/4/14 上午10:26
 */

/**
 * @ClassName TestMain
 * @Author Mr.Gao
 * @Date 2020/4/14 上午10:26
 * @Description TODO | 
 */
public class TestMain {
    public static void main(String[] args) {
        Doctor doctor = new Doctor();
         doctor.setAge("23");
         doctor.setDepartment("内科");
         doctor.setJob("主治医生");
         doctor.setName("刘新");
         doctor.setSex("女");
         doctor.work();
        System.out.println(doctor);

        Soldier soldier = new Soldier();
        soldier.setAge("62");
        soldier.setJob("军区司令");
        soldier.setName("刘天明");
        soldier.setMilitaryAge("北京军区");
        soldier.setArmy("43");
        System.out.println(soldier);
    }
}
