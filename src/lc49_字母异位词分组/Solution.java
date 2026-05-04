package lc49_字母异位词分组;

import java.util.*;

class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] charArray = str.toCharArray();
      Arrays.sort(charArray);
      String key = new String(charArray);
      map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
    }
    return new ArrayList<>(map.values());
  }
}