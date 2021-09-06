package com.nk.practice.book.algorithm4.graph.mst;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.PriorityQueue;

/**
 * @author ningke
 * @date 2021/8/31
 */
public class LazyPrimMst {

    private ArrayQueue<Edge> mst;

    private PriorityQueue<Edge> pq;

    private boolean[] marked;


    public LazyPrimMst(EdgeWeightGraph graph) {
        mst = new ArrayQueue<>(graph.getV());
        pq = new PriorityQueue<>();
        marked = new boolean[graph.getV()];
        visit(graph, 0);
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int v = edge.getEither();
            int w = edge.getOther(v);
            if (!marked[v] && !marked[w]) {
                // 跳过失效边
                return;
            }
            mst.add(edge);
            if (!marked[v]) {
                visit(graph, v);
            }
            if (!marked[w]) {
                visit(graph, w);
            }
        }
    }

    private void visit(EdgeWeightGraph graph, int v) {
        // 将v的领接边入队
        marked[v] = true;
        for (Edge edge : graph.getAdj(v)) {
            if (!marked[edge.getOther(v)]) {
                pq.add(edge);
            }
        }
    }

    public Iterable edges() {
        return this.mst;
    }

    public static void main(String[] args) {
        EdgeWeightGraph graph = new EdgeWeightGraph("tinyEWG.txt");
        LazyPrimMst lazyPrimMst = new LazyPrimMst(graph);
        System.out.println(">>>>>lazy mst result<<<<");
        lazyPrimMst.edges().forEach(System.out::println);
    }
}
