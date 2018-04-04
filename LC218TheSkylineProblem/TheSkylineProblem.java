import java.util.*;

class theSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();

        for(int[] b: buildings) {
            heights.add(new int[] {b[0], -b[2]}); //store the start point and negative height value
            heights.add(new int[] {b[1], b[2]}); //store the end point and postive height value
        }

        Collections.sort(heights, (a, b) -> {
            if(a[0] != b[0]) {
                return a[0] - b[0]; //sort the heights by ascending first value
            }
            return a[1] - b[1]; //if first value is same use second value
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a)); //use maxHeap to store all the possible heights
        //offer initial value 0
        pq.offer(0);
        int prev = 0;
        for(int[] h: heights) {
            if(h[1] < 0) {
                //start point offer to pq
                pq.offer(-h[1]);
            } else {
                //end point remove from pq
                pq.remove(h[1]);
            }
            int curr = pq.peek();
            if(prev != curr) {
                result.add(new int[] {h[0], curr});
                prev = curr;
            }

        }
        return result;
    }
}