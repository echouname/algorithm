package com.nk.practice.leetcode.top100.easy;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * @author ningke
 * @date 2021/9/8
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        //任何数和 00 做异或运算，结果仍然是原来的数，即 a \oplus 0=aa⊕0=a。
        //任何数和其自身做异或运算，结果是 00，即 a \oplus a=0a⊕a=0。
        //异或运算满足交换律和结合律，即 a \oplus b \oplus a=b \oplus a \oplus a=b \oplus (a \oplus a)=b \oplus0=ba⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b
        //
        int a = 0;
        for (int num : nums) {
            a ^= num;
        }

        return a;
    }

    public static void main(String[] args) {
        //你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
        //
        //示例 1:
        //
        //输入: [2,2,1]
        //   2  1
        //输出: 1
        //示例 2:
        //
        // [4,4,6,?,6,8,8,2,2]
        // [4,4,6,?,6,8,8,2,2]
        // [4,6,1/2?,8,2]
        //输入: [4,1,2,1,2,5,5]
        //   [4,4,1,2,1,2]
        //   [4,1,1,2,1,2]
        // 5 2 1
        //     [4,4 11
        //输出: 4
    }
}
