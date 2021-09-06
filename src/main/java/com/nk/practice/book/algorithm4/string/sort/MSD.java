package com.nk.practice.book.algorithm4.string.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 高位优先字符串排序
 * 从左往右 递归排序
 *
 * @author ningke
 * @date 2021/9/2
 */
public class MSD {

    private static int R = 256;

    /**
     * 小数组切换插入排序的阈值
     */
    private static int M = 2;

    private static String[] aux;


    public static void sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N - 1, 0);
    }

    public static void sort(String[] a, int lo, int hi, int d) {
        if (hi <= lo + M) {
            //  插入排序优化
            insertSort(a, lo, hi, d);
            return;
        }
        int[] count = new int[R + 2];
        // 准备 R+2 个位置 除了索引边界，还需要考虑 当超过字符串尾部时，返回-1
        // 所有的键索引+1 得到索引位置

        // 统计
        for (int i = lo; i <= hi; i++) {
            count[charAt(a[i], d) + 2]++;
        }

        // 索引转换
        for (int i = 0; i < R + 1; i++) {
            count[i + 1] += count[i];
        }
        // 使用辅助数组排序
        for (int i = lo; i <= hi; i++) {
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }
        // 回写
        for (int i = lo; i <= hi; i++) {
            // aux 回写的是数组分组 所以要 索引要减去lo
            a[i] = aux[i - lo];
        }
        // 递归子数组排序
        for (int r = 0; r < R; r++) {
            // lo + count[r], lo + count[r + 1] - 1  分组数组的分界
            sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
        }

    }

    private static void insertSort(String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j <= hi; j++) {
                if (lessThan(a[j], a[i], d)) {
                    exchange(a, i, j);
                }
            }
        }
    }

    private static void exchange(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean lessThan(String s1, String s2, int d) {
        return charAt(s1, d) < charAt(s2, d);
    }

    private static int charAt(String s, int index) {
        if (s.length() <= index) {
            return -1;
        }
        return s.charAt(index);
    }

    public static void main(String[] args) {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("shell.txt");
        List<String> l = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String str;
            while ((str = reader.readLine()) != null) {
                String[] s = str.split(" ");
                l.addAll(Arrays.asList(s));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] a = new String[l.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = l.get(i);
        }
        sort(a);
        System.out.println(Arrays.asList(a));
    }
}
