package com.github.tpeyrard.simpleLists;

public class DoubleLinkedList implements SimpleList {
    @Override
    public LinkedList.Node find(String absent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public LinkedList add(String value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String[] values() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(SimpleListNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    public class Node implements SimpleListNode {
        @Override
        public String value() {
            throw new UnsupportedOperationException();
        }
    }
}
