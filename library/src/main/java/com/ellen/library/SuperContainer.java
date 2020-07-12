package com.ellen.library;

import java.util.ArrayList;
import java.util.List;

public class SuperContainer<T extends Resource<E>,E> implements Container<T,E> {

    private List<T> container;

    public SuperContainer() {
        container = new ArrayList<>();
    }

    @Override
    public void add(T t) {
        container.add(t);
    }

    @Override
    public void remove(T t) {
        container.remove(t);
    }

    @Override
    public void clear() {
        container.clear();
    }

    @Override
    public int size() {
        return container.size();
    }

    @Override
    public boolean isContains(E e) {
        boolean isContains = false;
        for(Resource<E> resource:container){
            if(resource.getT().equals(e)){
                isContains = true;
                break;
            }
        }
        return isContains;
    }

    @Override
    public Resource<E> getResource(E e) {
        Resource<E> result = null;
        for(Resource<E> resource:container){
            if(resource.getT().equals(e)){
                result = resource;
                break;
            }
        }
        return result;
    }

    @Override
    public void adjust(T t) {

    }

    /**
     * 移除最近最少使用的，然后再进行调整
     * @param t
     */
    @Override
    public void removeAdjust(T t) {
        //删除掉最近最少使用的

        adjust(t);

    }

}
