import java.util.*;
public class Kruskal {
    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        int res = 0;

        ArrayList<int[]> resList = new ArrayList<int[]>();

        ArrayList<int[]> adj = new ArrayList<int[]>(); // Initialize an arraylist of int[]


        for (int i = 0; i < gWeight.size(); i++) {
            int u = gFrom.get(i);
            int v = gTo.get(i);
            int weight = gWeight.get(i);
            u--;
            v--;

            adj.add(new int[]{weight, v, u});
        }

        PriorityQueue<int[]> min_heap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int[] edge : adj) {
            min_heap.add(edge);
        }

        UnionFind uf = new UnionFind(gNodes);

        while (!min_heap.isEmpty() && resList.size() < gNodes - 1) {
            int[] edge = min_heap.poll();
            int weight = edge[0];
            int u = edge[1];
            int v = edge[2];
            if (!uf.isConnected(u, v)) {
                uf.union(u, v);
                resList.add(edge);
                res += weight;
            }
        }

        for (int[] edge : resList) {
            System.out.println(edge[0] + " " + edge[1] + " " + edge[2]);
        }

        return res;
    }

    public static void main(String[] args) {
        List<Integer> gFrom = new ArrayList<Integer>();
        List<Integer> gTo = new ArrayList<Integer>();
        List<Integer> gWeight = new ArrayList<Integer>();

        int gNodes;
        int edges;

        Scanner scan = new Scanner(System.in);
        gNodes = scan.nextInt();
        edges = scan.nextInt();
        for (int i = 0; i < edges; i++) {
            gFrom.add(scan.nextInt());
            gTo.add(scan.nextInt());
            gWeight.add(scan.nextInt());
        }

        System.out.println(kruskals(gNodes, gFrom, gTo, gWeight));
    }
}
