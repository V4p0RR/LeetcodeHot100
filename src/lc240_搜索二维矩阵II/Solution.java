package lc240_搜索二维矩阵II;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0, j = matrix[0].length - 1; i < matrix.length && j >= 0; ) {
            int cur = matrix[i][j];
            if (cur == target) {
                return true;
            }
            if (cur > target) {
                j--;
                continue;
            }
            if (cur < target) {
                i++;
            }
        }
        return false;
    }
}
