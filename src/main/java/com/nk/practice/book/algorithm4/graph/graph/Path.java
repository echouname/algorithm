package com.nk.practice.book.algorithm4.graph.graph;

import java.util.Stack;

/**
 * @author ningke
 * @date 2021/8/30
 */
public abstract class Path {

    /**
     * 保存到起点已知路径的上一个节点
     */
    protected int[] edgerTo;

    protected final int start;

    protected boolean[] marked;

    protected int v;

    public Path(Graph g, int s) {
        this.start = s;
        this.v = g.getV();
        edgerTo = new int[g.getV()];
        marked = new boolean[g.getV()];
    }

    public Stack<Integer> pathTo(int v) {
        Stack<Integer> stack = new Stack<>();
        for (int x = v; x != this.start; x = edgerTo[x]) {
            stack.push(x);
        }
        stack.push(this.start);
        return stack;
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName()).append("\r\n");
        for (int i = 0; i < this.v; i++) {
            if (this.hasPathTo(i)) {
                sb.append(this.start + " to " + i);
                Stack<Integer> stack = this.pathTo(i);
                while (stack.size() != 0) {
                    Integer s = stack.pop();
                    if (s == this.start) {
                        sb.append(" " + s);
                    } else {
                        sb.append("-" + s);
                    }
                }
                sb.append("\r\n");
            }
        }
        return sb.toString();
    }

    public abstract String getName();

}
