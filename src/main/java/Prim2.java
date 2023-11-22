import java.util.*;
public class Prim2 {
    public static int prims(int n, List<List<Integer>> edges, int start) {
        int res = 0;
        start--;

        ArrayList<int[]>[] adj = new ArrayList[n]; // Initialize an arraylist of int[]

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            int weight = edges.get(i).get(2);
            u--;
            v--;

            adj[u].add(new int[]{weight, v});
            adj[v].add(new int[]{weight, u});
        }

        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> min_heap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        HashMap<Integer, Integer> heap_dict = new HashMap<>();

        for (int[] pair : adj[start]) {
            min_heap.add(pair);
        }


        while (!min_heap.isEmpty()) {
            int[] top = min_heap.poll();
            int weight = top[0];
            int node = top[1];

            if (visited[node])
                continue;

            visited[node] = true;
            res += weight;

            for (int[] pair : adj[node]) {
                int neighbor = pair[1];
                int cur_weight = pair[0];
                if (!visited[neighbor]) {
                    min_heap.add(new int[]{cur_weight, neighbor});
                }
            }
        }
        return res;
    }
}
