package _2021_7;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 07 29
 * Time:23:47
 */
public class Test2 {
    public static int i = 0;
    public static TreeNode createTree(String str){
        if(str == null || str.length() <= 0) return null;
        TreeNode root = null;
        if(str.charAt(i) != '#'){
            root = new TreeNode(str.charAt(i));
            i++;
            root.left = createTree(str);
            root.right = createTree(str);
        }else{
            i++;
        }
        return root;
    }
    public static void inOderTraversal(TreeNode root){
        if(root == null) return;
        inOderTraversal(root.left);
        System.out.print(root.val + ' ');
        inOderTraversal(root.right);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        TreeNode root = createTree(str);
        inOderTraversal(root);
    }
}
