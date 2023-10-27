public class Main {
    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap();
        System.out.println(heap.isEmpty());
        heap.push(10);
        heap.push(20);
        heap.push(30);
        System.out.println(heap.peek());
        heap.push(40); //10,20,30,40
        heap.pop();         //20,30,40
        heap.push(60); //20,30,40,60
        System.out.println(heap.size());
        System.out.println(heap.pop());
        heap.pop();
        heap.pop();
        System.out.println(heap.peek());
    }
}
