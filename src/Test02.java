import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:杨辉三角形
 * User:吴博
 * Date:2021 03 04
 * Time:16:31
 */
public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        List<List<Integer>> func = func(i);
        System.out.println(func);
    }
    public static List<List<Integer>> func(int n){
        List<List<Integer>> ret = new ArrayList<>();
        //如果n<0直接返回空集合
        if(n <= 0){
            return ret;
        }
        //第一次添加
        List<Integer> list = new ArrayList<>();
        list.add(1);
        ret.add(list);

        for (int i = 1; i < n; i++) {
            List<Integer> tmp = new ArrayList<>();
            //手动添加头部的1
            tmp.add(1);
            //中间的核心算法
            for (int j = 1; j < i; j++) {
                tmp.add(ret.get(i-1).get(j) + ret.get(i-1).get(j-1));
            }
            //手动添加尾部的1
            tmp.add(1);
            //将这一行添加进ret二维集合
            ret.add(tmp);
        }
        return ret;
    }
}
