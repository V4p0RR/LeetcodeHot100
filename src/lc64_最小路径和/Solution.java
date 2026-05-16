package lc64_最小路径和;

public class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 1; i < col; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < row; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int num = grid[i][j];
                grid[i][j] = Math.min(grid[i - 1][j] + num, grid[i][j - 1] + num);
            }
        }
        return grid[row - 1][col - 1];
    }
}
