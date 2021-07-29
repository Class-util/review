package _2021_7;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 07 29
 * Time:23:46
 */

class TreeNode{
    public char val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(char val){
        this.val = val;
    }
}

public class Test {
        public static int i = 0; // 将i定位静态，放在外面，这样每次在创建树的部分，i不会从0开始
        // 根据字符串创建二叉树
        public static TreeNode creatTree(String str){
            if(str == null || str.length() <= 0) return null;
            // 使用i遍历所给的字符串，当为字母时，创建结点
            // 构建根 -》 构建根的左 -》 构建跟的右
            // 构建结点之后i++；
            //int i = 0; i是不能放在这里的
            TreeNode root  = null; // 用来存放新建的结点
            if(str.charAt(i) != '#'){
                root = new TreeNode(str.charAt(i)); // 根据当前i下标的字符新建一个结点
                i++;
                root.left = creatTree(str);  // 递归左树
                root.right = creatTree(str); // 递归右树

            }else{
                // 如果遇到#号了，i++,跳过这个
                i++;
            }
            return root;
        }
        // 将创建的二叉树按中序遍历输出
        public static void inOrderTraversal(TreeNode root){
            if(root == null) return;
            inOrderTraversal(root.left);
            System.out.print(root.val + " ");
            inOrderTraversal(root.right);
        }
        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            String str = scan.nextLine();
            // 根据读入的字符串创建一个二叉树
            TreeNode root = creatTree(str);
            inOrderTraversal(root);
        }
    }
