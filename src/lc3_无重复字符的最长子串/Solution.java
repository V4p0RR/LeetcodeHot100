package lc3_无重复字符的最长子串;

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int count = 0;
        for (; right < s.length(); right++) {
            char c = s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            count = Math.max(count, right - left + 1);
        }
        return count;
    }
}