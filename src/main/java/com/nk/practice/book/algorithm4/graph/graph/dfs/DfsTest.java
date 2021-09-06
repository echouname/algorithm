package com.nk.practice.book.algorithm4.graph.graph.dfs;

import com.nk.practice.book.algorithm4.graph.graph.Graph;

/**
 * @author ningke
 * @date 2021/8/27
 */
public class DfsTest {

    public static void main(String[] args) {

        Graph graph = new Graph("tinyCG.txt");
        System.out.println(graph);
        int start = 0;
        DepthFirstPaths depthFirstPaths = new DepthFirstPaths(graph, start);
        System.out.println(depthFirstPaths);
    }

}
