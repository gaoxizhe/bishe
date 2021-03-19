package teeseeee;/**
 * @author : Mr.Gao
 * @date :   2020/4/9 下午6:31
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName MainMethod
 * @Author Mr.Gao
 * @Date 2020/4/9 下午6:31
 * @Description TODO |
 */
public class MainMethod {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= next.length(); i++) {
            if (i == 0) {
                continue;
            }
            String substring = next.substring(i - 1, i);
            list.add(Integer.valueOf(substring));
        }
        list.sort(Comparator.comparingInt(o -> o));
        System.out.println(list);

    }
}
