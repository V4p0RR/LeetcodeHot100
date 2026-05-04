import java.util.*;

class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    int i = 0;
    int p = 0;
    int n = 0;
    Arrays.sort(nums);// 先排序
    for (; i < nums.length - 2; i++) { // 只在右边找 去重
      if (i > 0 && nums[i] == nums[i - 1]) {// 去重 先判断i>0!
        continue;
      }
      // 初始化
      p = i + 1;
      n = nums.length - 1;
      while (p < n) {
        int sum = nums[i] + nums[p] + nums[n];
        if (sum == 0) {
          res.add(Arrays.asList(nums[i], nums[p], nums[n]));
          // 左去重
          while (p < n && nums[p] == nums[p + 1]) {
            p++;
          }
          // 右去重
          while (p < n && nums[n] == nums[n - 1]) {
            n--;
          }
          p++; // 因为只是移到重复元素的边界上 没有移到第一个非重复元素上
          n--;
        } else if (sum < 0) {// 太小了 左边右移
          p++;
        } else {// 太大了 右边左移
          n--;
        }
      }
    }
    return res;
  }
}