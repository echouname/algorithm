package com.nk.practice.book.algorithm4.graph.graph;


import com.nk.practice.book.algorithm4.graph.graph.bfs.BreadthFirstPaths;
import com.nk.practice.book.algorithm4.graph.graph.dfs.DepthFirstPaths;

/**
 * @author ningke
 * @date 2021/8/30
 */
public class SymbolGraphTest {

    public static void main(String[] args) {
        SymbolGraph sg = new SymbolGraph("routes.txt", " ");
        System.out.println(sg);
        String start = "ORD";
        if (!sg.contains(start)){
            throw new RuntimeException(start+" not in database");
        }
        Path deepPath = new DepthFirstPaths(sg.getGraph(), sg.index(start));
        Path breadthPath = new BreadthFirstPaths(sg.getGraph(), sg.index(start));
        sg.printPath(deepPath);
        sg.printPath(breadthPath);
    }

}
