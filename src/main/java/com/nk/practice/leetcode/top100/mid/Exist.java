package com.nk.practice.leetcode.top100.mid;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * @author ningke
 * @date 2021/9/22
 */
public class Exist {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    // 从这里尝试生成单词
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int idx) {
        if (idx == word.length()) {
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        if (i >= m || i < 0 || j < 0 || j >= n) {
            return false;
        }
        if (board[i][j] == '0') {
            return false;
        }
        char c = board[i][j];
        if (word.charAt(idx) != c) {
            return false;
        }
        // 标记
        board[i][j] = '0';
        if (dfs(board, word, i + 1, j, idx + 1)) {
            return true;
        }
        boolean exist = dfs(board, word, i - 1, j, idx + 1)
                || dfs(board, word, i + 1, j, idx + 1)
                || dfs(board, word, i, j - 1, idx + 1)
                || dfs(board, word, i, j + 1, idx + 1);
        // 清除标记
        board[i][j] = c;
        return exist;
    }

    public static void main(String[] args) {
        Exist exist = new Exist();
        char[][] chars = new char[][]{new char[]{'A', 'B', 'C', 'E'}, new char[]{'S', 'F', 'C', 'S'}, new char[]{'A', 'D', 'E', 'E'}};
        char[][] chars1 = new char[][]{new char[]{'A'}};
        boolean abcb = exist.exist(chars, "A");
        System.out.println(abcb);
        //[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
        //"ABCB"
        //提示：
        //
        //m == board.length
        //n = board[i].length
        //1 <= m, n <= 6
        //1 <= word.length <= 15
        //board 和 word 仅由大小写英文字母组成
        // 
        //
        //进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
    }

}
