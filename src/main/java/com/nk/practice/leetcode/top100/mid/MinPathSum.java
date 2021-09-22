package com.nk.practice.leetcode.top100.mid;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 *
 * @author ningke
 * @date 2021/9/22
 */
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        dist[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dist[i][0] = dist[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dist[0][i] = dist[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dist[i][j] = grid[i][j] + Math.min(dist[i - 1][j], dist[i][j - 1]);
            }
        }
        return dist[m - 1][n - 1];
    }


    public static void main(String[] args) {
        int[][] grid = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}};
        MinPathSum minPathSum = new MinPathSum();
        int i = minPathSum.minPathSum(grid);
        System.out.println(i);
        //输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
        //输出：7
        //解释：因为路径 1→3→1→1→1 的总和最小。
        //示例 2：
        //
        //输入：grid = [[1,2,3],[4,5,6]]
        //输出：12
        // 
        //
        //提示：
        //
        //m == grid.length
        //n == grid[i].length
        //1 <= m, n <= 200
        //0 <= grid[i][j] <= 100
    }

}
