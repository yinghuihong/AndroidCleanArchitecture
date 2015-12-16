package com.aspirecn.familyplatform.presentation.common.dagger2.components;

import android.content.Context;

import com.aspirecn.familyplatform.data.common.rxbus.RxBus;
import com.aspirecn.familyplatform.domain.bundle.common.repository.UserRepository;
import com.aspirecn.familyplatform.domain.common.executor.PostExecutionThread;
import com.aspirecn.familyplatform.domain.common.executor.ThreadExecutor;
import com.aspirecn.familyplatform.presentation.common.dagger2.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 定义暴露的对象列表，此工程暴露给依赖者{@link ActivityComponent}
 * 可定义的对象需正确配置（至少一种）：
 * 1、构造函数带@Inject
 * 2、在Module中定义@Provides method并返回该对象；适用于返回对象为接口类，且实现类不需要配置注解
 * <p>
 * 注入对象在构造函数还包含需要注入的对象，同样也需要以上配置
 * <p>
 * Created by yinghuihong on 15/11/18.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    // exposed

    Context getContext();

    UserRepository getUserRepository();

    ThreadExecutor getThreadExecutor();

    PostExecutionThread getPostExecutionThread();

    RxBus getRxBus();

}
