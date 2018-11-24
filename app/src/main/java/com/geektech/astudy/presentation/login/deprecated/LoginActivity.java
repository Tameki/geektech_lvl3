package com.geektech.astudy.presentation.login.deprecated;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.geektech.astudy.data.RepositoryProvider;
import com.geektech.astudy.data.beer.BeerDataSource;
import com.geektech.astudy.data.beer.model.Beer;
import com.geektech.astudy.data.messages.MessagesDataSource;
import com.geektech.astudy.data.messages.model.RMessage;
import com.geektech.astudy.domain.UseCaseProvider;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Created by askar on 11/2/18.
@Deprecated
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
