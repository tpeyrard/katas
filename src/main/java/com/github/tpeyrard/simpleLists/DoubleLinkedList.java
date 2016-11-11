package com.github.tpeyrard.simpleLists;

import java.util.Objects;

public final class DoubleLinkedList implements SimpleList {

    private Node head;
    private int size;

    @Override
    public SimpleListNode find(String toFind) {
        Node current = this.head;
        while (current != null) {
            if (current.value().equals(toFind)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public SimpleList add(String value) {
        Node newValue = new Node(value);
        if (head == null) {
            head = newValue;
        } else {
            Node current = head.next;
            Node previous = head;
            while (current != null) {
                previous = current;
                current = current.next;
            }
            previous.next = newValue;
            newValue.previous = previous;
        }
        size++;
        return this;
    }

    @Override
    public void reset() {
        head = null;
        size = 0;
    }

    @Override
    public String[] values() {
        String[] values = new String[size];
        Node current = head;
        int i = 0;
        while (current != null) {
            values[i] = current.value;
            current = current.next;
            i++;
        }
        return values;
    }

    @Override
    public void delete(SimpleListNode toDelete) {
        Node current = head;
        if (toDelete.equals(head)) {
            head = head.next;
            if (head != null && head.next != null) {
                head.next.previous = head;
            }
            size--;
        } else {
            while (current != null) {
                if (current.equals(toDelete)) {
                    Node previous = current.previous;
                    if (current.next != null) {
                        current.next.previous = previous;
                    }
                    previous.next = current.next;
                    size--;
                    break;
                }
                current = current.next;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public final class Node implements SimpleListNode {
        private final String value;
        private Node next;
        private Node previous;

        public Node(String value) {
            this.value = value;
        }

        @Override
        public String value() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(value);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    ", next=" + next.value +
                    ", previous=" + (previous != null ? previous.value : "null") +
                    '}';
        }
    }
}
