package 每日一题总结;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 04 21
 * Time:17:37
 */

class Test{
    public static void hello(){
        System.out.println("hello");
    }
}

public abstract class Test01 {

    /*public int aMethod(){
        static int i = 0;
        i++;
        return i;
    }*/

    public static void Test01(){
        System.out.println(123);
    }

    /*public abstract void air(){

    }*/

    public static void main(String[] args) {
        Test test = null;
        test.hello();
        Test.hello();
        Test01();
    }
}
