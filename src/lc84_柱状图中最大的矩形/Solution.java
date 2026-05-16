package lc84_柱状图中最大的矩形;

import java.util.*;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        int[] h = new int[heights.length + 2];//哨兵
        for (int i = 0; i < heights.length; i++) {
            h[i + 1] = heights[i];
        }
        stack.push(0);//哨兵
        for (int i = 1; i < h.length; i++) {
            while (h[i] < h[stack.peek()]) {
                int height = h[stack.pop()];
                int left_index = stack.peek();
                int cur = height * (i - left_index - 1);
                max = Math.max(cur, max);
            }
            stack.push(i);
        }
        return max;
    }
}
