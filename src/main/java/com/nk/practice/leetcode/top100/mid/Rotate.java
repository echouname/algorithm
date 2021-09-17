package com.nk.practice.leetcode.top100.mid;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * <p>
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * @author ningke
 * @date 2021/9/15
 */
public class Rotate {

    public void rotate(int[][] matrix) {
        int l = matrix.length;
        for (int i = 0; i < l / 2; i++) {
            for (int j = 0; j < (l + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[l - j - 1][i];
                matrix[l - j - 1][i] = matrix[l - i - 1][l - j - 1];
                matrix[l - i - 1][l - j - 1] = matrix[j][l - i - 1];
                matrix[j][l - i - 1] = temp;
            }
        }
    }


    public static void main(String[] args) {
        //  n = 4
        // 0 0  0 3
        // 1 0  0 2
        // 2 0  0 1
        // 3 0  0 0
        //         2  3             3     1
        //    matrix[j][n - i -1] = matrix[i][j]
    }

}
