import java.util.Stack;

public class Solution {
    public static int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> st = new Stack<Integer>();
        for(String str : tokens) {
            if(str == "+" || str == "-" || str == "/" || str == "*") {
                int a = Integer.valueOf(st.pop());
                int b = Integer.valueOf(st.pop());

                if(str == "+") {
                    st.push(a + b);
                }
                else if(str == "-") {
                    st.push(a - b);
                }
                else if(str == "*") {
                    st.push(a * b);
                }
                else {
                    st.push(b / a);
                }
            }
            else {
                st.push(Integer.valueOf(str));
            }
        }
        return st.peek();
    }

    public static int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int[] minLR = new int[height.length];
        maxLeft[0] = 0;
        maxRight[height.length-1] = 0;
        int res = 0;

        for(int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
        }
        for(int i = height.length-2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i+1], height[i+1]);
        }
        for(int i = 0; i < height.length; i++) {
            minLR[i] = Math.min(maxLeft[i], maxRight[i]);
        }
        for(int i = 0; i < height.length; i++) {
            if(minLR[i] - height[i] >= 0) {
                res += minLR[i] - height[i];
            }
        }

        return res;
    }

    public static void trapPrint(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int[] minLR = new int[height.length];
        maxLeft[0] = 0;
        maxRight[height.length-1] = 0;
        int res = 0;

        for(int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
        }
        for(int i = height.length-2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i+1], height[i+1]);
        }
        for(int i = 0; i < height.length; i++) {
            minLR[i] = Math.min(maxLeft[i], maxRight[i]);
        }
        for(int i = 0; i < height.length; i++) {
            if(minLR[i] - height[i] >= 0) {
               res += minLR[i] - height[i];
            }
            System.out.print(res + " ");
        }
        System.out.println();
        for(int i = 0; i < height.length; i++) {
            System.out.print(maxLeft[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < height.length; i++) {
            System.out.print(maxRight[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < height.length; i++) {
            System.out.print(minLR[i] + " ");
        }
        System.out.println();
        System.out.print(res);
    }

    public static void main(String[] args) throws Exception {
        int[] tokens = new int[] {4,2,0,3,2,5};
        System.out.println(trap(tokens));

    }
}
