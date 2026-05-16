package lc152_乘积最大子数组;

public class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] maxDp = new int[n + 1];
        int[] minDp = new int[n + 1];
        maxDp[0] = 1;
        minDp[0] = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            maxDp[i] = Math.max(
                    Math.max(maxDp[i - 1] * nums[i - 1], minDp[i - 1] * nums[i - 1]),
                    nums[i - 1]);
            minDp[i] = Math.min(
                    Math.min(maxDp[i - 1] * nums[i - 1], minDp[i - 1] * nums[i - 1]),
                    nums[i - 1]);
            max = Math.max(maxDp[i], max);
        }
        return max;
    }
}
