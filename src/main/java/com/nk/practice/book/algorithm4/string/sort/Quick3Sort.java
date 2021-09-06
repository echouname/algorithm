package com.nk.practice.book.algorithm4.string.sort;

/**
 * 三向快排在处理大量重复元素排序可以将快排的线性对数级别降低到线性级别
 * 但是处理没有重复元素的排序性能要更差
 *
 * @author ningke
 * @date 2021/9/3
 */
public class Quick3Sort {

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int v = a[lo];
        int lt = lo;
        int gt = hi;
        int i = lo + 1;
        //   lo      lt      i     gt     hi
        //       <v      =v            >v
        while (i <= gt) {
            if (a[i] < v) {
                // i的移动是为了保证=v的数量不受影响 所以随着lt整体移动
                exchange(a, i++, lt++);
            } else if (a[i] > v) {
                exchange(a, i, gt--);
            } else {
                i++;
            }
        }
        // lt-gt 之间都是与基准值相等的数 所以直接处理俩端
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }


    private static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{13, 43, 3, 8, 5, 6, 12, 99, 13, 33, 4, 13};
        int[] a1 = new int[]{13, 13, 13, 13, 13, 13, 13};
        sort(a);
    }

}
