package lc45_跳跃游戏II;

public class Solution {
    public int jump(int[] nums) {
        int maxReach = 0;
        int count = 0;
        int curEnd = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(i + nums[i], maxReach);
            if (i == curEnd) {
                count++;
                curEnd = maxReach;
            }
        }
        return count;
    }
}
