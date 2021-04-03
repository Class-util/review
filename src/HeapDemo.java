import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: 大根堆
 * User:吴博
 * Date:2021 03 24
 * Time:17:18
 */
public class HeapDemo {

    public int[] elem;
    public int usedSize = 0;

    //思路：判断堆是否满？如果满进行扩容，将值放在最后一个位置，在进行向上调整
    public void push(int val){
        if(ifFull()){
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        this.elem[usedSize] = val;
        this.usedSize++;
        adjustUp(usedSize-1);
    }


    //向上调整
    public void adjustUp(int child){
        int parent = (child - 1) / 2;
        while (parent >= 0){
            if(this.elem[child] > this.elem[parent]){
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                child = parent;
                parent = (child - 1) / 2;
            }else {
                break;
            }
        }
    }

    //思路：将第一个元素和最后一个元素交换，将usedSize--，并且对堆在进行向下调整
    public int poll(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        //获取第一个元素
        int ret = this.elem[0];
        //删除操作:交换第一个元素和最后一个元素，并将usedSize--
        int tmp = this.elem[0];
        this.elem[0] = this.elem[usedSize-1];
        this.elem[usedSize-1] = tmp;
        this.usedSize--;
        adjustDown(0,this.usedSize);
        return ret;
    }


    public HeapDemo(){
        this.elem = new int[10];
    }


    public boolean isEmpty(){
        return usedSize == 0;
    }

    public boolean ifFull(){
        return elem.length == usedSize;
    }


    public void adjustDown (int parent , int usedSize) {
        int child = 2 * parent + 1;
        while (child < usedSize){
            if(child +1 < usedSize && elem[child] < elem[child + 1]){
                child++;
            }
            if(elem[parent] < elem[child]){
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                parent = child;
                child = 2 * parent + 1;
            }else {
                break;
            }
        }
    }

    public void createHeap (int[] array){
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            usedSize++;
        }
        for (int i = ((usedSize-1)-1)/2; i >= 0; i--) {
            adjustDown(i,usedSize);
        }
    }

    public void show() {
        System.out.println(Arrays.toString(elem));
    }
}