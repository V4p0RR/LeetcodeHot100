package lc54_螺旋矩阵;

import java.util.*;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int left = 0;
        List<Integer> res = new ArrayList<>();
        while (top <= bottom && left <= right) {
            //走top
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            //走right
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            //走bottom
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            //走left
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }

        return res;
    }
}
