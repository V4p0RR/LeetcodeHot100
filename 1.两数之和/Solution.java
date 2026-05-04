import java.util.*;

/**
 * 双指针解法
 */
class Solution {
  public int[] twoSum(int[] nums, int target) {
    int[] nums_copy = new int[nums.length];
    // 拷贝原数组
    System.arraycopy(nums, 0, nums_copy, 0, nums.length);
    // 排序 升序
    Arrays.sort(nums_copy);
    // 定义接收变量
    int prev = 0;
    int next = 0;
    // 和大了右边左移 小了左边右移
    for (int i = 0, j = nums_copy.length - 1; i < j;) {
      if (nums_copy[i] + nums_copy[j] > target) {
        j--;
        continue;
      } else if (nums_copy[i] + nums_copy[j] < target) {
        i++;
        continue;
      } else {
        prev = nums_copy[i];
        next = nums_copy[j];
        break;
      }
    }
    // 找下标
    int[] res = new int[2];
    int k = 0;
    for (k = 0; k < nums.length; k++) {
      if (nums[k] == prev) {
        res[0] = k;
        break;
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == next && i != k) {
        res[1] = i;
        break;
      }
    }
    return res;
  }
}