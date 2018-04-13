class FindDuplicateNumber {
    //binary search 
    //time Complexity O(nlogn)
    public static int findDuplicate(int[] nums) {
        if(nums.length == 0 || nums == null) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while(start < end) {
            int mid = (end - start) / 2 + start;
            int count = 0;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] <= mid) {
                    count++;
                }
            }
            if(count <= mid) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    //find cycle
    //the same idea of linkedListCycleII
    //Time complexity O(n)
    public static int findDuplicateByCycle(int[] nums) {
        if(nums.length < 1 || nums == null) {
            return -1;
        }
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while(slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] input = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(input));
        System.out.println(findDuplicateByCycle(input));
    }
}