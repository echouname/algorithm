package com.nk.practice.book.algorithm4.string.sort;

/**
 * @author ningke
 * @date 2021/9/2
 */
public class IndexCountSort {


    private int[] count;

    private int[] aux;

    public IndexCountSort(int[] nums,int R) {
        count = new int[R+1];
        aux = new int[nums.length];
        // 统计频次
        for (int i = 0; i < nums.length; i++) {
            count[nums[i] + 1]++;
        }
        // 转化为索引
        for (int i = 0; i < count.length - 1; i++) {
            count[i + 1] += count[i];
        }
        // 使用辅助数组
        for (int i = 0; i < nums.length; i++) {
            aux[count[nums[i]]++] = nums[i];
        }
        // 回写
        for (int i = 0; i <nums.length ; i++) {
            nums[i] = aux[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 1, 2, 4, 3, 1, 2, 2, 1};
        IndexCountSort indexCountSort = new IndexCountSort(nums,5);
    }
}
