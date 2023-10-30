import java.util.*;

public class PriQueue {
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
