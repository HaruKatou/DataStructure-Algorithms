import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<List<Integer>>();
        edges.add(Arrays.asList(1, 2, 20));
        edges.add(Arrays.asList(1, 3, 50));
        edges.add(Arrays.asList(1, 4, 70));
        edges.add(Arrays.asList(2, 3, 30));
        edges.add(Arrays.asList(3, 4, 40));
        edges.add(Arrays.asList(4, 5, 60));
        edges.add(Arrays.asList(1, 5, 90));


        System.out.println(Prim.prims(5, edges, 2));
    }
}

