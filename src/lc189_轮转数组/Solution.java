package lc189_轮转数组;

public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(0, nums.length - 1, nums);
        reverse(0, k - 1, nums);
        reverse(k, nums.length - 1, nums);
    }

    public void reverse(int l, int r, int[] a) {
        while (l < r) {
            int x = a[r];
            a[r] = a[l];
            a[l] = x;
            l++;
            r--;
        }
    }

}

