package com.nk.practice.book.algorithm4.graph.mst;

/**
 * @author ningke
 * @date 2021/8/31
 */
public class Edge implements Comparable<Edge> {


    private int v;

    private int w;

    private double weight;

    public Edge(int v, int w, double weight) {
        this.weight = weight;
        this.v = v;
        this.w = w;
    }

    public double getWeight() {
        return this.weight;
    }

    public int getEither() {
        return this.v;
    }

    public int getOther(int v) {
        return this.v == v ? this.w : this.v;
    }

    @Override
    public String toString() {
        return "Edger{" +
                "v=" + v +
                ", w=" + w +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Edge other) {
        return new Double(this.weight).compareTo(new Double(other.getWeight()));
    }
}
