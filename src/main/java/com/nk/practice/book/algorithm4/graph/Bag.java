package com.nk.practice.book.algorithm4.graph;

import lombok.Data;

import java.util.Iterator;

/**
 * @author ningke
 * @date 2021/8/27
 */
@Data
public class Bag implements Iterable<Bag.Node> {

    private Node first;

    public Bag(int i) {
        first = new Node(i);
    }

    public void add(Integer num) {
        Node n = new Node(num);
        Node next = first.next;
        n.next = next;
        first.next = n;
    }


    private class Itr implements Iterator<Node> {

        Node curr = first;

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public Node next() {
            Node node = curr;
            curr = curr.next;
            return node;
        }
    }

    @Override
    public Iterator iterator() {
        return new Itr();
    }

    @Data
    public static class Node {

        private Integer val;

        private Node next;

        public Node(Integer val) {
            this.val = val;
        }
    }


    @Override
    public String toString() {
        Node cur = first;
        StringBuilder sb = new StringBuilder();
        sb.append(first.val).append("->");
        while (cur.next != null) {
            cur = cur.next;
            sb.append((cur.getVal())).append("->");
        }
        return sb.toString().substring(0, sb.length() - 2);
    }
}


