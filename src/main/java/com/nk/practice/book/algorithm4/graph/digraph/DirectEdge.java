package com.nk.practice.book.algorithm4.graph.digraph;

/**
 * 有向边
 *
 * @author ningke
 * @date 2021/9/1
 */
public class DirectEdge {

    private int from;

    private int to;

    private double weight;

    public DirectEdge(int v, int w, double weight) {
        this.from = v;
        this.to = w;
        this.weight = weight;
    }

    public int from() {
        return from;
    }

    public int to() {
        return to;
    }

    public double weight() {
        return weight;
    }

    @Override
    public String toString() {
        return "DirectEdge{" +
                "from=" + from +
                ", to=" + to +
                ", weight=" + weight +
                '}';
    }
}
