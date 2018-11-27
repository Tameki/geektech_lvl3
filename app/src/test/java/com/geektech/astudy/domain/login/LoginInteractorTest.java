package com.geektech.astudy.domain.login;

import com.geektech.astudy.ConstValues;
import com.geektech.astudy.data.user.UserDataSource;
import com.geektech.astudy.model.LoginEntity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static com.geektech.astudy.ConstValues.failLoginEntity;
import static com.geektech.astudy.ConstValues.successLoginEntity;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by askar on 11/27/18
 * with Android Studio
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginInteractorTest {

    @Mock
    private UserDataSource mFilledUserSource;
    @Mock
    private UserDataSource mEmptyUserSource;

    @Mock
    private LoginUseCases.UCCheckLoginCallback mCallback;

    private LoginInteractor mInteractor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        when(mFilledUserSource.getLoginData()).thenReturn(successLoginEntity);
        when(mEmptyUserSource.getLoginData()).thenReturn(null);

        mInteractor = new LoginInteractor(mFilledUserSource);
    }

    @Test
    public void loginSuccess(){
        mInteractor.checkLogin(successLoginEntity, mCallback);

        verify(mCallback).onSuccess(true);
    }

    @Test
    public void loginFail(){
        mInteractor.checkLogin(failLoginEntity, mCallback);

        verify(mCallback).onSuccess(false);
    }

    @Test
    public void userDataEmpty(){
        LoginUseCases interactor = new LoginInteractor(mEmptyUserSource);

        interactor.checkLogin(successLoginEntity, mCallback);

        verify(mCallback).onFail("User data is empty!");
    }
}