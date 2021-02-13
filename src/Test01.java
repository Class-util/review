import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:翻转字符串
 * User:吴博
 * Date:2021 02 13
 * Time:14:56
 */
public class Test01 {
    public static void main(String[] args) {
        String str = "hello";
        System.out.println(func(str,2));
    }

    public static String func(String str,int k){
        if(str == null || k < 0 || k > str.length()){
            return null;
        }
        int len = str.length();
        str = reverse(0,k-1,str);
        str = reverse(k,len-1,str);
        str = reverse(0,len-1,str);
        return str;
    }
    public static String reverse(int left,int right,String str){
        char[] chars = str.toCharArray();
        while (left < right){
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
        return String.valueOf(chars);
    }
}
