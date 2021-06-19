package _2021_6;

/**
 * Created with IntelliJ IDEA.
 * Description:测试自己实现的大堆是否成功
 * User:吴博
 * Date:2021 06 19
 * Time:22:08
 */
public class TestDemo {
    public static void main(String[] args) {
        int[] arr = {27,15,19,18,28,34,65,49,25,37};
        HeapDemo heapDemo = new HeapDemo();
        heapDemo.createHeap(arr);
/*        heapDemo.show();
        heapDemo.heapSort();
        heapDemo.show();
        heapDemo.topK(arr,4);*/
        heapDemo.push(44);
        heapDemo.show();
    }
}
