package com.nk.practice.book.algorithm4.string.sort;

/**
 * 手动回溯指针的暴力匹配
 *
 * @author ningke
 * @date 2021/9/3
 */
public class BF {

    private static String text = "abaaaabaaaaaaaaaaa";


    private static int match(String pattern) {
        int M = pattern.length();
        int N = text.length();
        int i = 0, j = 0;
        int count = 0;
        for (; i < N && j < M; i++) {
            count++;
            if (text.charAt(i) != pattern.charAt(j)) {
                i -= j;
                j = 0;
            }else {
                j++;
            }
        }
        System.out.println("count:"+count);
        if (j == M) {
            return i - M;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        String pattern = "aaaaa";
        int match = match(pattern);
        System.out.println(match);
        System.out.println(text.substring(match,match+pattern.length()));
    }

}
