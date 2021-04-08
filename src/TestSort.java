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
        DirectInsertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //直接插入排序
    public static void DirectInsertionSort(int[] num){
        //遍历数组
        for (int i = 1; i < num.length; i++) {
            int tmp = num[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if(tmp < num[j]){
                    num[j + 1] = num[j];
                }else {
                    //num[j +1] = tmp;
                    break;
                }
            }
            num[j + 1] = tmp;
        }
    }
}
