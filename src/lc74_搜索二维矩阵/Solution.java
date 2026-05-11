package lc74_搜索二维矩阵;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int weight = matrix[0].length;
        int height = matrix.length;
        ;
        int right = height * weight - 1;
        while (left <= right) {
            int index = (left + right) / 2;
            int row = index / weight;
            int col = index % weight;
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] > target) {
                right = index - 1;
                continue;
            }
            if (matrix[row][col] < target) {
                left = index + 1;
            }
        }
        return false;
    }
}
