import java.util.Scanner;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:计算后缀表达式
 * User:吴博
 * Date:2021 03 07
 * Time:16:58
 */
public class Test03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        double func = func(next);
        System.out.println(func);
    }
    public static double func(String str){
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) > 48 && str.charAt(i) < 57){
                double num = str.charAt(i);
                stack.push(num);
            }else {
                switch (str.charAt(i)){
                    case '+' :  double right = stack.pop();
                                double left = stack.pop();
                                stack.push(left + right);
                    break;
                    case '-' :   right = stack.pop();
                         left = stack.pop();
                        stack.push(left - right);
                        break;
                    case '*' :   right = stack.pop();
                        left = stack.pop();
                        stack.push(left * right);
                        break;
                    case '/' :   right = stack.pop();
                        left = stack.pop();
                        stack.push(left / right);
                        break;
                }
            }
        }
        return stack.peek();
    }
}
