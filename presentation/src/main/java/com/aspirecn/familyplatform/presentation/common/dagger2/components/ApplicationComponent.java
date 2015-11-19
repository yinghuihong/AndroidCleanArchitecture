package com.aspirecn.familyplatform.presentation.common.dagger2.components;

import android.content.Context;

import com.aspirecn.familyplatform.domain.bundle.common.repository.UserRepository;
import com.aspirecn.familyplatform.domain.common.executor.PostExecutionThread;
import com.aspirecn.familyplatform.domain.common.executor.ThreadExecutor;
import com.aspirecn.familyplatform.presentation.common.dagger2.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by yinghuihong on 15/11/18.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Context getContext();

    UserRepository getUserRepository();

    ThreadExecutor getThreadExecutor();

    PostExecutionThread getPostExecutionThread();

}
