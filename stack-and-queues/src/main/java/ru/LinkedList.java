package ru;

public class LinkedList<T> {

    private Node node;

    private class Node {
        T item;
        Node next;

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public void push(T el) {
        node = new Node(el, node);
    }

    public T poll() {
        T result = node.item;
        node = node.next;
        return result;
    }
}
