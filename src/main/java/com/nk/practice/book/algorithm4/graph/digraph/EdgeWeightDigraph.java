package com.nk.practice.book.algorithm4.graph.digraph;

import com.nk.practice.book.algorithm4.graph.mst.EdgeBag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author ningke
 * @date 2021/9/1
 */
public class EdgeWeightDigraph {

    private EdgeBag<DirectEdge>[] adj;

    private int V;

    private int E;

    public int V() {
        return V;
    }

    public void init(int v) {
        V = v;
        adj = new EdgeBag[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new EdgeBag();
        }
    }

    public EdgeWeightDigraph(String path) {
        try {
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String V = reader.readLine();
            String E = reader.readLine();
            init(Integer.parseInt(V));
            String str = "";
            while ((str = reader.readLine()) != null) {
                String[] values = str.split(" ");
                int v = Integer.parseInt(values[0]);
                int w = Integer.parseInt(values[1]);
                double weight = Double.parseDouble(values[2]);
                DirectEdge edge = new DirectEdge(v, w, weight);
                addEdger(edge);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void addEdger(DirectEdge edge) {
        adj[edge.from()].add(edge);
        E++;
    }

    public Iterable<DirectEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectEdge> edges() {
        EdgeBag<DirectEdge> edges = new EdgeBag<>();
        for (EdgeBag<DirectEdge> directEdges : adj) {
            for (DirectEdge directEdge : directEdges) {
                edges.add(directEdge);
            }
        }
        return edges;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        Arrays.stream(adj).forEach(ele -> {
            sb.append(ele.toString()).append("\r\n");
        });
        return sb.toString();
    }

    public static void main(String[] args) {
        EdgeWeightDigraph digraph = new EdgeWeightDigraph("tinyEWD.txt");
        System.out.println(digraph);
    }
}
