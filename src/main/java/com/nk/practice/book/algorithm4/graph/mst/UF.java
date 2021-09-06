package com.nk.practice.book.algorithm4.graph.mst;

/**
 * @author ningke
 * @date 2021/9/1
 */
public class UF {

    /**
     * id
     */
    private int[] ids;

    /**
     * 组数
     */
    private int count;


    public UF(int n) {
        // init
        this.count = n;
        this.ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
    }

    public boolean isConnected(int v, int w) {
        return find(v) == find(w);
    }

    public void union(int v, int w) {
        int r1 = find(v);
        int r2 = find(w);
        if (r1 == r2) {
            return;
        }
        ids[r1] = r2;
        count--;
    }

    public int find(int v) {
        // find root
        while (v != ids[v]) {
            v = ids[v];
        }
        return v;
    }

    public int count() {
        return this.count;
    }
}
