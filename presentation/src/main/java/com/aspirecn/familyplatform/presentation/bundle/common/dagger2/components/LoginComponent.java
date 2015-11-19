package com.aspirecn.familyplatform.presentation.bundle.common.dagger2.components;

import com.aspirecn.familyplatform.presentation.bundle.common.dagger2.modules.LoginModule;
import com.aspirecn.familyplatform.presentation.bundle.common.view.activity.LoginActivity;
import com.aspirecn.familyplatform.presentation.common.dagger2.ActivityScope;
import com.aspirecn.familyplatform.presentation.common.dagger2.components.ActivityComponent;
import com.aspirecn.familyplatform.presentation.common.dagger2.components.ApplicationComponent;
import com.aspirecn.familyplatform.presentation.common.dagger2.modules.ActivityModule;

import dagger.Component;

/**
 * Created by yinghuihong on 15/11/19.
 */
@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, LoginModule.class})
public interface LoginComponent extends ActivityComponent {
    void inject(LoginActivity activity);
}
