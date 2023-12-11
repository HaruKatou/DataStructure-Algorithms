public class UnionFind {
    private int[] parent;
    // 2 operations

    public UnionFind(int size) {
        parent = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }
    public int find(int x) {
        if (parent[x] != x) {
            return find(parent[x]);
        }
        return x;

        /*while (parent[x] != x) {
            x = parent[x];
        }
        return x;*/
    }

    public void union(int x, int y) {
        parent[find(y)] = find(x);
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(5);

        uf.union(0, 1);
        uf.union(1, 2);
        uf.union(3, 4);

        System.out.println(uf.isConnected(0, 2)); // true
        System.out.println(uf.isConnected(1, 3)); // false

        uf.union(2, 3);

        System.out.println(uf.isConnected(0, 2)); // true
        System.out.println(uf.isConnected(1, 3)); // true
    }

}
