package com.nk.practice.book.algorithm4.graph.mst;

/**
 * @author ningke
 * @date 2021/8/31
 */
public class PrimMst {

    private IndexMinPQ<Double> pq;

    /**
     * 连接顶点v的最短边
     */
    private Edge[] edgeTo;

    /**
     * 连接顶点v最短边的权重
     */
    private double[] distTo;

    private boolean[] marked;

    public PrimMst(EdgeWeightGraph graph) {
        pq = new IndexMinPQ<>(graph.getV());
        edgeTo = new Edge[graph.getV()];
        distTo = new double[graph.getV()];
        marked = new boolean[graph.getV()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[0] = 0.0;
        pq.insert(0, 0.0);
        while (!pq.isEmpty()) {
            visit(graph, pq.delMin());
        }
    }

    private void visit(EdgeWeightGraph graph, int v) {
        marked[v] = true;
        for (Edge edge : graph.getAdj(v)) {
            int w = edge.getOther(v);
            if (marked[w]) {
                continue;
            }
            if (edge.getWeight() < distTo[w]) {
                edgeTo[w] = edge;
                distTo[w] = edge.getWeight();
                if (pq.contains(w)) {
                    pq.change(w, edge.getWeight());
                } else {
                    pq.insert(w, edge.getWeight());
                }
            }
        }
    }

    public static void main(String[] args) {
        EdgeWeightGraph graph = new EdgeWeightGraph("tinyEWG.txt");
        PrimMst mst = new PrimMst(graph);
    }
}
