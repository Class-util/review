package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:直接插入排序
 * User:吴博
 * Date:2021 06 20
 * Time:13:39
 */
public class DirectInsertionSort {
    public static void main(String[] args) {
        int[] num = {1,2,3,4,5,6,7,8,9};
        func(num);
        System.out.println(Arrays.toString(num));
    }
    //直接插入排序（从大到小）
    public static void func(int[] arr){
        //从下标为1的元素开始，因为我们要往前插入我们选定大小的值
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - 1;
            for (; j  >= 0; j--) {
                //我们实现从大到小的排序
                //所以每次比较i和j位置的值，将大值放到j位置
                if(tmp < arr[j]){
                    //j + 1的位置就是i的位置
                    //每次都时两两交换
                    arr[j + 1] = arr[j];
                }else{
                    //因为直接插入排序是一次一次插入的，所以一旦发现两个位置的大小顺序是对的，那就说明在此之前的大小顺序都是对的
                    break;
                }
            }
            //将tmp放入j + 1的位置,因为是j的位置是最后一个比他小的值，判断完后循环退出，所以要放在j+1的位置
            arr[j + 1] = tmp;
        }
    }
}
