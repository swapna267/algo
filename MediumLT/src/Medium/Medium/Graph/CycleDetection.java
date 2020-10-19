package Medium.Medium.Graph;

import java.util.ArrayList;
import java.util.List;

class CycleDetection {
  List<List<Integer>> m;
  int[] visited;

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    visited = new int[numCourses];
    m = new ArrayList(numCourses);
    for (int i=0;i<numCourses;i++) {
      m.add(new ArrayList());
    }


    for (int i=0;i<prerequisites.length;i++) {
      List<Integer> list = m.get(prerequisites[i][0]);
      list.add(prerequisites[i][1]);
    }

    for (int i=0;i<numCourses;i++) {
      boolean isPossible = isPossible(i);
      if (!isPossible) {
        return false;
      }
    }

    return true;
  }

  //visit a vertex, visit all its adjacent vertices
  //When returns from a vertex, mark it as visited and not in path anymore.
  //There is a cycle if there is any adjacent vertex that is in its path already.
  public boolean isPossible(Integer course) {
    visited[course] = 1;
    for (Integer dependentCourse:m.get(course)) {
      if (visited[dependentCourse]  == 0) {
        boolean isPossible = isPossible(dependentCourse);
        if (!isPossible) {
          return false;
        }
      } else if (visited[dependentCourse]  == 1) {
        return false;
      }
    }

    visited[course] = 2;
    return true;
  }

}