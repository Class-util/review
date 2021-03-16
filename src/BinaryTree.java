import com.sun.org.apache.bcel.internal.generic.CHECKCAST;
import jdk.nashorn.internal.ir.ReturnNode;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:二叉树
 * User:吴博
 * Date:2021 03 11
 * Time:15:32
 */

class BTNode{
    public char val;
    public BTNode left;
    public BTNode right;

    public BTNode(char val) {
        this.val = val;
    }
}

public class BinaryTree {
    //非递归前序遍历
    void preOrderTraversal1(BTNode root){
        Stack<BTNode> stack = new Stack<>();
        if(root == null)
            return ;
        stack.push(root);
        while (!stack.isEmpty()){
            BTNode cur = stack.pop();
            System.out.print(cur.val);
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }
    //非递归中序遍历
    void inOrderTraversal1(BTNode root){
        Stack<BTNode> stack = new Stack<>();
        if(root == null)
            return ;
        BTNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            BTNode top = stack.pop();
            System.out.print(top.val);
            cur = top.right;
        }
    }
    //非递归后序遍历
    void postOrderTraversal1(BTNode root){
        if(root == null)
            return ;
        Stack<BTNode> stack = new Stack<>();
        BTNode cur = root;
        BTNode prev = null;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            BTNode top = stack.peek();
            if(top.right == null || top.right == prev){
                stack.pop();
                System.out.print(top.val);
                prev = top;
            }else {
                cur = top.right;
            }
        }
    }


    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(BTNode root){
        Queue<BTNode> queue = new LinkedList<>();
        if(root == null)
            return false;
        queue.add(root);
        BTNode cur = null;
        while (!queue.isEmpty()){
            cur = queue.poll();
            if(cur != null){
                queue.add(cur.left);
                queue.add(cur.right);
            }else {
                break;
            }
        }
        BTNode tmp = null;
        while (!queue.isEmpty()){
            tmp = queue.peek();
            if(tmp != null){
                return false;
            }else {
                tmp = queue.poll();
            }
        }
        return true;
    }

    //层序遍历进阶
    public List<List<Character>> levelOrder(BTNode root) {
        List<List<Character>> ret = new ArrayList<>();
        Queue<BTNode> queue = new LinkedList<>();
        //判断根是否为空
        if(root == null)
            return ret;
        queue.add(root);
        //判断队列是否为空
        BTNode cur = null;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Character> list = new ArrayList<>();
            while (size > 0){
                cur = queue.poll();
                list.add(cur.val);
                if(cur.left != null)
                    queue.add(cur.left);
                if(cur.right != null)
                    queue.add(cur.right);
                size--;
            }
            ret.add(list);
        }
        return ret;
    }

    //层序遍历
    void levelOrderTraversal(BTNode root){
        Queue<BTNode> queue = new LinkedList<>();
        //判断根是否为空
        if(root != null)
            queue.add(root);
        //判断队列是否为空
        BTNode cur = null;
        while (!queue.isEmpty()){
            cur = queue.poll();
            System.out.print(cur.val);
            if(cur.left != null)
                queue.add(cur.left);
            if(cur.right != null)
                queue.add(cur.right);
        }
    }

    //判断是否为平衡二叉树
    //每个节点的高度差 <= 1
    public boolean isBalanced(BTNode root) {
        if(root == null)
            return true;
        //当前结点的左树右树高度差是否小于1
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if(Math.abs(left-right) > 1)
            return false;
        //判断下一个结点的左右树是否满足
        return isBalanced(root.left) && isBalanced(root.right);
    }

    //判断是否为子树
    public boolean isSubtree(BTNode s, BTNode t) {
        //判断其本身是否相同
        if(s == null || t == null)
            return false;
        if(isSameTree(s, t))
            return true;
        //32行下的所有代码可以替换为40行的代码
        if(isSubtree(s.left,t)) {
            return true;
        }
        if(isSubtree(s.right,t)) {
            return true;
        }
        return false;
        //return isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    //判断两颗二叉树是否相同
    public boolean isSameTree(BTNode p, BTNode q){
        //一个空一个不为空
        if(p == null && q != null || p != null && q == null)
            return false;
        //两个都为空
        if(p == null && q == null)
            return true;
        //值是否相同,这里不用等号判断是因为，如果走到这一步进行判断，首相都不为空，其次如果值相同，说明当前节点是相同的
        //当前节点相同不代表二叉树相同，所以要去判断下一个节点是否相同。
        //如果俩结点相同，则需要执行下一个几点的判断，就要走28行的代码，如果不相同，则不需要往下判断，直接返回走37行代码
        if(p.val != q.val)
            return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    // 遍历思路-求结点个数
    static int size = 0;
    void getSize1(BTNode root){
        if(root == null)
            return ;
        size++;
        getSize1(root.left);
        getSize1(root.right);
    }

    // 子问题思路-求结点个数
    int getSize2(BTNode root){
        if(root == null)
            return 0;
        return getSize2(root.left) + getSize2(root.right) + 1;
    }

    // 遍历思路-求叶子结点个数
    static int leafSize = 0;
    void getLeafSize1(BTNode root){
        if(root == null)
            return ;
        if(root.left == null && root.right == null)
            leafSize++;
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }

    // 子问题思路-求叶子结点个数
    int getLeafSize2(BTNode root){
        if(root == null)
        return 0;
        int count = 0;
        if(root.left == null && root.right == null)
            count = 1;
        return getLeafSize2(root.left) + getLeafSize2(root.right) + count;
    }

    // 子问题思路-求第 k 层结点个数
    int getKLevelSize(BTNode root,int k){
        if(root == null)
            return 0;
        if(k == 1){
            return 1;
        }
        return getKLevelSize(root.left,k-1) + getKLevelSize(root.right,k-1);
    }

    // 获取二叉树的高度
    int getHeight(BTNode root){
        if(root == null)
            return 0;
        return getHeight(root.left) > getHeight(root.right) ? getHeight(root.left) + 1 : getHeight(root.right) + 1;
    }

    // 查找 val 所在结点，没有找到返回 null
    // 按照 根 -> 左子树 -> 右子树的顺序进行查找
    // 一旦找到，立即返回，不需要继续在其他位置查找
    BTNode find(BTNode root, int val){
        if(root == null)
            return null;
        if(root.val == val) {
                return root;
            }
        BTNode ret = find(root.left,val);
        if(ret != null){
            return ret;
        }
        ret = find(root.right,val);
        if(ret != null){
            return ret;
        }
        return null;
    }

    // 前序遍历
    void preOrderTraversal(BTNode root){
        if(root == null)
            return ;
        System.out.print(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    // 中序遍历
    void inOrderTraversal(BTNode root){
        if(root == null)
            return ;
        inOrderTraversal(root.left);
        System.out.print(root.val);
        inOrderTraversal(root.right);
    }
    // 后序遍历
    void postOrderTraversal(BTNode root){
        if(root == null)
            return ;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val);
    }

    //穷举的方式构造二叉树
    public BTNode createTree() {
        BTNode A = new BTNode('A');
        BTNode B = new BTNode('B');
        BTNode C = new BTNode('C');
        BTNode D = new BTNode('D');
        BTNode E = new BTNode('E');
        BTNode F = new BTNode('F');
        BTNode G = new BTNode('G');
        BTNode H = new BTNode('H');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }
}
