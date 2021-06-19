package _2021_6;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:大堆的创建
 * User:吴博
 * Date:2021 06 19
 * Time:21:49
 */
public class HeapDemo {
    //定义存储数据的数组
    private int[] arr;
    //定义变量记录长度
    private int heapSize = 0;


    //思路：将第一个元素和最后一个元素交换，将usedSize--，并且对堆在进行向下调整
    public int poll(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        //获取第一个元素
        int ret = this.arr[0];
        //删除操作:交换第一个元素和最后一个元素，并将usedSize--
        int tmp = this.arr[0];
        this.arr[0] = this.arr[heapSize-1];
        this.arr[heapSize-1] = tmp;
        this.heapSize--;
        adjustDown(0,this.heapSize);
        return ret;
    }

    //思路：判断堆是否满？如果满进行扩容，将值放在最后一个位置，在进行向上调整
    public void push(int val){
        if(ifFull()){
            this.arr = Arrays.copyOf(this.arr,2*this.arr.length);
        }
        this.arr[heapSize] = val;
        this.heapSize++;
        adjustUp(heapSize-1);
    }

    //向上调整
    private void adjustUp(int child) {
        int parent = (child - 1) / 2;
        while(parent > 0){
            if(arr[child] > arr[parent]){
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
                child = parent;
                parent = (child - 1) / 2;
            }else {
                break;
            }
        }
    }

    //topk问题:前k个最大值
    public void topK(int[] arr,int k){
        //默认小堆
        Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o1 - o2));
        for (int i = 0; i < arr.length; i++) {
            if(queue.size() < k){
                queue.offer(arr[i]);
            }else {
                Integer top = queue.peek();
                if(top != null){
                    if(arr[i] > top){
                        queue.poll();
                        queue.offer(arr[i]);
                    }
                }
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.println(queue.poll());
        }
    }

    //堆排序（从小到大）
    public void heapSort(){
        int end = heapSize - 1;
        while(end > 0){
            //交换首尾元素，这步操作保证每次都是该堆最大元素在最末尾
            int tmp = arr[end];
            arr[end] = arr[0];
            arr[0] = tmp;
            //接下来因为改变了值得顺序，我们需要将堆重新去创建，去从0开始进行向下调整，保证最大值在0下标的位置，也就是堆顶
            adjustDown(0,end);
            //最大值放在了最后，我们就不用管它了，下次向下调整时就不调整它
            end--;
        }
    }

    //初始化堆：先将数组数据存入arr，在进行向下调整
    public  void createHeap(int[] num){
        for (int i = 0; i < num.length; i++) {
            arr[i] = num[i];
            heapSize++;
        }
        //进行向下调整
        for (int i = (heapSize - 1 - 1 ) / 2; i >= 0; i--){
            //从最后一个结点的父节点算起，一个一个的调整
            adjustDown(i,heapSize);
        }
    }
    //向下调整
    private void adjustDown(int parent, int heapSize) {
        //根据拿到的父节点求子节点的位置
        int child = 2 * parent + 1;
        //子节点小于整体的长度也就是最后一个元素的下标，才能进行向下调整，不然就说明父节点已经处于最底层，无子节点
        while(child < heapSize){
            //这里我们创建大堆，所以在子节点下标+1不超过整体长度的情况下，我们去左右子节点的最大值
            if(child + 1 < heapSize && arr[child] < arr[child + 1]){
                child++;
            }
            //代码执行至此，说明我们已经取到了子节点中的较大值
            //接着比较子节点和父节点值得大小，因为要创建大堆，所以要将二者的大值放在父节点的位置
            if(arr[parent] < arr[child]){
                int tmp = arr[parent];
                arr[parent] = arr[child];
                arr[child] = tmp;
                //代码执行至此，说明父节点到子节点这三个结点的大堆已经创建出来了，但是因为我们调整了父节点与子节点的值
                //所以我们也当也去调整以此次子节点为父节点的三个结点的值，让其也形成大堆（向下调整的含义）
                parent = child;
                child =  2 * parent + 1;
            }else {
                //不用调整，直接跳出循环
                break;
            }
        }
    }
    //打印堆
    public void show(){
        System.out.println(Arrays.toString(arr));
    }
    //初始化
    public HeapDemo(){
        this.arr = new int[10];
    }
    //判断是否空
    public boolean isEmpty(){
        return heapSize == 0;
    }
    //判断是否满
    public boolean ifFull(){
        return arr.length == heapSize;
    }
}
