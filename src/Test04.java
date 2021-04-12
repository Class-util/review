import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 04 12
 * Time:20:50
 */
public class Test04 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2,1};
        func();
    }

    //排序子序列问题
    public static void func(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //用来计数排序子序列的个数
        int count = 1;
        //flog表示当前序列的状态，0表示相等，1表示递增，-1表示递减
        int flog = 0;
        for (int i = 1; i < n; i++) {
            //表示当前为递增序列
            if(arr[i - 1] < arr[i]){
                //如果flog值为0，则将其设为1
                if(flog == 0){
                    flog = 1;
                }else {
                    //如果flog为-1，说明前后序列有变化，应当分组，count++
                    if(flog == -1){
                        //变化完成后将flog在设为0，从新开始记录
                        flog = 0;
                        count++;
                    }
                }
            }
            //表示当前为递减序列
            if(arr[i - 1] > arr[i]){
                //如果flog值为0，则将其设为-1
                if(flog == 0){
                    flog = -1;
                }else {
                    //如果flog为1，说明前后序列有变化，应当分组，count++
                    if(flog == 1){
                        //变化完成后将flog在设为0，从新开始记录
                        flog = 0;
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

    //倒置字符串
    public static void reStr(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        List<String> list = new ArrayList<>();
        String tmp = "";
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != ' '){
                tmp += str.charAt(i);
            }else {
                list.add(tmp);
                tmp = "";
            }
        }
        list.add(tmp);
        System.out.println(list);
        for (int size = list.size() - 1; size >= 0; size--) {
            if(size != 0){
                System.out.print(list.get(size).trim()+' ');
            }else {
                System.out.print(list.get(size).trim());
            }
        }
    }
}
