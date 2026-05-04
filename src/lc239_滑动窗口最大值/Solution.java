package lc239_滑动窗口最大值;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];

        Deque<Integer> deque = new ArrayDeque<>(); // 存索引
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {

            // 1️⃣ 移除过期元素（窗口左边滑出）
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {//左指针的位置i-k+1
                deque.pollFirst();
            }

            // 2️⃣ 维护单调递减（把小的都干掉）
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 3️⃣ 加入当前索引
            deque.offerLast(i);

            // 4️⃣ 记录答案（窗口形成）
            if (i >= k - 1) {
                res[idx++] = nums[deque.peekFirst()];
            }
        }

        return res;
    }
}