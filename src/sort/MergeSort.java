package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:归并排序
 * User:吴博
 * Date:2021 06 20
 * Time:18:29
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {4,5,2,1,3,9,8,7,6};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void merge(int[] array , int start , int mid , int end){
        int[] tmp = new int[end - start + 1];
        int k = 0;
        int s1 = start;
        int e1 = mid ;
        int s2 = mid + 1;
        int e2= end;
        while(s1 <= e1 && s2 <= e2){
            if(array[s1] <= array[s2]) {
                tmp[k++] = array[s1++];
            }else{
                tmp[k++] = array[s2++];
            }
        }
        while(s1 <= e1){
            tmp[k++] = array[s1++];
        }
        while (s2 <= e2){
            tmp[k++] = array[s2++];
        }

        for(int i = 0 ;i < tmp.length ; i++){
            array[i + start] = tmp[i];
        }
    }

    public static void mergeSortRec(int[] array , int start , int end ){
        if(start >= end){
            return;
        }
        int mid = (start + end)/2;
        mergeSortRec(array , start , mid);
        mergeSortRec(array , mid+1 , end);
        merge(array , start , mid , end);
    }

    public static void mergeSort(int[] array){
        mergeSortRec(array , 0 , array.length-1);
    }
}
