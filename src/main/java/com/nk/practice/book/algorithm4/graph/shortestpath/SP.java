package com.nk.practice.book.algorithm4.graph.shortestpath;

import com.nk.practice.book.algorithm4.graph.digraph.DirectEdge;
import com.nk.practice.book.algorithm4.graph.digraph.EdgeWeightDigraph;

import java.util.Stack;

/**
 * @author ningke
 * @date 2021/9/1
 */
public class SP {

    /**
     * 起点
     */
    protected int s;

    private EdgeWeightDigraph digraph;

    /**
     * 起点到顶点v的最短距离
     */
    protected double[] distTo;

    /**
     * 起点到v最短距离的顶点v的边
     */
    protected DirectEdge[] edgeTo;

    public SP(EdgeWeightDigraph digraph, int s) {
        this.s = s;
        this.digraph = digraph;
        this.distTo = new double[digraph.V()];
        this.edgeTo = new DirectEdge[digraph.V()];

        for (int i = 0; i < digraph.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0;
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

//    /**
//     * 松弛边
//     */
//    public void relax(DirectEdge edge) {
//        int v = edge.from();
//        int w = edge.to();
//        if (distTo(w) > distTo[v] + edge.weight()) {
//            edgeTo[w] = edge;
//            distTo[w] = distTo[v] + edge.weight();
//        }
//    }
//
//    /**
//     * 松弛顶点
//     */
//    public void relax(DirectEdge edge, int v) {
//        // TODO
//    }


    public Stack<DirectEdge> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<DirectEdge> path = new Stack<>();
        for (DirectEdge edge = edgeTo[v]; edge != null; edge = edgeTo[edge.from()]) {
            path.push(edge);
        }
        return path;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digraph.V(); i++) {
            sb.append(this.s).append(" to " + i).append(" (" + distTo(i) + "): ");
            if (hasPathTo(i)) {
                Stack<DirectEdge> paths = pathTo(i);
                while (!paths.isEmpty()){
                    DirectEdge directEdge = paths.pop();
                    sb.append(directEdge.from()).append("->").append(directEdge.to()).append(" ").append(directEdge.weight()).append(" ");
                }
            }
            sb.append("\r\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        EdgeWeightDigraph digraph = new EdgeWeightDigraph("tinyEWG.txt");
        SP sp = new SP(digraph, 0);
        System.out.println(sp);
    }
}
