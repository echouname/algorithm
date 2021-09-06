package com.nk.practice.book.algorithm4.graph.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author ningke
 * @date 2021/8/31
 */
public class EdgeWeightGraph {

    private EdgeBag<Edge>[] adj;

    private int V;

    private int E;

    private List<Edge> edges;

    public EdgeWeightGraph(int v) {
        init(v);
    }

    public EdgeBag<Edge>[] getAdj() {
        return adj;
    }

    public EdgeBag<Edge> getAdj(int v) {
        return adj[v];
    }

    public int getV() {
        return V;
    }

    public void init(int v) {
        V = v;
        adj = new EdgeBag[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new EdgeBag();
        }
    }

    public EdgeWeightGraph(String path) {
        try {
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String V = reader.readLine();
            String E = reader.readLine();
            edges = new ArrayList<>(this.E);
            init(Integer.parseInt(V));
            String str = "";
            while ((str = reader.readLine()) != null) {
                String[] values = str.split(" ");
                int v = Integer.parseInt(values[0]);
                int w = Integer.parseInt(values[1]);
                double weight = Double.parseDouble(values[2]);
                Edge edge = new Edge(v, w, weight);
                addEdger(edge);
                edges.add(edge);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void addEdger(Edge edge) {
        int v = edge.getEither();
        int w = edge.getOther(v);
        this.adj[v].add(edge);
        this.adj[w].add(edge);
        E++;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        Arrays.stream(adj).forEach(ele -> {
            sb.append(ele.toString()).append("\r\n");
        });
        return sb.toString();
    }


    public Iterable<Edge> edges() {
        return this.edges;
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.add(13);
        priorityQueue.add(33);
        priorityQueue.add(15);
        priorityQueue.add(1);
        priorityQueue.stream().forEach(System.out::println);
    }
}
