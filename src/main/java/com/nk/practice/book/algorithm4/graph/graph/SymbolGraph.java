package com.nk.practice.book.algorithm4.graph.graph;

import com.nk.practice.book.algorithm4.graph.Bag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author ningke
 * @date 2021/8/30
 */
public class SymbolGraph {

    /**
     * name->index
     */
    private Map<String, Integer> st = new HashMap<>();

    /**
     * index->name
     */
    private String[] keys;

    private Graph graph;

    public Graph getGraph() {
        return graph;
    }

    public SymbolGraph(String path, String spt) {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
        // 构造索引
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String str;
            while ((str = reader.readLine()) != null) {
                String[] names = str.split(spt);
                for (String name : names) {
                    st.putIfAbsent(name, st.size());
                }
            }
            keys = new String[st.size()];
            for (String name : st.keySet()) {
                keys[st.get(name)] = name;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 构造图
        is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String str;
            graph = new Graph(st.size());
            while ((str = reader.readLine()) != null) {
                String[] names = str.split(spt);
                int v = st.get(names[0]);
                for (int i = 1; i < names.length; i++) {
                    graph.addEdger(v, st.get(names[i]));
                    graph.addEdger(st.get(names[i]),v);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printPath(Path path) {
        StringBuilder sb = new StringBuilder();
        sb.append(path.getName()).append("\r\n");
        for (int i = 0; i < path.v; i++) {
            if (path.hasPathTo(i)) {
                sb.append(transfer(path.start) + " to " + transfer(i));
                Stack<Integer> stack = path.pathTo(i);
                while (stack.size() != 0) {
                    Integer s = stack.pop();
                    if (s == path.start) {
                        sb.append(" " + transfer(s));
                    } else {
                        sb.append("-" + transfer(s));
                    }
                }
                sb.append("\r\n");
            }
        }
        System.out.println(sb.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Bag[] adj = graph.getAdj();
        Arrays.stream(adj).forEach(ele -> {
            for (Bag.Node node : ele) {
                sb.append(transfer(node.getVal())).append("->");
            }
            sb.append("\r\n");
        });
        return sb.toString();
    }

    public String transfer(int index) {
        return keys[index];
    }

    public int index(String name){
        return st.get(name);
    }

    public static void main(String[] args) {
        SymbolGraph symbolGraph = new SymbolGraph("routes.txt", " ");
        System.out.println(symbolGraph);
        System.out.println(symbolGraph.graph.getE());
    }

    public boolean contains(String start) {
        return st.containsKey(start);
    }
}
