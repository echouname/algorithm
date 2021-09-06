package com.nk.practice.book.algorithm4.graph.graph;

import com.nk.practice.book.algorithm4.graph.Bag;
import lombok.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author ningke
 * @date 2021/8/27
 */
@Data
public class Graph {

    private Bag[] adj;

    /**
     * 顶点数
     */
    private int v;

    /**
     * 邻边点数
     */
    private int e;


    public Graph(int v) {
        init(v);
    }

    public Bag getAdj(int v){
        return adj[v];
    }

    public void init(int v) {
        // 初始化邻边
        this.v = v;
        this.adj = new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag(i);
        }
    }

    public Graph(String path) {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String str;
            while ((str = reader.readLine()) != null) {
                String[] s = str.split(" ");
                if (s.length == 1) {
                    if (adj == null) {
                        init(Integer.valueOf(s[0]));
                    }
                } else {
                    Integer n1 = Integer.parseInt(s[0]);
                    Integer n2 = Integer.parseInt(s[1]);
                    adj[n1].add(n2);
                    adj[n2].add(n1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        Graph graph = new Graph("tinyG.txt");
        System.out.println(graph);
    }


    /**
     * 将两个顶点连接
     * @param
     * @return
     */
    public void addEdger(int v, int w) {
        this.adj[v].add(w);
        e++;
    }
}
