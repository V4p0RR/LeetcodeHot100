package lc438_找到字符串中所有字母异位词;

import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] tar = new int[26];
        int[] cur = new int[26];
        List<Integer> res = new ArrayList<>();
        int pre = 0;
        int next = 0;
        for (char c : p.toCharArray()) {
            tar[c - 'a']++;
        }
        while (next < s.length()) {
            char n_c = s.charAt(next);
            char p_c = s.charAt(pre);
            cur[n_c - 'a']++;
            next++;
            if (next - pre == p.length()) {
                if (Arrays.equals(tar, cur)) {
                    res.add(pre);
                }
                cur[p_c - 'a']--;
                pre++;
            }

        }

        return res;
    }
}
