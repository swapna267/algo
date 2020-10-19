package Medium.Medium.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.SortedMap;
import java.util.TreeMap;

public class MinimumSpanningTreePrim {
  public static void main(String[] args) {
    List<List<int[]>> adjList = new ArrayList<>();

    List<int[]> vertx0Edges = new ArrayList<>();
    vertx0Edges.add(new int[]{1,2});
    vertx0Edges.add(new int[]{2,12});
    adjList.add(vertx0Edges);

    List<int[]> vertx1Edges = new ArrayList<>();
    vertx1Edges.add(new int[]{0,2});
    vertx1Edges.add(new int[]{2,2});
    adjList.add(vertx1Edges);

    List<int[]> vertx2Edges = new ArrayList<>();
    vertx2Edges.add(new int[]{0,12});
    vertx2Edges.add(new int[]{1,2});
    adjList.add(vertx2Edges);

    System.out.println(getMSTWeight(adjList));

  }

  public static  int getMSTWeight(List<List<int[]>> adjList) {
    // Mst[] added to MST or not
    // TreeMap

    boolean[] addedToMST = new boolean[adjList.size()];
    int[] weights = new int[adjList.size()];
    weights[0] = 0;
    for (int i=1;i<weights.length;i++) {
      weights[i] = Integer.MAX_VALUE;
    }


    PriorityQueue<int[]> queue = new PriorityQueue(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0]) {
          return 0;
        }

        return o1[1] - o2[1];
      }
    });

    queue.add(new int[]{0,0});

    while(!queue.isEmpty()) {
      int[] vertex = queue.remove();
      addedToMST[vertex[0]] = true;

      for (int[] child : adjList.get(vertex[0])) {
        int childVertex = child[0];

        if (!addedToMST[childVertex]) {
          if (weights[childVertex] > child[1]) {
            queue.remove(child);
            queue.add(new int[]{childVertex, child[1]});
            weights[childVertex] = child[1];
          }
        }

      }
    }

    int  tot = 0;
    for (int i=0;i<weights.length;i++) {
      tot += weights[i];

    }

    return tot;
  }

}
