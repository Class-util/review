package 每日一题总结;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 04 24
 * Time:14:01
 */
public class Test02 {

    private static int x = 100;
    public static void main(String[] args){
        Test02 hs1 = new Test02();
        hs1.x++;
        Test02 hs2 = new Test02();
        hs2.x++;
        hs1=new Test02();
        hs1.x++;
        Test02.x--;
        System.out.println( "x=" +x);
    }


    public static void main1(String[] args) {
      /*  String s;
        System.out.println("s=" + s);*/
        int[] arr = {1,2};
        List<int[]> list = Arrays.asList(arr);
        //System.out.println(Arrays.toString(list));
        List<Integer> list1 = new ArrayList<>();
    }
}
