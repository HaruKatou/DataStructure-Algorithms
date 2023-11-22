import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<List<Integer>>();
        edges.add(Arrays.asList(1, 2, 3));
        edges.add(Arrays.asList(1, 3, 4));
        edges.add(Arrays.asList(4, 2, 6));
        edges.add(Arrays.asList(5, 2, 2));
        edges.add(Arrays.asList(2, 3, 5));
        edges.add(Arrays.asList(3, 5, 7));


        System.out.println(Prim2.prims(5, edges, 1));
    }
}

