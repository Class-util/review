package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 06 20
 * Time:14:31
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] num = {1,2,3,4,5,6,7,8,9};
        func(num);
        System.out.println(Arrays.toString(num));
    }
    //直接选择排序（每次从后面选择最大的值放入当前位置）
    public static void func(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //每次从当前位置，往后去找到最大值放入当前位置
            for (int j = i; j < arr.length; j++) {
                if(arr[i] < arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}
