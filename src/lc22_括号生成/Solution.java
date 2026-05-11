package lc22_括号生成;

import java.util.*;

public class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0, new StringBuilder());
        return res;
    }

    void dfs(int n, int left, int right, StringBuilder cur) {
        if (cur.length() == 2 * n) {
            res.add(String.valueOf(cur));
            return;
        }
        if (left < n) {
            cur.append('(');
            left++;
            dfs(n, left, right, cur);
            cur.deleteCharAt(cur.length() - 1);
            left--;
        }
        if (right < left) {
            cur.append(')');
            right++;
            dfs(n, left, right, cur);
            cur.deleteCharAt(cur.length() - 1);
            right--;
        }
    }
}
