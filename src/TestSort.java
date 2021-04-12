import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 04 08
 * Time:17:00
 */
public class TestSort {

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        //DirectInsertionSort(arr);
        //shellSort(arr);
        //changeSort(arr);
        //sort1(arr);
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static int pivot(int[] arr,int start,int end){
        int tmp = arr[start];
        while (start < end){
            while (start < end && arr[end] >= tmp){
                end--;
            }
            arr[start] = arr[end];
            while (start < end && arr[start] <= tmp){
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = tmp;
        return start;
    }

    public static void quick(int[] arr,int low,int high){
        if(low < high){
            int piv = pivot(arr,low,high);
            quick(arr,low,piv - 1);
            quick(arr,piv + 1,high);
        }
    }

    //快速排序
    public static void quickSort(int[] arr){
        quick(arr,0,arr.length-1);
    }

    //冒泡排序优化
    public static void sort1(int[] arr){
        //控制循环次数
        for (int i = 0; i < arr.length - 1; i++) {
            //实现数据两两交换，减少了不必要的交换判断
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    //冒泡排序
    public static void sort(int[] arr){
        int count = arr.length - 1;
        while (count != 0){
            for (int i = 0; i < arr.length - 1; i++) {
                if(arr[i] > arr[i + 1]){
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
            count--;
        }
    }

    //选择排序
    public static void changeSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    //希尔排序中的直接插入排序操作
    public static void shell(int[] arr,int gap){
        for (int i = gap; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - gap;
            for (; j >= 0; j =  j - gap) {
                if(tmp < arr[j]){
                    arr[j + gap] = arr[j];
                }else {
                    break;
                }
            }
            arr[j + gap] = tmp;
        }
    }

    //希尔排序
    public static void shellSort(int[] arr){
        //定义增量数组
        int[] gap = {5,3,1};
        for (int i = 0; i < gap.length; i++) {
            shell(arr,gap[i]);
        }
    }


    //直接插入排序
    public static void DirectInsertionSort(int[] num){
        //遍历数组,从1开始循环
        for (int i = 1; i < num.length; i++) {
            //定义tmp每次存储i位置的数
            int tmp = num[i];
            //j每次都在i的前一个
            int j = i - 1;
            for (; j >= 0; j--) {
                //如果i位置的数小于j位置的数，则将其交换，j向后走（逐步实现从小到大的排序）
                if(tmp < num[j]){
                    num[j + 1] = num[j];
                }else {
                    //一旦发现有不小于的数，就停止循环直接退出
                    //num[j +1] = tmp;
                    break;
                }
            }
            //将tmp放在j+1的位置
            num[j + 1] = tmp;
        }
    }
}
