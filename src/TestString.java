import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 02 12
 * Time:15:43
 */
public class TestString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个字符串");
        String str1 = sc.next();
        System.out.println(str1);
        System.out.println("请输入第二个字符串");
        String str2 = sc.next();
        System.out.println(str2);
        System.out.println("========================");
        System.out.println("请输入第一个字符串");
        String s1 = sc.nextLine();
        System.out.println(s1);
        System.out.println("请输入第二个字符串");
        String s2 = sc.nextLine();
        System.out.println(s2);
    }

    public static void main4(String[] args) {
        DeckCard deckCard = new DeckCard();
        List<Card> cards = deckCard.buyCard();
        System.out.println(cards);
        deckCard.washCard(cards);
        System.out.println(cards);
    }

    public static void main3(String[] args) {
        String str1 = "welcome to bit";
        String str2 = "come";
        String s = removeString(str1, str2);
        System.out.println(s);
    }

    public static void main2(String[] args) {
        List<Student> list = new ArrayList<>();
        Student s1 = new Student("吴博","网络2",89);
        Student s2 = new Student("123","网络2",80);
        Student s3 = new Student("456","网络2",84);
        list.add(s3);
        list.add(s1);
        list.add(s2);
        System.out.println(list);
    }

    //删除第一个字符串中出现的第二个字符串中的字符
    public static String removeString(String str1,String str2){
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            if(!str2.contains(str1.charAt(i) + "")){
                ret.append(str1.charAt(i));
            }
        }
        return ret.toString();
    }


    public static void main1(String[] args) {
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
        a.contains("h");
        System.out.println(a.indexOf('e'));
        StringBuilder sb = new StringBuilder("hello");
        sb.append("world");
        StringBuffer sb2  = new StringBuffer();
        sb2.append("h");
    }

}
