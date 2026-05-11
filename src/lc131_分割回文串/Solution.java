package lc131_分割回文串;

import java.util.*;

public class Solution {
    String s;
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        this.s = s;
        dfs(new ArrayList<>(), 0);
        return res;
    }

    void dfs(List<String> path, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (!isOk(start, i)) {
                continue;
            }
            path.add(s.substring(start, i + 1));
            dfs(path, i + 1);
            path.removeLast();
        }
    }

    boolean isOk(int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
