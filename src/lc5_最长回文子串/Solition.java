package lc5_最长回文子串;

import java.util.*;

class Solution {
    public String longestPalindrome(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        int start = 0;
        int maxLen = 1;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (str[i] == str[j]) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (j - i + 1 > maxLen && dp[i][j]) {
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}


//中心扩散法
//public String longestPalindrome(String s) {
//    char[] str = s.toCharArray();
//    String res = Character.toString(str[0]);
//    for (int i = 0; i < str.length; i++) {
//        String s1 = expand(s, str, i, i);     // 奇数
//        String s2 = expand(s, str, i, i + 1); // 偶数
//        String cur = s1.length() > s2.length() ? s1 : s2;
//        res = cur.length() > res.length() ? cur : res;
//    }
//    return res;
//}
//
//public String expand(String s, char[] str, int left, int right) {
//    while (left >= 0 && right < str.length) {
//        if (str[left] != str[right]) {
//            break;
//        }
//        left--;
//        right++;
//    }
//    return s.substring(left + 1, right);
//}