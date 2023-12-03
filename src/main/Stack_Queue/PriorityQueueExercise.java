import java.util.*;
public class PriorityQueueExercise {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public PriorityQueueExercise() {

    }
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size() > maxHeap.size())
            maxHeap.offer(minHeap.poll());
    }
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
        return (minHeap.peek() + maxHeap.peek()) / 2.0d;
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<Integer>();
        for(int asteroid : asteroids) {
            if(asteroid > 0) {
                st.add(asteroid);
            } else {
                while(!st.empty() && st.peek() > 0 && st.peek() < asteroid * -1) {
                    st.pop();
                }
                if(st.empty() || st.peek() < 0) {
                    st.add(asteroid);
                }
                else if(st.peek() == asteroid*-1) {
                    st.pop();
                }
            }
        }
        int[] res = new int[st.size()];
        for(int i = res.length - 1; i >= 0; i--){
            res[i] = st.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] asteroids = new int[] {10,2,-5};
        int[] res = asteroidCollision(asteroids);
        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
