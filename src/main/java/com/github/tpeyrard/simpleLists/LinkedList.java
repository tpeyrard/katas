package com.github.tpeyrard.simpleLists;

import java.util.Objects;

public class LinkedList implements SimpleList {

    private Node head = null;
    private int size = 0;

    public SimpleListNode find(String searched) {
        Node current = head;
        while (current != null) {
            if (current.value.equals(searched)) {
                return current;
            } else {
                current = current.next;
            }
        }
        return null;
    }

    public SimpleList add(String value) {
        Node newValue = new Node(value);
        if (head == null) {
            head = newValue;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newValue;
        }
        size++;
        return this;
    }

    public void reset() {
        head = null;
        size = 0;
    }

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

    public void delete(SimpleListNode toDelete) {
        if (toDelete.equals(head)) {
            head = head.next;
            size--;
        } else {
            Node previous = head;
            Node current = head;
            while (current != null) {
                if (current.equals(toDelete)) {
                    previous.next = current.next;
                    size--;
                    break;
                }
                previous = current;
                current = current.next;
            }
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public final class Node implements SimpleListNode {
        private final String value;
        private Node next;

        public Node(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }

        @Override
        public String toString() {
            return "[value='" + value + "', next='" + next + "']";
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
    }
}
