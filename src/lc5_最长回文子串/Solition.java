package lc5_最长回文子串;

import java.util.*;

class Solution {
  public String longestPalindrome(String s) {
    // 初始长度
    int count = 0;
    String res = null;
    for (int cur = 0; cur <= s.length(); cur++) {
      for (int i = 0; i + cur - 1 < s.length(); i++) {
        int j = i + cur - 1;
        String cur_res = s.substring(i, j + 1);
        if (isOk(cur_res)) {
          count = cur;
          res = cur_res;
        }
      }
    }
    return res;
  }

  // 判断回文串
  public boolean isOk(String s) {
    if (s.length() == 1) {
      return true;
    }
    if (s.length() == 2 && s.charAt(0) == s.charAt(1)) {
      return true;
    }

    if (s.charAt(0) == s.charAt(s.length() - 1)) {
      String s1 = s.substring(1, s.length() - 1);
      if (isOk(s1)) {
        return true;
      }
    }

    return false;
  }

}