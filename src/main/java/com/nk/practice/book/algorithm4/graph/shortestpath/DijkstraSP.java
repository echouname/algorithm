package com.nk.practice.book.algorithm4.graph.shortestpath;

import com.nk.practice.book.algorithm4.graph.digraph.DirectEdge;
import com.nk.practice.book.algorithm4.graph.digraph.EdgeWeightDigraph;
import com.nk.practice.book.algorithm4.graph.mst.IndexMinPQ;

/**
 * 基于prim即时算法的小改动
 * @author ningke
 * @date 2021/9/1
 */
public class DijkstraSP extends SP {

    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightDigraph digraph, int s) {
        super(digraph, s);
        pq = new IndexMinPQ<>(digraph.V());
        pq.insert(s, 0.0);
        while (!pq.isEmpty()) {
            relax(digraph, pq.delMin());
        }
    }

    private void relax(EdgeWeightDigraph digraph, int v) {
        for (DirectEdge edge : digraph.adj(v)) {
            int w = edge.to();
            if (distTo[w] > distTo[v] + edge.weight()) {
                distTo[w] = distTo[v] + edge.weight();
                edgeTo[w] = edge;
                if (pq.contains(w)) {
                    pq.change(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    public static void main(String[] args) {
        EdgeWeightDigraph digraph = new EdgeWeightDigraph("tinyEWG.txt");
        System.out.println(digraph);
        System.out.println(new DijkstraSP(digraph, 3));
    }
}
