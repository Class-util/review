import jdk.nashorn.internal.ir.ReturnNode;

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
