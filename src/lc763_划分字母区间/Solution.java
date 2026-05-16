package lc763_划分字母区间;

import java.util.*;

public class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] last = new int[26];
        int start = 0;
        int end = 0;
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            last[str[i] - 'a'] = i;
        }
        for (int i = 0; i < str.length; i++) {
            end = Math.max(end, last[str[i] - 'a']);
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
                end = 0;
            }
        }
        return res;
    }
}
