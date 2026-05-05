package lc48_旋转图像;

public class Solution {
    public void rotate(int[][] matrix) {

        //上下反转
        for (int i = 0, j = matrix.length - 1; i <= j; i++, j--) {
            for (int x = 0; x < matrix[i].length; x++) {
                int t = matrix[j][x];
                matrix[j][x] = matrix[i][x];
                matrix[i][x] = t;
            }
        }

        //主对角线转置
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= i; j++) {
                int t = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = t;
            }
        }
    }
}
