package lc128_最长连续序列;

import java.util.*;

class Solution {
  public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    int maxLen = 0;
    for (int num : set) {
      if (!set.contains(num - 1)) {
        int cur = num;
        int len = 1;

        while (set.contains(cur + 1)) {
          len++;
          cur++;
        }
        maxLen = maxLen < len ? len : maxLen;
      }
    }
    return maxLen;
  }
}