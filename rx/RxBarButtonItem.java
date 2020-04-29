package com.vzharkov.ios.rx;

import apple.uikit.UIBarButtonItem;
import com.vzharkov.ios.rx.action.RxTargetActionProxy;
import io.reactivex.Observable;
import lombok.experimental.UtilityClass;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.SEL;

@UtilityClass
public class RxBarButtonItem {
    public static Observable<Boolean> clicks(final UIBarButtonItem barButtonItem) {
        return Observable.create(emitter -> {
                RxTargetActionProxy<UIBarButtonItem> proxy = new RxTargetActionProxy<>(
                        (source) -> emitter.onNext(Boolean.TRUE));
                ObjCRuntime.associateObjCObject(barButtonItem, proxy);
                barButtonItem.setTarget(proxy);
                barButtonItem.setAction(new SEL("proxySelector:"));
            });
    }
}
