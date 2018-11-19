package com.geektech.astudy.presentation.login;

/**
 * Created by askar on 11/19/18
 * with Android Studio
 */
public interface LoginContract {
    interface View {
        void finishView();

        void onLoginSuccess();

        void onLoginFailure(String message);
    }

    interface Presenter {
        void onLoginClick(String name, String password);
    }
}
