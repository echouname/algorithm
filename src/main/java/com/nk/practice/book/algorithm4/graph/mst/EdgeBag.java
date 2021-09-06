package com.nk.practice.book.algorithm4.graph.mst;

import lombok.Data;

import java.util.Iterator;

/**
 * @author ningke
 * @date 2021/8/27
 */
@Data
public class EdgeBag<T> implements Iterable<T> {

    private int num;

    private Node<T> first;

    public void add(T edge) {
        Node n = new Node(edge);
        Node old = first;
        first = n;
        first.next = old;
        num++;
    }

    private class Itr implements Iterator<T> {

        Node<T> curr = first;

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public T next() {
            Node<T> node = curr;
            curr = curr.next;
            return node.getVal();
        }
    }

    @Override
    public Iterator iterator() {
        return new Itr();
    }

    @Data
    public static class Node<T> {

        private T val;

        private Node<T> next;

        public Node(T val) {
            this.val = val;
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T edge : this) {
            sb.append(edge.toString()).append("->");
        }
        if (sb.length() > 0) {
            return sb.toString().substring(0, sb.length() - 2);
        } else {
            return sb.toString();
        }
    }
}


