package com.nk.practice.book.algorithm4.graph.graph;

import com.nk.practice.book.algorithm4.graph.Bag;

/**
 * @author ningke
 * @date 2021/8/27
 */
public class Dfs {

    private boolean[] marked;

    private int count;

    public Dfs(Graph graph, int v) {
        marked = new boolean[graph.getV()];
        dfs(graph, v);
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        count++;
        for (Bag.Node node : graph.getAdj()[v]) {
            if (!marked[node.getVal()]) {
                dfs(graph, node.getVal());
            }
        }
    }

    public void mark(int w) {
        marked[w] = true;
    }

    public int getCount() {
        return count;
    }
}
