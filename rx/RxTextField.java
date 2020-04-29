package com.vzharkov.ios.rx;

import apple.uikit.ITargetAction;
import apple.uikit.UITextField;
import apple.uikit.enums.UIControlEvents;
import io.reactivex.Observable;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RxTextField {
    public static Observable<String> textChanges(final UITextField textField) {
        return Observable.create(emitter -> textField.addTargetActionForControlEvents(
                new ITargetAction<UITextField>() {
                    @Override
                    public void onEvent(UITextField source, long event) {
                        emitter.onNext(source.text());
                    }
                },
                UIControlEvents.EditingChanged)
        );
    }
}
