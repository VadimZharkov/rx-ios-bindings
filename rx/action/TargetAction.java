package com.vzharkov.ios.rx.action;

public interface TargetAction<T> {
    void invoke(T t);
}
