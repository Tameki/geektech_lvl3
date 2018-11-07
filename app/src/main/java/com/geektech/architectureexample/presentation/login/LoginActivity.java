package com.geektech.architectureexample.presentation.login;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.geektech.architectureexample.data.RepositoryProvider;
import com.geektech.architectureexample.data.messages.MessagesDataSource;
import com.geektech.architectureexample.data.messages.model.RMessage;
import com.geektech.architectureexample.domain.UseCaseProvider;

import java.util.Date;
import java.util.List;

// Created by askar on 11/2/18.
public class LoginActivity extends AppCompatActivity {

    private LoginContract.Presenter mPresenter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LoginFragment fragment = LoginFragment.getInstance();

        mPresenter = new LoginPresenter(
                UseCaseProvider.getLoginUseCase()
        );

        mPresenter.attachView(fragment);

        getSupportFragmentManager()
                .beginTransaction()
                .add(android.R.id.content, fragment)
                .commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        RepositoryProvider.getMessagesRepository()
                .addMessage(new RMessage(
                0,
                "text",
                "Its message content",
                new Date().getTime()));

        RepositoryProvider.getMessagesRepository().getMessages(new MessagesDataSource.MessagesCallback() {
            @Override
            public void onSuccess(List<RMessage> result) {
                for (RMessage message : result) {
                    Log.d("ololo", message.toString());
                }
            }

            @Override
            public void onFail(String message) {

            }
        });
    }
}
