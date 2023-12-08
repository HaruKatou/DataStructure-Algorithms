import java.util.*;

public class Dijkstra2 {

    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int start) {

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(1)));
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        pq.add(Arrays.asList(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            List<Integer> current = pq.poll();
            int currentNode = current.get(0);

            if (visited[currentNode]) {
                continue;
            }

            visited[currentNode] = true;

            List<Integer> neighbor = edges.get(currentNode);
            for (int i = 0; i < neighbor.size(); i += 2) {
                int nextNode = neighbor.get(i);
                int edgeWeight = neighbor.get(i + 1);

                if (!visited[nextNode] && distance[currentNode] + edgeWeight < distance[nextNode]) {
                    distance[nextNode] = distance[currentNode] + edgeWeight;
                    pq.add(Arrays.asList(nextNode, distance[nextNode]));
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int x : distance) {
            if (x == Integer.MAX_VALUE) {
                res.add(-1);
                continue;
            }
            res.add(x);
        }
        return res.subList(1, res.size());
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int cases = scan.nextInt();

        for (int k = 0; k < cases; k++) {
            int V = scan.nextInt();
            int E = scan.nextInt();

            List<List<Integer>> edges = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                edges.add(i, new ArrayList<Integer>());
            }

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt();
                int v = scan.nextInt();
                int w = scan.nextInt();

                edges.get(u).addAll(Arrays.asList(v, w));
                edges.get(v).addAll(Arrays.asList(u, w));
            }

            int startNode = scan.nextInt();

            List<Integer> distances = shortestReach(V, edges, startNode);

            for (int i = 0; i < V; i++) {
                if (distances.get(i) == 0)
                    continue;
                System.out.print(distances.get(i) + " ");
            }
            System.out.println();
        }
    }
}