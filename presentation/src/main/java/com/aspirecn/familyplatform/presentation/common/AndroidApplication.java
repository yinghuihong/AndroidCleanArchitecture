package com.aspirecn.familyplatform.presentation.common;

import android.app.Application;

import com.aspirecn.familyplatform.presentation.common.dagger2.components.ApplicationComponent;
import com.aspirecn.familyplatform.presentation.common.dagger2.components.DaggerApplicationComponent;
import com.aspirecn.familyplatform.presentation.common.dagger2.modules.ApplicationModule;

/**
 * Created by yinghuihong on 15/11/18.
 */
public class AndroidApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
