import java.util.*;

class Solution {
    public int numTripet(int[] nums, int target) {
        if(nums == null || nums.length < 3) return 0;

        int count = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] <= target) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }
}

public class Triplets {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int target = 8;
        int[] test = {1,2,3,4,6};
        System.out.println(solution.numTripet(test, target));
    }  
}