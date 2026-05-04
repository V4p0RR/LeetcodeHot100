package lc560_和为K的子数组;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            Integer sumKCount = map.get(sum - k);
            if (sumKCount != null) {
                count += sumKCount;
            }
            Integer sum_count = map.get(sum);
            if (sum_count != null && sum_count != 0) {
                map.put(sum, sum_count + 1);
            } else {
                map.put(sum, 1);
            }
        }
        return count;
    }
}
