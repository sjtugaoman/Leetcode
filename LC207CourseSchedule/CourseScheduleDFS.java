//DFS solution using backtracking
import java.util.*;

class CourseSchedule {
    // use a separate hashmap to record the DFS pruning
    public static HashMap<Integer, Boolean> memo = new HashMap<Integer, Boolean>();

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //construct hashmap of neighbours
        HashMap<Integer, HashSet<Integer>> neighbors = new HashMap<Integer, HashSet<Integer>>();
        HashSet<Integer> curPath = new HashSet<Integer>();
        for(int i = 0; i < prerequisites.length; i++) {
          if(!neighbors.containsKey(prerequisites[i][1])) {
            neighbors.put(prerequisites[i][1], new HashSet<Integer>());
          }
          neighbors.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        //Find if there is any cycle using DFS
        for(int[] pair: prerequisites) {
          if(DFSHelper(neighbors, curPath, pair[0], -1)) return false;
        }
        return true;
    }


    public static boolean DFSHelper(HashMap<Integer, HashSet<Integer>> neighbors, HashSet<Integer> curPath, int kid, int parent) {
      //using DFS to check if there is cycle
      if(memo.containsKey(kid)) return memo.get(kid);
      if(curPath.contains(kid)) return true;
      if(!neighbors.containsKey(kid)) return false;

      curPath.add(kid);
      for(int neighbor: neighbors.get(kid)){
        boolean hasCycle = DFSHelper(neighbors, curPath, neighbor, kid);
        memo.put(kid, hasCycle);
        if(hasCycle) return true;
      }
      curPath.remove(kid);
      return false;
    }

    public static void main(String[] args) {
      int numCourses = 4;
      int[][] prerequisites = {{1,0}, {2,0}, {3,1}, {3,2}};
      System.out.println(canFinish(numCourses, prerequisites));
    }
}
