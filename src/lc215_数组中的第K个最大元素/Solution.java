package lc215_数组中的第K个最大元素;


import java.util.Random;

class Solution {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int left = 0, right = nums.length - 1;

        while (true) {
            int[] range = partition(nums, left, right);

            if (target < range[0]) {
                right = range[0] - 1;
            } else if (target > range[1]) {
                left = range[1] + 1;
            } else {
                return nums[target];
            }
        }
    }

    private int[] partition(int[] nums, int left, int right) {
        int rand = left + random.nextInt(right - left + 1);
        swap(nums, rand, right);

        int pivot = nums[right];

        int lt = left;
        int gt = right;
        int i = left;

        while (i <= gt) {
            if (nums[i] < pivot) {
                swap(nums, lt++, i++);
            } else if (nums[i] > pivot) {
                swap(nums, i, gt--);
            } else {
                i++;
            }
        }

        return new int[]{lt, gt};
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
