package com.github.tpeyrard.simpleLists;

public class LinkedList implements SimpleList {

    private Node head = null;
    private int size = 0;

    public Node find(String searched) {
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

    public LinkedList add(String value) {
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
        if (head == null) {
            return new String[size];
        }
        String[] values = new String[size];
        Node currentNode = head;
        int i = 0;
        do {
            values[i++] = currentNode.value;
            currentNode = currentNode.next;
        } while (currentNode != null);
        return values;
    }

    public class Node {
        private String value;
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
    }
}
