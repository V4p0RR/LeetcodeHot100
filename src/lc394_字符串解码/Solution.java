package lc394_字符串解码;

import java.util.*;

public class Solution {
    public String decodeString(String s) {
        Deque<StringBuilder> resStack = new ArrayDeque<>();
        Deque<Integer> numStack = new ArrayDeque<>();
        int num = 0;
        StringBuilder cur = new StringBuilder();
        char[] str = s.toCharArray();
        for (char c : str) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
                continue;
            } else if (c == '[') {
                resStack.push(cur);
                numStack.push(num == 0 ? 1 : num);
                num = 0;
                cur = new StringBuilder();
                continue;
            } else if (c == ']') {
                String ss = cur.toString().repeat(numStack.pop());
                cur = new StringBuilder(resStack.pop());
                cur.append(ss);
                continue;
            }
            cur.append(c);
        }
        return cur.toString();
    }
}
