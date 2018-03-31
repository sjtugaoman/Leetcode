import java.util.*;

class Solution {
  public static int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    for(int num: nums) {
      pq.offer(num);
      if(pq.size() > k) pq.poll();
    }
    return pq.peek();
  }

  public static void main(String[] args) {
    int[] nums = {3, 2, 1, 5, 6, 4};
    int k = 2;
    int KthLarge = findKthLargest(nums, k);
    System.out.println(KthLarge);
  }
}
