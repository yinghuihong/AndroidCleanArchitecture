package com.aspirecn.familyplatform.presentation.bundle.common.presenter;

import com.aspirecn.familyplatform.data.common.rxbus.RxBus;
import com.aspirecn.familyplatform.domain.common.UseCase;
import com.aspirecn.familyplatform.presentation.bundle.common.rxbus.Event;
import com.aspirecn.familyplatform.presentation.common.dagger2.ActivityScope;
import com.aspirecn.familyplatform.presentation.common.presenter.Presenter;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by yinghuihong on 15/11/19.
 */
@ActivityScope
public class LoginPresenter implements Presenter {


    private final UseCase useCase;
    @Inject
    RxBus _rxBus;
    private Subscription subscription;

    @Inject
    public LoginPresenter(@Named("login") UseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public void start() {
        subscription = _rxBus.toObservable()//
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object event) {
                        if (event instanceof Event.TapEvent) {
                            System.out.println("event " + ((Event.TapEvent) event).text);
                        }
                    }
                });
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    public void login() {
        useCase.execute(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String str) {
                System.out.println(str);
            }
        });
        System.out.println("has observers");
        if (_rxBus.hasObservers()) {
            Event.TapEvent event = new Event.TapEvent();
            event.text = "this is tap event";
            _rxBus.send(event);
            System.out.println("has observers");
        }

    }
}
