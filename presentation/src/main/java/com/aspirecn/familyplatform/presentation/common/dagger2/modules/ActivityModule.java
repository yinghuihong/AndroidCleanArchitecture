package com.aspirecn.familyplatform.presentation.common.dagger2.modules;

import android.app.Activity;

import com.aspirecn.familyplatform.presentation.common.dagger2.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yinghuihong on 15/11/18.
 */
@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    Activity provideActivity() {
        return this.activity;
    }

}
