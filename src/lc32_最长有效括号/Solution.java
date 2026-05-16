package lc32_最长有效括号;


public class Solution {
    public int longestValidParentheses(String s) {
        int res = 0;
        int n = s.length();
        char[] str = s.toCharArray();
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            if (str[i] == '(') {
                continue;
            }
            if (str[i - 1] == '(') {
                dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
            } else {
                int j = i - dp[i - 1] - 1;
                if (j < 0) continue;
                if (str[j] == '(') {
                    dp[i] = (j >= 1 ? dp[j - 1] : 0) + 2 + dp[i - 1];
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}

//栈解法
//public int longestValidParentheses(String s) {
//    Deque<Integer> stack = new ArrayDeque<>();
//    stack.push(-1);
//    int res = 0;
//    int n = s.length();
//    char[] str = s.toCharArray();
//    for (int i = 0; i < n; i++) {
//        if (str[i] == '(') {
//            stack.push(i);
//        } else {
//            stack.pop();
//            if (stack.isEmpty()) {
//                stack.push(i);
//            } else {
//                res = Math.max(res, i - stack.peek());
//            }
//        }
//    }
//    return res;
//}