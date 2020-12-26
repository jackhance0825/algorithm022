import java.util.NoSuchElementException;

/**
 * 大顶堆
 * <p>
 * (序号最小)首个叶子节点
 * size / degree
 * <p>
 * 计算子结点（满子结点的情况）
 * [k * degree + 1, k * degree + degree]
 * <p>
 * 计算父节点（k > 0）
 * (k - 1) / degree
 */
public class Heap {
    private static final int degree = 3;
    private final int[] heap;
    private int size;

    public Heap(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        heap = new int[size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == heap.length;
    }

    private void heapIfyDown(int k, int val) {
        boolean down = false;
        int limit = size / degree;
        while (k < limit) {
            int child = k;
            for (int i = k * degree + 1; i <= k * degree + degree && i < size; i++) {
                if (heap[i] > heap[child]) {
                    child = i;
                }
            }
            if (child == k) {
                break;
            }
            heap[k] = heap[child];
            k = child;
        }
        heap[k] = val;
    }

    private int parent(int k) {
        return (k - 1) / degree;
    }

    private void heapIfyUp(int k, int val) {
        int parent;
        while ((parent = parent(k)) > 0 && heap[parent] < heap[k]) {
            heap[k] = heap[parent];
            k = parent;
        }
        heap[k] = val;
    }

    /**
     * Inserts new element in to heap
     * Complexity: O(log N)
     * As worst case scenario, we need to traverse till the root
     */
    public boolean insert(int x) {
        if (isFull()) {
            return false;
        }
        heap[size++] = x;
        heapIfyUp(size - 1, x);
        return true;
    }

    /**
     * Deletes element at index x
     * Complexity: O(log N)
     *
     * @param x index
     */
    public boolean deleteByIndex(int x) {
        if (isEmpty() || x >= size) {
            return false;
        }
        if (x == size - 1) {
            size--;
        } else {
            heap[x] = heap[size - 1];
            size--;
            int temp = heap[x];
            heapIfyDown(x, heap[x]);
            if (heap[x] == temp) {
                heapIfyUp(x, heap[x]);
            }
        }
        return true;
    }

    /**
     * This method returns the max element of the heap.
     * complexity: O(1)
     */
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty.");
        }
        return heap[0];
    }

    /**
     * 求节点深度
     */
    private int deep(int a) {
        int deep = 0;
        while (a > 0) {
            a = parent(a);
            deep++;
        }
        return deep;
    }

    /**
     * Prints all elements of the heap
     */
    public void print() {
        System.out.println("Heap:");
        for (int i = 0; i < size; i++) {
            if (i > 0 && deep(i) != deep(i - 1)) {
                System.out.println();
            }
            System.out.print(heap[i] + " ");
        }
        System.out.println();
        System.out.println("===============================");
    }

    public static void main(String[] args) {
        Heap heap = new Heap(50);
        heap.insert(100);
        heap.insert(36);
        heap.insert(52);
        heap.insert(29);
        heap.insert(28);
        heap.insert(41);
        heap.insert(35);
        heap.insert(10);
        heap.insert(11);
        heap.insert(9);
        heap.insert(7);
        heap.insert(37);
        heap.insert(38);


        heap.print();
        heap.deleteByIndex(3);
        heap.print();
//        heap.deleteByIndex(1);
//        heap.print();
    }
}

