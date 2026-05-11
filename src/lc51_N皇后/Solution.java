package lc51_N皇后;

import java.util.*;

public class Solution {
    List<List<String>> res = new ArrayList<>();
    int n;
    boolean[] col;
    boolean[] diagLT2RB;
    boolean[] diagLB2RT;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.col = new boolean[n];
        this.diagLT2RB = new boolean[2 * n];
        this.diagLB2RT = new boolean[2 * n];
        char[][] cur = new char[n][n];
        for (char[] c : cur) {
            Arrays.fill(c, '.');
        }
        dfs(0, cur);
        return res;
    }

    void dfs(int row, char[][] cur) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] c : cur) {
                list.add(String.valueOf(c));
            }
            res.add(list);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (col[i] || diagLT2RB[row - i + n] || diagLB2RT[row + i]) {
                continue;
            }
            cur[row][i] = 'Q';
            col[i] = diagLT2RB[row - i + n] = diagLB2RT[row + i] = true;
            dfs(row + 1, cur);
            cur[row][i] = '.';
            col[i] = diagLT2RB[row - i + n] = diagLB2RT[row + i] = false;
        }
    }
}
