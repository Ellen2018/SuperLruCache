package com.ellen.library;

/**
 * 具体的资源类
 * @param <T>
 */
public class Resource<T> {

    private T t;
    private int userTimes = 0;
    private long userTime = System.currentTimeMillis();

    public Resource(T t) {
        this.t = t;
    }

    public int getUserTimes() {
        return userTimes;
    }

    public void setUserTimes(int userTimes) {
        this.userTimes = userTimes;
    }

    public T getT() {
        return t;
    }

    @Override
    public boolean equals(Object o) {
        return this.equals(o);
    }

    @Override
    public int hashCode() {
        return t.hashCode();
    }

    public void setUserTime(long userTime) {
        this.userTime = userTime;
    }

    public long getUserTime() {
        return userTime;
    }
}
