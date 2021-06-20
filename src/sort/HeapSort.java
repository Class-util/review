package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:堆排序（升序建立大堆，降序建立小堆）
 * User:吴博
 * Date:2021 06 20
 * Time:16:31
 */
public class HeapSort {
    static int[] arr;
    static int heapSize = 0;

    public static void main(String[] args) {
        HeapSort sort = new HeapSort();
        int[] num = {27,15,19,18,28,34,65,49,25,37};
        createHeap(num);
        heapSort(num);
        show();
    }

    public static void heapSort(int[] num){
        int end = arr.length - 1;
        while(end > 0){
            //交换首尾元素
            int tmp = arr[0];
            arr[0] = arr[end];
            arr[end] = tmp;
            adjustDown(0,end);
            end--;
        }
    }

    //向下调整，建立小堆，走升序
    public static void adjustDown(int parent,int heapSize){
        int child = 2 * parent + 1;
        while(child < heapSize){
            if(child + 1 < heapSize && arr[child] > arr[child + 1]){
                child++;
            }
            if(arr[parent] > arr[child]){
                int tmp = arr[parent];
                arr[parent] = arr[child];
                arr[child] = tmp;
                parent = child;
                child = 2 * parent + 1;
            }else {
                break;
            }
        }
    }

    //初始化堆：先将数组数据存入arr，在进行向下调整
    public static void createHeap(int[] num){
        for (int i = 0; i < num.length; i++) {
            arr[i] = num[i];
            heapSize++;
        }
        //进行向下调整
        for (int i = (heapSize - 1 - 1 ) / 2; i >= 0; i--){
            //从最后一个结点的父节点算起，一个一个的调整
            adjustDown(i,heapSize);
        }
    }
    //打印堆
    public static void show(){
        System.out.println(Arrays.toString(arr));
    }
    //初始化
    public HeapSort(){
        arr = new int[10];
    }
    //判断是否空
    public boolean isEmpty(){
        return heapSize == 0;
    }
    //判断是否满
    public boolean ifFull(){
        return arr.length == heapSize;
    }
}
