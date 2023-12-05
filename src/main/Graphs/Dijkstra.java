import java.util.*;
public class Dijkstra {

    //Time Complexity: O(E*logV)
    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int start) {
        List<Integer> distances = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));
        start--;
        distances.set(start, 0);

        ArrayList<int[]>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int weight = edge.get(2);
            u--;
            v--;

            adj[u].add(new int[]{weight, v});
            adj[v].add(new int[]{weight, u});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.add(new int[]{0, start});

        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int dist = top[0];
            int node = top[1];

            if (dist > distances.get(node)) {
                continue;
            }

            for (int[] neighbor : adj[node]) {
                int newDist = dist + neighbor[0];

                if (newDist < distances.get(neighbor[1])) {
                    distances.set(neighbor[1], newDist);
                    minHeap.add(new int[]{newDist, neighbor[1]});
                }
            }
        }

        for (int i = 0; i < distances.size(); i++) {
            if (distances.get(i) == Integer.MAX_VALUE)
                distances.set(i, -1);
        }
        return distances;
    }

    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();

        Scanner scan = new Scanner(System.in);

        int cases = scan.nextInt();


        for (int k = 0; k < cases; k++) {
            int n = scan.nextInt();
            int edge = scan.nextInt();

            for (int i = 0; i < edge; i++) {
                set.add(Arrays.asList(scan.nextInt(), scan.nextInt(), scan.nextInt()));
            }

            edges.addAll(set);

            int startNode = scan.nextInt();

            List<Integer> distances = shortestReach(n, edges, startNode);

            for (int i = 0; i < n; i++) {
                if (distances.get(i) == 0)
                    continue;
                System.out.print(distances.get(i) + " ");
            }
            System.out.println();
        }
    }
}
