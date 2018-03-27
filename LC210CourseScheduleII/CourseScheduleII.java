import java.util.*;

class CourseScheduleII {
  //BFS
    public static int[] findOrder(int numCourses, int[][]prerequisites) {

        //corner case
        if(numCourses == 0) return new int[0];
        //construct the indegree[]
        int[] indegree = new int[numCourses];
        int[] order = new int[numCourses];
        int index = 0;
        for(int i = 0; i < prerequisites.length; i++) {
          indegree[prerequisites[i][0]]++;
        }
        //build queue for course do not have indegree
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++) {
          if(indegree[i] == 0) {
            queue.offer(i);
            order[index++] = i;
          }
        }

        while(!queue.isEmpty()){
          int course = queue.poll();
          for(int i = 0; i < prerequisites.length; i++) {
            if(prerequisites[i][1] == course) {
              indegree[prerequisites[i][0]]--;
              if(indegree[prerequisites[i][0]] == 0) {
                queue.offer(prerequisites[i][0]);
                order[index++] = prerequisites[i][0];
              }
            }
          }
        }

        return index == numCourses ? order : new int[0];
    }

    public static void main(String[] args) {
      int numCourses = 4;
      int[][] prerequisites = {{1,0}, {2,0}, {3,1}, {3,2}};
      int[] result = findOrder(numCourses, prerequisites);
      System.out.println(Arrays.toString(result));
    }
}
