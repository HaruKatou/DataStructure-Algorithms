import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DFS {
    // Connected cells in a grid
    public static int res = 0;

    public static int connectedCell(List<List<Integer>> matrix) {
        // Duyệt
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                // B1: Bắt đầu từ nơi thỏa mãn điều kiện
                if (matrix.get(i).get(j) == 1)
                    // B2: Vào dfs
                    dfs(matrix, i, j, 0);
            }
        }
        return res;
    }

    public static void dfs(List<List<Integer>> matrix, int i, int j, int cnt) {
        // B1: Check điều kiện tồn tại
        if (i < 0 || i >= matrix.size() || j < 0 || j >= matrix.get(i).size()) {
            res = Math.max(cnt, res);
            return;
        }
        if (matrix.get(i).get(j) == 2 || matrix.get(i).get(j) == 0) {
            res = Math.max(cnt, res);
            return;
        }

        //B2: Đánh dấu vị trí hiện tại là đã đi
        cnt++;
        matrix.get(i).set(j, 2);

        //B3: Di chuyển tới các vị trí liền kề

        dfs(matrix, i+1, j, cnt);
        dfs(matrix, i, j+1, cnt);
        dfs(matrix, i-1, j, cnt);
        dfs(matrix, i, j-1, cnt);
        dfs(matrix, i+1, j+1, cnt);
        dfs(matrix, i-1, j-1, cnt);
        dfs(matrix, i+1, j-1, cnt);
        dfs(matrix, i-1, j+1, cnt);

        //B4: Sau khi khám phá xong con đường, bỏ đánh dấu vị trí đã đi
        matrix.get(i).set(j, 1);
    }

    //Number of operations to make network connected
    public int makeConnected(int n, int[][] connections) {
        List<List<Integer>> adj =
                new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[n];

        for (int[] x : connections) {
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
        }

        int network = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFS(adj, visited, i);
                network++;
            }
        }
        return network - 1;
    }

    public void DFS(List<List<Integer>> adj, boolean[] visited, int x) {
        visited[x] = true;
        for (Integer i : adj.get(x)) {
            if (!visited[i]) {
                DFS(adj, visited, i);
            }
        }
    }
}
