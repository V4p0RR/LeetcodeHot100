package lc238_除了自身以外数组的乘积;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 1) {
            return new int[]{0};
        }
        int[] pre_t = new int[nums.length];
        pre_t[0] = 1;
        int[] after_t = new int[nums.length];
        after_t[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            pre_t[i] = pre_t[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            after_t[i] = after_t[i + 1] * nums[i + 1];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = pre_t[i] * after_t[i];
        }
        return res;
    }
}
