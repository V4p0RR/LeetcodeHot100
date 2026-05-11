package lc79_单词搜索;

public class Solution {
    char[][] board;
    String word;
    boolean[][] isVisited;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.isVisited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(int cur, int x, int y) {
        if (cur == word.length()) {
            return true;
        }
        if (x < 0 || x >= board.length ||
                y < 0 || y >= board[x].length ||
                isVisited[x][y] ||
                board[x][y] != word.charAt(cur)) {
            return false;
        }

        isVisited[x][y] = true;
        cur++;
        boolean res = dfs(cur, x + 1, y) ||
                dfs(cur, x - 1, y) ||
                dfs(cur, x, y + 1) ||
                dfs(cur, x, y - 1);
        isVisited[x][y] = false;
        cur--;
        return res;
    }
}
