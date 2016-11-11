package com.github.tpeyrard.simpleLists;

public interface SimpleList {
    SimpleListNode find(String absent);

    SimpleList add(String value);

    void reset();

    String[] values();

    void delete(SimpleListNode node);

    boolean isEmpty();
}
