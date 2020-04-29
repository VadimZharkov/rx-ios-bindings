package com.vzharkov.ios.rx.action;

import org.moe.natj.objc.ann.Selector;

public class RxTargetActionProxy<T> {
    TargetAction<T> targetAction;

    public RxTargetActionProxy(TargetAction<T> targetAction) {
        this.targetAction = targetAction;
    }

    @Selector("proxySelector:")
    public void proxySelector(T source) {
            targetAction.invoke(source);
    }
}
