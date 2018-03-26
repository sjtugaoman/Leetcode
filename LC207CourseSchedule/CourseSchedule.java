//BFS Solution using queue
//The question can be simplified as find if there is a cycle inside the graph
import java.util.*;

class CourseSchedule {
  public static boolean canFinish(int numCourses, int[][] prerequisites) {
    //corner case
    if(numCourses == 0 || prerequisites.length == 0) return true;

    //First convert the edge list into indegree of adjacent list
    int[] indegree = new int[numCourses];
    for(int i = 0; i < prerequisites.length; i++) {
      indegree[prerequisites[i][0]]++;
    }

    //add zero-indegree node to queue
    Queue<Integer> queue = new LinkedList<Integer>();
    for(int i = 0; i < numCourses; i++) {
      if(indegree[i] == 0) queue.offer(i);
    }
    //go through the prerequisites and remove the indegree by 1
    int canFinishCount = queue.size();
    while(!queue.isEmpty()) {
      int course = queue.poll();
      for(int i = 0; i < prerequisites.length; i++) {
        if(prerequisites[i][1] == course) {
          indegree[prerequisites[i][0]]--;
          if(indegree[prerequisites[i][0]] == 0) {
            canFinishCount++;
            queue.offer(prerequisites[i][0]);
          }
        }
      }
    }
    return canFinishCount == numCourses;
  }
  public static void main(String[] args) {
    int numCourses = 4;
    int[][] prerequisites = {{1,0}, {2,0}, {3,1}, {3,2}};
    System.out.println(canFinish(numCourses, prerequisites));
  }
}
