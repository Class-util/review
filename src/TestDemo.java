import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:二叉树测试类
 * User:吴博
 * Date:2021 03 11
 * Time:15:39
 */
public class TestDemo {

    public static void main(String[] args) {
            HeapDemo heapDemo = new HeapDemo();
            int[] arr = {27,15,19,18,28,34,65,49,25,37};
            heapDemo.createHeap(arr);
            heapDemo.show();
            heapDemo.heapSort();
            heapDemo.show();
    }

    public static void main1(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BTNode tree = binaryTree.createTree();
//        binaryTree.preOrderTraversal(tree);
//        binaryTree.getSize1(tree);
//        System.out.println();
//        System.out.println(BinaryTree.size);
//        int size2 = binaryTree.getSize2(tree);
//        System.out.println(size2);
//        binaryTree.getLeafSize1(tree);
//        System.out.println(BinaryTree.leafSize);
//        int leafSize2 = binaryTree.getLeafSize2(tree);
//        System.out.println(leafSize2);
//        int kLevelSize = binaryTree.getKLevelSize(tree, 3);
//        System.out.println(kLevelSize);
//        int height = binaryTree.getHeight(tree);
//        System.out.println(height);
//        binaryTree.levelOrderTraversal(tree);
//        List<List<Character>> list = binaryTree.levelOrder(tree);
//        System.out.println(list);
//        boolean completeTree = binaryTree.isCompleteTree(tree);
//        System.out.println(completeTree);
//        binaryTree.preOrderTraversal1(tree);
//        System.out.println();
//        binaryTree.inOrderTraversal(tree);
//        System.out.println();
//        binaryTree.postOrderTraversal(tree);
        binaryTree.postOrderTraversal(tree);
        System.out.println();
        binaryTree.postOrderTraversal1(tree);
    }
}
