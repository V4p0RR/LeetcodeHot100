package lc75_颜色分类;

public class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0) {
                int t = nums[left];
                nums[left] = nums[i];
                nums[i] = t;
                left++;
            } else if (nums[i] == 2) {
                int t = nums[right];
                nums[right] = nums[i];
                nums[i] = t;
                i--;
                right--;
            }
        }
    }
}
