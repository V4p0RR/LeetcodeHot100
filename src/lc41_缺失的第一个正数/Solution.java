package lc41_缺失的第一个正数;

import java.util.Arrays;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (1 <= nums[i] && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int x = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = x;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
