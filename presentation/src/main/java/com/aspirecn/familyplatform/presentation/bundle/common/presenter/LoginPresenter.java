package com.aspirecn.familyplatform.presentation.bundle.common.presenter;

import com.aspirecn.familyplatform.domain.common.UseCase;
import com.aspirecn.familyplatform.presentation.common.dagger2.ActivityScope;
import com.aspirecn.familyplatform.presentation.common.presenter.Presenter;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Subscriber;

/**
 * Created by yinghuihong on 15/11/19.
 */
@ActivityScope
public class LoginPresenter implements Presenter {


    private final UseCase useCase;


    @Inject
    public LoginPresenter(@Named("login") UseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

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
    }
}
