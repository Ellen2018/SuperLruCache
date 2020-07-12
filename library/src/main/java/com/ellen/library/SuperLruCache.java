package com.ellen.library;

public class SuperLruCache<T> {
    /**
     * 存放资源的容器
     */
    private SuperContainer<Resource<T>, T> superContainer;
    private int maxCount = 10;

    public SuperLruCache() {
        superContainer = new SuperContainer<>();
    }

    public T user(T t) {
        //先获取数量
        int size = superContainer.size();
        if (size == maxCount) {
            if (superContainer.isContains(t)) {
                Resource<T> resource = superContainer.getResource(t);
                resource.setUserTimes(resource.getUserTimes() + 1);
                resource.setUserTime(System.currentTimeMillis());
                superContainer.adjust(resource);
            } else {
                //需要移除
                Resource<T> resource = superContainer.getResource(t);
                superContainer.add(resource);
                superContainer.removeAdjust(resource);
            }
        } else {
            if (superContainer.isContains(t)) {
                Resource<T> resource = superContainer.getResource(t);
                resource.setUserTimes(resource.getUserTimes() + 1);
                resource.setUserTime(System.currentTimeMillis());
                superContainer.adjust(resource);
            } else {
                Resource<T> resource = new Resource<>(t);
                resource.setUserTimes(1);
                resource.setUserTime(System.currentTimeMillis());
                superContainer.add(resource);
                superContainer.adjust(resource);
            }
        }
        return t;
    }
}
