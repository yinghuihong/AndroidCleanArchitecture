package com.aspirecn.familyplatform.presentation.bundle.common.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.aspirecn.familyplatform.R;
import com.aspirecn.familyplatform.domain.bundle.common.interactor.LoginArgs;
import com.aspirecn.familyplatform.presentation.bundle.common.dagger2.components.DaggerLoginComponent;
import com.aspirecn.familyplatform.presentation.bundle.common.dagger2.components.LoginComponent;
import com.aspirecn.familyplatform.presentation.bundle.common.dagger2.modules.LoginModule;
import com.aspirecn.familyplatform.presentation.bundle.common.presenter.LoginPresenter;
import com.aspirecn.familyplatform.presentation.common.AndroidApplication;
import com.aspirecn.familyplatform.presentation.common.dagger2.modules.ActivityModule;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by yinghuihong on 15/11/18.
 */
public class LoginActivity extends Activity {

    @Bind(R.id.et_username)
    EditText etUsername;

    @Bind(R.id.et_password)
    EditText etPassword;

    @Bind(R.id.btn_login)
    Button btnLogin;

    @Inject
    LoginPresenter loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_activity_login);
        ButterKnife.bind(this);

        final LoginArgs args = new LoginArgs();
        LoginComponent component = DaggerLoginComponent.builder()
                .applicationComponent(((AndroidApplication) getApplicationContext()).getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .loginModule(new LoginModule(args))
                .build();
        component.inject(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                args.username = etUsername.getText().toString();
                args.password = etPassword.getText().toString();
                loginPresenter.login();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        loginPresenter.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loginPresenter.resume();
    }

    @Override
    protected void onPause() {
        loginPresenter.pause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        loginPresenter.destroy();
        super.onDestroy();
    }
}
