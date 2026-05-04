import java.util.*;

class Solution {
  public int trap(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int water = 0;
    int leftMax = height[left];
    int rightMax = height[right];
    while (left < right) {
      if (leftMax < rightMax) {
        left++;
        if (height[left] > leftMax) {
          leftMax = height[left];
        }
        water += leftMax - height[left];
      } else {
        right--;
        if (height[right] > rightMax) {
          rightMax = height[right];
        }
        water += rightMax - height[right];
      }
    }
    return water;
  }
}