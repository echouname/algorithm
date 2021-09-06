package com.nk.practice.book.algorithm4.graph.graph.dfs;

import com.nk.practice.book.algorithm4.graph.Bag;
import com.nk.practice.book.algorithm4.graph.graph.Graph;
import com.nk.practice.book.algorithm4.graph.graph.Path;
import lombok.Getter;

/**
 * @author ningke
 * @date 2021/8/30
 */
@Getter
public class DepthFirstPaths extends Path {

    public DepthFirstPaths(Graph g, int s) {
        super(g, s);
        dfs(g, s);
    }

    @Override
    public String getName() {
        return ">>>>>>>>>>dfs result<<<<<<<<<<";
    }

    private void dfs(Graph g, int s) {
        marked[s] = true;
        for (Bag.Node node : g.getAdj(s)) {
            if (!marked[node.getVal()]) {
                edgerTo[node.getVal()] = s;
                dfs(g, node.getVal());
            }
        }
    }

}
