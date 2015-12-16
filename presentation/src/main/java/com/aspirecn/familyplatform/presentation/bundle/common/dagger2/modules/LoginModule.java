package com.aspirecn.familyplatform.presentation.bundle.common.dagger2.modules;

import com.aspirecn.familyplatform.domain.bundle.common.interactor.LoginArgs;
import com.aspirecn.familyplatform.domain.bundle.common.interactor.LoginUseCase;
import com.aspirecn.familyplatform.domain.bundle.common.repository.UserRepository;
import com.aspirecn.familyplatform.domain.common.UseCase;
import com.aspirecn.familyplatform.domain.common.executor.PostExecutionThread;
import com.aspirecn.familyplatform.domain.common.executor.ThreadExecutor;
import com.aspirecn.familyplatform.presentation.common.dagger2.ActivityScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yinghuihong on 15/11/19.
 */
@Module
public class LoginModule {

    /**
     * 采用对象封装参数列表，用于延后具体参数的赋值
     */
    private LoginArgs args;

    public LoginModule(LoginArgs args) {
        this.args = args;
    }

    @Provides
    @ActivityScope
    @Named("login")
    UseCase provideLoginUseCase(UserRepository userRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        return new LoginUseCase(args, userRepository, threadExecutor, postExecutionThread);
    }
}
