import java.util.*;
public class Dijkstra {
    public static int shortestReach(int n, List<List<Integer>> edges, int s) {
        int res = 0;
        ArrayList<int[]>[] adj = new ArrayList[edges.size()]; // Initialize an arraylist of int[]

        for (int i = 0; i < edges.size(); i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.size(); i++) {
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

        min_heap.add(new int[]{0, s});

        while (!min_heap.isEmpty() && !visited[n - 1]) {
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

    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<List<Integer>>();

        int gNodes;
        int edgeNum;

        Scanner scan = new Scanner(System.in);
        gNodes = scan.nextInt();
        edgeNum = scan.nextInt();
        for (int i = 0; i < edgeNum; i++) {
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(scan.nextInt());
            tmp.add(scan.nextInt());
            tmp.add(scan.nextInt());
            edges.add(tmp);
        }
    }
}
