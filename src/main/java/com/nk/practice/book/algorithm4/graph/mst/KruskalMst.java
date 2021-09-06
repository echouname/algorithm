package com.nk.practice.book.algorithm4.graph.mst;

/**
 * @author ningke
 * @date 2021/8/31
 */

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.PriorityQueue;

/**
 * 按照优先队列边权重顺序加入边，并且保证不会形成环，逐渐由森林形成树
 */
public class KruskalMst {

    private ArrayQueue<Edge> mst;

    public KruskalMst(EdgeWeightGraph graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (Edge edge : graph.edges()) {
            pq.add(edge);
        }
        UF uf = new UF(graph.getV());
        mst = new ArrayQueue<>(graph.getV() - 1);
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int either = edge.getEither();
            int other = edge.getOther(either);
            // 判断
            if (uf.isConnected(either, other)) {
                continue;
            }
            uf.union(either, other);
            mst.add(edge);
        }
        System.out.println(uf.count());
    }

    public ArrayQueue<Edge> edges() {
        return mst;
    }

    public static void main(String[] args) {
        EdgeWeightGraph graph = new EdgeWeightGraph("tinyEWG.txt");
        KruskalMst kruskalMst = new KruskalMst(graph);
        kruskalMst.edges().forEach(System.out::println);
    }
}
