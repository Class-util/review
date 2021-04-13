import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 04 13
 * Time:21:02
 */

public class Test05 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        maxStr();
        /*int[] arr = {1,2,3,2,2,2,5,4,2};
        int i = MoreThanHalfNum_Solution(arr);
        System.out.println(i);*/
    }

    //字符串中找出连续最长的数字串
    public static void maxStr() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int max = 0;
            int count = 0;
            int end = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    count++;
                    if (max < count) {
                        max = count;
                        end = i;
                    }
                } else {
                    count = 0;
                }
            }
            System.out.println(str.substring(end - max + 1, end + 1));
        }
    }

    //数组中出现次数超过一半的数字
    public static int MoreThanHalfNum_Solution(int [] array) {
        int len = array.length / 2;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            count = 0;
            for (int j = 0; j < array.length; j++) {
                if(array[i] == array[j]){
                    count++;
                }
            }
            if(count > len){
                return array[i];
            }
        }
        return 0;
    }
}
