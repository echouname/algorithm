package com.nk.practice.book.algorithm4.graph.graph.cc;

import com.nk.practice.book.algorithm4.graph.Bag;
import com.nk.practice.book.algorithm4.graph.graph.Graph;

/**
 * @author ningke
 * @date 2021/8/30
 */
public class CC {

    /**
     * 顶点数组 通过id关联
     */
    private int[] ids;

    private boolean[] marked;

    private int id;

    public CC(Graph graph) {
        this.ids = new int[graph.getV()];
        this.marked = new boolean[graph.getV()];
        for (int i = 0; i < graph.getV(); i++) {
            if (!marked[i]) {
                dfs(graph, i);
                id++;
            }
        }
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        ids[v] = id;
        for (Bag.Node node : graph.getAdj(v)) {
            if (!marked[node.getVal()]) {
                dfs(graph, node.getVal());
            }
        }
    }

    public boolean isConnected(int v, int w) {
        return ids[v] == ids[w];
    }

    public int id(int v) {
        return ids[v];
    }

    public int count() {
        return this.id;
    }
}
