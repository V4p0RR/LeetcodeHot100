package lc139_单词拆分;

import java.util.*;


public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty()) {
            return true;
        }
        int n = s.length();
        Set<String> set = Set.copyOf(wordDict);
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = Math.max(0, i - 20); j < i; j++) {
                if (dp[j]) {
                    String str = s.substring(j, i);
                    if (set.contains(str)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[n];
    }
}
