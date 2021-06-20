package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:冒泡排序（从大到小）
 * User:吴博
 * Date:2021 06 20
 * Time:15:58
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] num = {1,2,3,4,5,6,7,8,9};
        func1(num);
        System.out.println(Arrays.toString(num));
    }
    //冒泡排序优化
    public static void func1(int[] arr){
        //大的循环，保证每个为位置都被判断过
        //这里i的最终值可以为arr.length - 1，可以少判断一次，因为最后一次只判断第一个和第二个元素，经过前面一步调整，他俩是有序的，所以可以省略最后一次
        for (int i = 0; i < arr.length; i++) {
            //内部循环，进行优化，减少判断元素的个数
            //因为每经过一次大循环都会确认一个元素的位置，第一次为最后一个，第二次为倒数第二个，以此类推
            //每次都会使判断数组长度-1，都会将一个在指定数组长度中最小的值放入正确的位置
            for (int j = 0; j < arr.length - i - 1; j++) {
                //注意这里可控制元素的下标一定是j不是i，i知识控制循环次数的
                if(arr[j] < arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    //冒泡排序
    public static void func(int[] arr) {
        //最多循环count次就绝对有序
        int count = arr.length - 1;
        //每经过一次while循环都会有一个最小的元素的确认它的位置，第一次确认最后一个，第二次确认倒数第二个
        while(count-- != 0){
            for (int i = 0; i < arr.length - 1; i++) {
                //如果当前元素小于它的下一个元素，则交换位置，保证较大的元素都放在前面
                if(arr[i] < arr[i + 1]){
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
        }
    }
}
