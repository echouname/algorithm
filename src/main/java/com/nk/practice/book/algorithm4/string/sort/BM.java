package com.nk.practice.book.algorithm4.string.sort;

/**
 * BM 利用坏后缀 最大程度的跳过不必要的字串匹配
 *
 * @author ningke
 * @date 2021/9/6
 */
public class BM {


    public static int search(String text, String pattern) {
        int M = pattern.length();
        int N = text.length();
        int i = 0;
        int[] right = getRight(pattern);
        //   i   i+j
        // FINDINNEEDLE
        //   NEEDLE
        //       j
        // 从右往左匹配
        int skip;
        while (i <= N - M) {
            skip = 0;
            for (int j = M - 1; j >= 0; j--) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    // 1. i+j 在模式串中没有出现 j重置为M-1 i前进 j+1
                    // 2.1 i+j 在模式串中出现 i+j与最后一次出现的位置对齐 i 移动游标移动的距离
                    // 2.2 移动的距离不能保证i+1 则使i+1
                    // 实际上1 和2.1的计算skip方式可以合成一步
                    // 每次不匹配总是重置j
                    skip = j - right[text.charAt(i + j)];
                    if (skip < 1) {
                        skip = 1;
                    }
                    i += skip;
                    break;
                }
            }
            if (skip == 0) {
                return i;
            }
        }
        return -1;
    }

    private static int[] getRight(String pattern) {
        int[] right = new int[256];
        for (int i = 0; i < right.length; i++) {
            right[i] = -1;
        }
        for (int i = 0; i < pattern.length(); i++) {
            right[pattern.charAt(i)] = i;
        }
        return right;
    }

    public static void main(String[] args) {
        String text = "abacadabrabracabracadabrabrabracad";
        String pattern = "rabrabracad";
        int match = search(text, pattern);
        System.out.println(match);
        if (match > 0) {
            System.out.println(text.substring(match, match + pattern.length()));
        }
    }
}
