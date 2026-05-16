package lc739_每日温度;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            if (!stack.isEmpty() &&
                    temperatures[i] > temperatures[stack.peek()]) {
                while (!stack.isEmpty() &&
                        temperatures[stack.peek()] < temperatures[i]) {
                    int index = stack.pop();
                    res[index] = i - index;
                }
            }
            stack.push(i);
        }
        return res;
    }
}
