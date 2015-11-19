package com.aspirecn.familyplatform.presentation.common.dagger2.components;

import android.app.Activity;

import com.aspirecn.familyplatform.presentation.common.dagger2.ActivityScope;
import com.aspirecn.familyplatform.presentation.common.dagger2.modules.ActivityModule;

import dagger.Component;

/**
 * Created by yinghuihong on 15/11/18.
 */
@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity activity();
}
