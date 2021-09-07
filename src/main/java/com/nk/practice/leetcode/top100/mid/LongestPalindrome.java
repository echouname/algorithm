package com.nk.practice.leetcode.top100.mid;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * @author ningke
 * @date 2021/9/7
 */
public class LongestPalindrome {

    /**
     * 中心扩散
     */
    public static String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int l1 = expandAroundCenter(s, i, i);
            int l2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(l1, l2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 这里多移动了一次 臂长+2 所以要-1
        return right - left - 1;
    }

    public static void main(String[] args) {
        // bacab
        //   abccbb
        // dabab
        System.out.println(longestPalindrome("babad"));
        //输入：s = "babad"
        //输出："bab"
        //解释："aba" 同样是符合题意的答案
    }

}
