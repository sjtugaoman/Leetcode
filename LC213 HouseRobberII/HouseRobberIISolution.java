public class HouseRobberIISolution {
  public static int rob(int[] nums) {
    if(nums.length == 0) return 0;
    if(nums.length == 1) return nums[0];
    return Math.max(robHelper(nums, new int[nums.length], 0, nums.length - 1),
                    robHelper(nums, new int[nums.length], 1, nums.length));
  }

  public static int robHelper(int[] nums, int[] money, int start, int end) {
    if(start == 0) {
      money[0] = nums[0];
      money[1] = Math.max(nums[0], nums[1]);
    } else {
      money[1] = nums[1];
    }
    for(int i = 2; i < end; i++) {
      money[i] = Math.max(money[i - 2] + nums[i], money[i - 1]);
    }
    return money[end - 1];
  }

  public static void main(String[] args) {
    int[] houseWealth = {3, 2, 1, 5, 6, 7, 2};
    System.out.println(rob(houseWealth));
  }
}
