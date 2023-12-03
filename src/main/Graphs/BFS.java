import java.util.*;
public class BFS {
    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        // Write your code here
        List<Integer> res = new ArrayList<Integer>(Collections.nCopies(n, -1));

        s--;

        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new HashSet<Integer>());
        }

        for (List<Integer> edge : edges)  {
            int u = edge.get(0);
            int v = edge.get(1);
            u--;
            v--;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        res.set(s, 0);

        boolean[] visited = new boolean[n];
        visited[s] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (Integer vertex : adj.get(u)) {
                int tmp = res.get(u);
                if (!visited[vertex]) {
                    visited[vertex] = true;
                    res.set(vertex, tmp + 6);
                    queue.add(vertex);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int cases = scan.nextInt();


        for (int k = 0; k < cases; k++) {
            List<List<Integer>> edges = new ArrayList<>();

            int n = scan.nextInt();
            int m = scan.nextInt();

            for (int i = 0; i < m; i++) {
                edges.add(Arrays.asList(scan.nextInt(), scan.nextInt()));
            }

            int startNode = scan.nextInt();

            List<Integer> distances = bfs(n, m, edges, startNode);

            for (int i = 0; i < n; i++) {
                if (i == startNode - 1)
                    continue;
                System.out.print(distances.get(i) + " ");
            }
            System.out.println();
        }
    }
}
