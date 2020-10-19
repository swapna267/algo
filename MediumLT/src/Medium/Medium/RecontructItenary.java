package Medium.Medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class RecontructItenary {
  public static void main(String[] args) {
    //String[][] s = {["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]};

    List<String> list;
    System.out.println();
  }

  public static List<String> findItinerary(List<List<String>> tickets) {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    tickets.forEach(
            ticket -> map
                    .computeIfAbsent(ticket.get(0), q -> new PriorityQueue<>())
                    .add(ticket.get(1))
    );
    LinkedList<String> route = new LinkedList<>();
    dfs(map, route, "JFK");
    return route;
  }

  private static void dfs(Map<String, PriorityQueue<String>> map, LinkedList<String> route, String source) {
    while (map.containsKey(source) && !map.get(source).isEmpty()) {
      String poll = map.get(source).poll();
      System.out.println(poll);
      dfs(map, route, poll);
    }

    route.addFirst(source);
  }
}


