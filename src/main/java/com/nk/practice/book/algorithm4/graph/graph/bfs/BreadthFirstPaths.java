package com.nk.practice.book.algorithm4.graph.graph.bfs;

import com.nk.practice.book.algorithm4.graph.Bag;
import com.nk.practice.book.algorithm4.graph.graph.Graph;
import com.nk.practice.book.algorithm4.graph.graph.Path;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author ningke
 * @date 2021/8/30
 */
public class BreadthFirstPaths extends Path {

    public BreadthFirstPaths(Graph graph, int start) {
        super(graph, start);
        bfs(graph, start);
    }

    @Override
    public String getName() {
        return ">>>>>>>>>>bfs result<<<<<<<<<<";
    }

    /**
     * 从起点开始先入队，然后将离起点最近的顶点(邻接顶点)入队,然后再依次出队并标记上一个顶点
     * 每次出队前处理的是k+1距离的顶点 ，这样就可以保证处理完成后一定是最短路径
     */
    private void bfs(Graph graph, int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        int v = start;
        marked[v] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            // 下一个顶点出队
            v = queue.poll();
            // 将邻接顶点入队
            for (Bag.Node node : graph.getAdj(v)) {
                if (!marked[node.getVal()]) {
                    queue.add(node.getVal());
                    edgerTo[node.getVal()] = v;
                    marked[node.getVal()] = true;
                }
            }
        }


    }
}
