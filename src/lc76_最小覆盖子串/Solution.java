package lc76_最小覆盖子串;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> cur = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.containsKey(c) ? need.get(c) + 1 : 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        String res = "";
        while (right < s.length()) {
            char right_char = s.charAt(right);
            right++;

            // 扩张
            if (need.containsKey(right_char)) {
                cur.put(right_char, cur.getOrDefault(right_char, 0) + 1);
                if (cur.get(right_char).equals(need.get(right_char))) {
                    valid++;
                }
            }

            // 收缩
            while (valid == need.size()) {
                char left_char = s.charAt(left);

                // 更新答案
                if (res.equals("") || right - left < res.length()) {
                    res = s.substring(left, right);
                }

                left++;

                if (need.containsKey(left_char)) {
                    if (cur.get(left_char).equals(need.get(left_char))) {
                        valid--;
                    }
                    cur.put(left_char, cur.get(left_char) - 1);
                }
            }
        }
        return res;
    }
}
