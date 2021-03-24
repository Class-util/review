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

    public HeapDemo() {
        this.elem = new int[10];
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
