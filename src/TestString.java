/**
 * Created with IntelliJ IDEA.
 * Description:String类复习总结代码
 * User:吴博
 * Date:2021 02 12
 * Time:15:43
 */
public class TestString {
    public static void main(String[] args) {
        //创建字符串的三种方式
        String str = "hello";
        for (int i = 0; i < 10; i++) {
            str += i;
        }
        System.out.println(str);
        String str2 = new String("hello");
        //数组转字符串
        char[] value = {'h','e','l','l','o'};
        String.copyValueOf(value);
        String.valueOf(value);
        new String(value);
        String str3 = new String(value,1,2);
        System.out.println(str.equals(str2));
        System.out.println("hello".equals(str3));
        System.out.println(str3.equals("hello"));
        String s1 = "abcd";
        String s2 = new String("abcd");
        System.out.println(s1.equals(s2));
        String a = "hello";
        String b = "world";
        String c = "hello" + "world";
        String d = a + "world";
        String e = a + b;
        System.out.println(c == d);
        System.out.println(c == e);
        System.out.println(d == e);
    }

}
