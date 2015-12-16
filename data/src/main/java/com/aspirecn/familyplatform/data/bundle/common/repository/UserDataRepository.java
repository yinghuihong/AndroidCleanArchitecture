package com.aspirecn.familyplatform.data.bundle.common.repository;

import com.aspirecn.familyplatform.domain.bundle.common.User;
import com.aspirecn.familyplatform.domain.bundle.common.repository.UserRepository;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

//import javax.inject.Inject;
//import javax.inject.Singleton;

/**
 * Created by yinghuihong on 15/11/19.
 */
//@Singleton
public class UserDataRepository implements UserRepository {

//    @Inject
//    UserDataRepository() {
//
//    }

    @Override
    public Observable<String> login(String username, String password) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("output : " + username + ", " + password);
                subscriber.onCompleted();
            }
        });
    }

    @Override
    public Observable<List<User>> users() {
        return null;
    }

    @Override
    public Observable<User> user(int userId) {
        return null;
    }
}
