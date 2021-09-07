package com.nk.practice.leetcode.top100.mid;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author ningke
 * @date 2021/9/7
 */
public class LengthOfLongestSubstring {


    public static int lengthOfLongestSubstring(String s) {
        int[] right = new int[256];
        for (int i = 0; i < right.length; i++) {
            right[i] = -1;
        }
        int maxLength = 0, index = -1;
        for (int i = 0; i < s.length(); i++) {
            int last = right[s.charAt(i)];
            right[s.charAt(i)] = i;
            if (last != -1 && last > index && last != i) {
                // 回退到最右边的位置
                maxLength = Math.max(i - last, maxLength);
                i = last;
                index = last;
                continue;
            }
            maxLength = Math.max(i - index, maxLength);
        }
        return maxLength;
    }

    public static int best(String s) {
        int[] right = new int[128];
        int maxLength = 0, j = 0;
        for (int i = 0; i < s.length(); i++) {
            // j指针回退
            j = Math.max(j, right[s.charAt(i)] + 1);
            maxLength = Math.max(i - j + 1, maxLength);
            right[s.charAt(i)] = i;
        }
        return maxLength;
    }


    public static void main(String[] args) {
        //输入: s = "abbacbb"
        //输入: s = "abcacde"
        //输出: 3
        //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
        System.out.println(best("abb"));
        System.out.println(best("abab"));
        System.out.println(best("pwwkew"));
        System.out.println(best("aaaaaa"));
        System.out.println(best(" "));
    }
}
