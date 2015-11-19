package com.aspirecn.familyplatform.domain.bundle.common.interactor;

import com.aspirecn.familyplatform.domain.bundle.common.repository.UserRepository;
import com.aspirecn.familyplatform.domain.common.UseCase;
import com.aspirecn.familyplatform.domain.common.executor.PostExecutionThread;
import com.aspirecn.familyplatform.domain.common.executor.ThreadExecutor;

import rx.Observable;


/**
 * Created by yinghuihong on 15/11/19.
 */
public class GetUserDetailUseCase extends UseCase {

    private UserRepository userRepository;

    protected GetUserDetailUseCase(UserRepository userRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return userRepository.users();
    }
}
