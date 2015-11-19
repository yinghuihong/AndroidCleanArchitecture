package com.aspirecn.familyplatform.domain.bundle.common.interactor;

import com.aspirecn.familyplatform.domain.bundle.common.repository.UserRepository;
import com.aspirecn.familyplatform.domain.common.UseCase;
import com.aspirecn.familyplatform.domain.common.executor.PostExecutionThread;
import com.aspirecn.familyplatform.domain.common.executor.ThreadExecutor;

import rx.Observable;

/**
 * Created by yinghuihong on 15/11/19.
 */
public class LoginUseCase extends UseCase {

    private LoginArgs args;

    private UserRepository userRepository;

    public LoginUseCase(LoginArgs args, UserRepository userRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.args = args;
        this.userRepository = userRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return userRepository.login(args.username, args.password);
    }
}
