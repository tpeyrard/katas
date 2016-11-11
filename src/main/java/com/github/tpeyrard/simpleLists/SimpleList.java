package com.github.tpeyrard.simpleLists;

public interface SimpleList {
    LinkedList.Node find(String absent);

    LinkedList add(String value);

    void reset();

    String[] values();

    void delete(SimpleListNode node);

    boolean isEmpty();
}
