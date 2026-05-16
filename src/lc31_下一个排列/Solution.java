package lc31_下一个排列;

public class Solution {
    public void nextPermutation(int[] nums) {
        int j = 0;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                j = i - 1;
                break;
            }
        }
        int left = 0;
        int right = nums.length - 1;
        for (int i = nums.length - 1; i > j; i--) {
            if (nums[i] > nums[j]) {
                int n = nums[i];
                nums[i] = nums[j];
                nums[j] = n;
                left = j + 1;
                break;
            }
        }
        while (left <= right) {
            int t = nums[right];
            nums[right] = nums[left];
            nums[left] = t;
            left++;
            right--;
        }
    }
}
