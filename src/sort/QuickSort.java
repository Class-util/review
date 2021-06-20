package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:快速排序（从大到小）
 * User:吴博
 * Date:2021 06 20
 * Time:17:49
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] num = {1,2,3,4,5,6,7,8,9};
        quickSort(num);
        System.out.println(Arrays.toString(num));
    }

    private static void quickSort(int[] num) {
        quick(num,0,num.length - 1);
    }

    private static void quick(int[] num, int qStart, int qEnd) {
        if(qStart < qEnd){
            //找基准，找到后说明piv位置就确定了，不用去调整了，接下来去调整基准的左右（分别再找其左右递归实现）
            int piv = pivot(num,qStart,qEnd);
            //找左边的基准
            quick(num,qStart,piv - 1);
            //找右边的基准
            quick(num,piv + 1,qEnd);
        }
    }

    private static int pivot(int[] num, int start, int end) {
        //记录初始值
        int tmp = num[start];
        //只要start<end就一直走
        while(start < end){
            //保证下标合法的前提下，实现升序，从后找比tmp大的值
            while(start < end && num[end] <= tmp){
                end--;
            }
            //找到后将其赋值到start位置
            num[start] = num[end];
            ////保证下标合法的前提下，实现升序，从前找比tmp小的值
            while(start < end && num[start] >= tmp){
                start++;
            }
            //end
            num[end] = num[start];
        }
        //循环结束说明，start与end相遇了。这个位置就是tmp应该放的位置。
        num[start] = tmp;
        return start;
    }
}
