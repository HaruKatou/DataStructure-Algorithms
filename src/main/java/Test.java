import java.util.*;
public class Test {
    public static void main(String[] args) throws Exception {
        PriorityQueue<Integer> heap2 = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // System.out.println(a+" "+b);
                return b-a;
            }
        });

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(
                (a,b) -> b-a
        );

        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(4);

        heap2.add(1);
        heap2.add(2);
        heap2.add(3);
        heap2.add(4);

        while (!heap.isEmpty()) {
            System.out.println(heap.poll()+" "+heap2.poll());
        }
    }
}
