import java.util.Arrays;

public class MaxHeap {
    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex-1) /2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int parent(int index) {
        return items[getParentIndex(index)];
    }

    private void swap(int firstIndex, int secondIndex) {
        int temp = items[firstIndex];
        items[firstIndex] = items[secondIndex];
        items[secondIndex] = temp;
    }

    private void ensureExtraCapacity() {
        if(size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public int peek() {
        if(size == 0) throw new IllegalStateException();
        return items[0];
    }

    public int pop() {
        if(size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    public void push(int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    public void heapifyUp() {
        int curIndex = size - 1;
        while(hasParent(curIndex) && parent(curIndex) < items[curIndex]) {
            swap(getParentIndex(curIndex), curIndex);
            curIndex = getParentIndex(curIndex);
        }
    }

    public void heapifyDown() {
        int curIndex = 0;
        while(hasLeftChild(curIndex)) {
            //Find the smaller  between left and right child
            int biggerChildIndex = getLeftChildIndex(curIndex);
            if(hasRightChild(curIndex) && rightChild(curIndex) > leftChild(curIndex)) {
                biggerChildIndex = getRightChildIndex(curIndex);
            }

            //Swap with smaller child
            if(items[curIndex] > items[biggerChildIndex]) {
                break;
            } else {
                swap(curIndex, biggerChildIndex);
            }
            curIndex = biggerChildIndex;
        }
    }

    public boolean isEmpty() {
        if(size == 0)
            return true;
        return false;
    }

    public int size() {
        return size;
    }

}
