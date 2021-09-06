package com.nk.practice.book.algorithm4.graph.graph.cc;

import com.nk.practice.book.algorithm4.graph.graph.Graph;

/**
 * @author ningke
 * @date 2021/8/30
 */
public class CCTest {

    public static void main(String[] args) {
        Graph graph = new Graph("tinyG.txt");
        System.out.println(graph);
        CC cc = new CC(graph);
        System.out.println(cc.count());

    }

}
