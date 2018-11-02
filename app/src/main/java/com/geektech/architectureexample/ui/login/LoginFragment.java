package com.geektech.architectureexample.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.geektech.architectureexample.MainActivity;
import com.geektech.architectureexample.R;

// Created by askar on 11/2/18.
public class LoginFragment extends Fragment
        implements LoginContract.View {

    private LoginContract.Presenter mPresenter = null;

    private EditText mNameInput;
    private EditText mPasswordInput;
    private Button mLoginBtn;

    public static LoginFragment getInstance(){
        return new LoginFragment();
    }

    //region Lifecycle

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        init(rootView);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    //endregion

    private void init(View rootView){
        mLoginBtn = rootView.findViewById(R.id.fragment_login_btn);
        mNameInput = rootView.findViewById(R.id.fragment_login_name);
        mPasswordInput = rootView.findViewById(R.id.fragment_login_password);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPresenter != null) {
                    mPresenter.onLoginClick(
                            mNameInput.getText().toString(),
                            mPasswordInput.getText().toString()
                    );
                }
            }
        });
    }

    //region Contract


    @Override
    public void finishView() {
        if (getActivity() != null){
            getActivity().finish();
        }
    }

    @Override
    public void attachPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onLoginSuccess() {
        if (getActivity() != null) {
            getActivity().startActivity(new Intent(getActivity(), MainActivity.class));
        }
    }

    @Override
    public void onLoginFailure(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    //endregion

}
