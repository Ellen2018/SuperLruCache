package com.ellen.library;

public interface Container<T extends Resource<E>,E> {
    void add(T t);
    void remove(T t);
    void clear();
    int size();
    boolean isContains(E e);
    Resource<E> getResource(E e);
    void adjust(T t);
    void removeAdjust(T t);
}
