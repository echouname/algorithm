package com.nk.practice.leetcode.top100.hard;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * @author ningke
 * @date 2021/9/7
 */
public class FindMedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index = nums1.length + nums2.length;
        int l1 = nums1.length;
        int l2 = nums2.length;
        int i1 = 0;
        int i2 = 0;
        double mid = 0;
        for (int i = 0; i <= index; i++) {
            int min = Integer.MAX_VALUE;
            int n1 = Integer.MAX_VALUE;
            int n2 = Integer.MAX_VALUE;
            if (i1 < l1) {
                if (nums1[i1] < min) {
                    n1 = nums1[i1];
                }
            }
            if (i2 < l2) {
                if (nums2[i2] < min) {
                    n2 = nums2[i2];
                }
            }

            if (n1 < n2) {
                i1++;
                min = n1;
            } else {
                i2++;
                min = n2;
            }

            if (index % 2 == 0 && i == index / 2 - 1) {
                mid += min;
                continue;
            }

            if (i == index / 2) {
                mid += min * (index % 2 + 1);
                break;
            }
        }
        return mid / 2;
    }

    // 0 1 2 3
    public static void main(String[] args) {
        // 1 2 3 7
        //System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 7}));
        // [1,3 ,5, 7] [11,22,33]
        //输入：nums1 = [1,3], nums2 = [2]
        //输出：2.00000
        //解释：合并数组 = [1,2,3] ，中位数 2

        //输入：nums1 = [1,2], nums2 = [3,4]
        //输出：2.50000
        //解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5

        //输入：nums1 = [0,0], nums2 = [0,0]
        //输出：0.00000

        //输入：nums1 = [], nums2 = [1]
        //输出：1.00000
    }
}
