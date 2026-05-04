class Solution {
  public void moveZeroes(int[] nums) {
    int slow = 0;

    // 1. 把所有非0元素“前移”
    for (int fast = 0; fast < nums.length; fast++) {
      if (nums[fast] != 0) {
        nums[slow++] = nums[fast];
      }
    }

    // 2. 后面补0
    for (int i = slow; i < nums.length; i++) {
      nums[i] = 0;
    }
  }
}