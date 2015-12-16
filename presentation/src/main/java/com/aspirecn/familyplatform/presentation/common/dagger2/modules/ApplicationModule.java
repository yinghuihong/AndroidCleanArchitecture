package com.aspirecn.familyplatform.presentation.common.dagger2.modules;

import android.content.Context;

import com.aspirecn.familyplatform.data.bundle.common.repository.UserDataRepository;
import com.aspirecn.familyplatform.data.common.executor.JobExecutor;
import com.aspirecn.familyplatform.domain.bundle.common.repository.UserRepository;
import com.aspirecn.familyplatform.domain.common.executor.PostExecutionThread;
import com.aspirecn.familyplatform.domain.common.executor.ThreadExecutor;
import com.aspirecn.familyplatform.presentation.common.AndroidApplication;
import com.aspirecn.familyplatform.presentation.common.executor.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yinghuihong on 15/11/18.
 */
@Module
public class ApplicationModule {

    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    UserRepository provideUserRepository() {
        return new UserDataRepository();
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor() {
        return new JobExecutor();
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread() {
        return new UIThread();
    }

//    @Provides
//    @Singleton
//    RxBus provideRxBus() {
//        return new RxBus();
//    }
}
