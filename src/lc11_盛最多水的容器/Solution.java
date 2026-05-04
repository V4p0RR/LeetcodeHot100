package lc11_盛最多水的容器;

class Solution {
    public int maxArea(int[] height) {
        int p = 0;
        int n = height.length - 1;
        int s = 0;
        for (; p < n; ) {
            int h = Math.min(height[n], height[p]);
            int ss = h * (n - p);
            s = ss < s ? s : ss;
            if (height[n] < height[p]) {
                n--;
            } else {
                p++;
            }
        }
        return s;
    }
}