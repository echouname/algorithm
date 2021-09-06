package com.nk.practice.book.algorithm4.graph.graph.bfs;

import com.nk.practice.book.algorithm4.graph.graph.Graph;

/**
 * @author ningke
 * @date 2021/8/30
 */
public class BfsTest {

    public static void main(String[] args) {
        Graph graph = new Graph("tinyCG.txt");
        System.out.println(graph);
        int start = 0;
        BreadthFirstPaths breadthFirstPaths = new BreadthFirstPaths(graph, start);
        System.out.println(breadthFirstPaths);
    }

}
