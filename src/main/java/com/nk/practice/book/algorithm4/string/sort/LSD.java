package com.nk.practice.book.algorithm4.string.sort;


/**
 * 低位优先字符串排序
 * 只能处理定长字符串
 *
 * @author ningke
 * @date 2021/9/2
 */
public class LSD {

    public static void sort(String[] a, int W) {
        // 对数组进行W次键索引排序完成排序
        int R = 256;
        // 使用辅助数组
        String[] aux = new String[a.length];
        for (int d = W; d >= 0; d--) {
            int[] count = new int[R + 1];
            // 统计
            for (int i = 0; i < a.length; i++) {
                count[a[i].charAt(d) + 1]++;
            }
            // 转化索引
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }

            for (int i = 0; i < a.length; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            // 回写
            for (int i = 0; i < a.length; i++) {
                a[i] = aux[i];
            }
        }
    }

    public static void main(String[] args) {
        String[] a = {"4PGC938", "2IYE230", "3CIO720", "1ICK750", "1OHV845", "4JZY524", "1ICK750", "3CIO720", "1OHV845", "1OHV845", "2RLA629", "2RLA629", "3ATW723"};
        sort(a, 6);
    }
}
