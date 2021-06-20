package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:希尔排序
 * User:吴博
 * Date:2021 06 20
 * Time:14:15
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] num = {1,2,3,4,5,6,7,8,9};
        func(num);
        System.out.println(Arrays.toString(num));
    }
    //希尔排序
    public static void func(int[] arr){
        //定义增量数组,最后一个元素必须是1
        int[] group = {5,3,1};
        for (int i = 0; i < group.length; i++) {
            shellSort(arr,group[i]);
        }
    }
    //希尔排序中的直接插入排序操作
    private static void shellSort(int[] arr, int group) {
        for (int i = group; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - group;
            for(; j >=0 ;j = j - group){
                if(tmp < arr[j]){
                    //比他小的元素后移
                    arr[j + group] = arr[j];
                }else {
                    break;
                }
            }
            //将大的元素插入到预期的位置
            arr[j + group] = tmp;
        }
    }
}
