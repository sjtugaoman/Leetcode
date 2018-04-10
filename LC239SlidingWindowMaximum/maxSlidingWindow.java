import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

class maxSlidingWindow{
    //heap solution
    //as remove() is O(logn) but remove(Object) is O(n) 
    //So the time complexity of this solution is O(Nk) not a good one
    public int[] maxSlidingWindowSolution(int[] nums, int k) {
        if(nums.length == 0 || nums == null || k == 0) return new int[0];
        
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer> (){
            public int compare(Integer a, Integer b) {return b - a;}
        });
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            pq.add(nums[i]); 
            count++;
            if(count == k) {
                count--;
                result[i + 1 - k] = pq.peek();
                pq.remove(nums[i + 1 - k]);
            }
            
        }
       return result;
    }

    //ArrayDeque Solution
    //Time complexity O(N)
    public int ArrayDequeSolution(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0) return new int[0];

        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        int[] result = new int[nums.length - k + 1];

        for(int i = 0; i < nums.length; i++) {
            //remove elements out of range k
            if(!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            //remove elements smaller within range k that is useless
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if(i >= k - 1) {
                result[index++] = nums[deque.peek()];
            }
        }
        return result;
    }

    
}