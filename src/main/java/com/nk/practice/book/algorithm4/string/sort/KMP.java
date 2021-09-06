package com.nk.practice.book.algorithm4.string.sort;

/**
 * 利用已知信息(即模式串的最大公共前后缀)
 * 每次不匹配时 i 指针不移动，并且尽量减少j指针的移动
 * 关键是求next数组
 *
 * @author ningke
 * @date 2021/9/3
 */
public class KMP {

    private static String text = "abaaaabaaaaaaaaaaa";

    // abaca
    //   aba
    public static int sort(String text, String pattern) {
        int[] next = getNext(pattern);
        int M = pattern.length();
        int N = text.length();
        int j = 0;
        int i = 0;
        int count = 0;
        while (i < N && j < M) {
            count++;
            if (j == -1 || text.charAt(i) == pattern.charAt(j)) {
                j++;
                i++;
            } else {
                // i指针不回退，j回退到next[j]
                j = next[j];
            }
        }
        System.out.println("match count is" + count);
        if (j == M) {
            return i - j;
        } else {
            return -1;
        }
    }

    /**
     * next[j]表示在j处不匹配时下一次j指针回退的位置
     * 是最大 前后缀公共串整体右移一位求得
     */
    private static int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        // abababca
        //  abababca 错位比较后缀与前缀 j即表示子串匹配指针，也表示next[i] 时最大公共串数
        // 比较 j和i处的字符
        // 1.相等，则next[j+1] = next[j]+1
        // 2.不相等 则回退到next[j] (利用next数组本身的功能)
        int i = 0;
        int j = -1;
        while (i < pattern.length() - 1) {
            if (j == -1 || pattern.charAt(j) == pattern.charAt(i)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }


    public static void main(String[] args) {
        System.out.println("啊".charAt(0));
        String pattern = "aaaaa";
        int index = sort(text, pattern);
        System.out.println(index);
        if (index > -1) {
            System.out.println(text.substring(index, index + pattern.length()));
        }
    }
}
