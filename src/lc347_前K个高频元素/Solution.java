package lc347_前K个高频元素;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            Integer f = map.getOrDefault(num, 0);
            map.put(num, f + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        for (int i = nums.length; k > 0; i--) {
            if (bucket[i] == null) continue;
            for (int num : bucket[i]) {
                res[index++] = num;
                k--;
            }
        }
        return res;
    }
}
