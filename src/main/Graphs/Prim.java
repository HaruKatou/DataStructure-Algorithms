import java.util.*;
public class Prim {

    //Time Complexity: O(E*logE).
    public static int prims(int n, List<List<Integer>> edges, int start) {
        int res = 0;
        start--;


        ArrayList<ArrayList<int[]>> adj = new ArrayList<>(); // Initialize an arraylist of int[]

        for (int i = 0; i < edges.size(); i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.size(); i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            int weight = edges.get(i).get(2);
            u--;
            v--;

            adj.get(u).add(new int[]{weight, v});
            adj.get(v).add(new int[]{weight, u});
        }

        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> min_heap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        min_heap.add(new int[]{0, start});

        while (!min_heap.isEmpty()) {
            int[] top = min_heap.poll();
            int weight = top[0];
            int node = top[1];

            if (visited[node])
                continue;

            visited[node] = true;
            res += weight;

            for (int[] pair : adj.get(node)) {
                int neighbor = pair[1];
                int cur_weight = pair[0];
                if (!visited[neighbor]) {
                    min_heap.add(new int[]{cur_weight, neighbor});
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<List<Integer>>();
        edges.add(Arrays.asList(1, 2, 5));
        edges.add(Arrays.asList(1, 3, 3));
        edges.add(Arrays.asList(4, 1, 6));
        edges.add(Arrays.asList(2, 4, 7));
        edges.add(Arrays.asList(3, 2, 4));
        edges.add(Arrays.asList(3, 4, 5));


        System.out.println(Prim.prims(4, edges, 2));
    }
}
