package com.geektech.astudy.presentation.login;

import com.geektech.astudy.ConstValues;
import com.geektech.astudy.domain.login.LoginUseCases;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

/**
 * Created by askar on 11/27/18
 * with Android Studio
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock
    private LoginContract.View mView;
    @Mock
    private LoginUseCases mSuccessLoginUseCases;
    @Mock
    private LoginUseCases mFailLoginUseCases;

    private LoginPresenter mPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        doAnswer( invocation -> {
            ((LoginUseCases.UCCheckLoginCallback) invocation.getArguments()[1]).onSuccess(true);
            return null;
        }).when(mSuccessLoginUseCases).checkLogin(any(), any());

        doAnswer( invocation -> {
            ((LoginUseCases.UCCheckLoginCallback) invocation.getArguments()[1]).onSuccess(false);
            return null;
        }).when(mFailLoginUseCases).checkLogin(any(), any());
    }

    @Test
    public void loginSuccess() {
        mPresenter = new LoginPresenter(mView, mSuccessLoginUseCases);
        mPresenter.onLoginClick(ConstValues.successLoginEntity.name, ConstValues.successLoginEntity.password);

        verify(mView).onLoginSuccess();
    }

    @Test
    public void loginFail() {
        mPresenter = new LoginPresenter(mView, mFailLoginUseCases);
        mPresenter.onLoginClick("invalid", "invalid");

        verify(mView).onLoginFailure("Name or password is incorrect!");
    }
}