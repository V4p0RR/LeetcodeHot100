package lc322_零钱兑换;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            int cur = coins[i];
            for (int j = cur; j <= amount; j++) {
                if (dp[j - cur] != Integer.MAX_VALUE && dp[j - cur] + 1 < dp[j]) {
                    dp[j] = dp[j - cur] + 1;
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
