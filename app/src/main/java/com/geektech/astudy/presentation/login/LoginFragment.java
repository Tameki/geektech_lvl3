package com.geektech.astudy.presentation.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.geektech.analytics.FabricAnalytics;
import com.geektech.astudy.R;
import com.geektech.astudy.data.RepositoryProvider;
import com.geektech.astudy.presentation.main.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by askar on 11/19/18
 * with Android Studio
 */
public class LoginFragment extends Fragment
        implements LoginContract.View {

    @Inject
    LoginPresenter mPresenter = null;

    @BindView(R.id.fragment_login_name)
    EditText mNameInput;

    @BindView(R.id.fragment_login_password)
    EditText mPasswordInput;

    @OnClick({R.id.fragment_login_btn})
    public void onClick(View view){
        if (mPresenter != null) {
            mPresenter.onLoginClick(
                    mNameInput.getText().toString(),
                    mPasswordInput.getText().toString()
            );
        }
    }

    private Unbinder mUnbinder;

    public static LoginFragment getInstance(){
        return new LoginFragment();
    }

    //region Lifecycle

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_login,
                container,
                false
        );

        mUnbinder = ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @SuppressLint("CheckResult")
    @Override
    public void onResume() {
        super.onResume();
//        Single.just("Hello world").subscribe(s -> {
//            Log.d("ololo", s);
//        });

//        Observable.create(emitter -> {
//            while (!emitter.isDisposed()) {
//                long time = System.currentTimeMillis();
//                emitter.onNext(time);
//
//                if (time % 2 != 0) {
//                    emitter.onError(new IllegalStateException("Odd milli"));
//                }
//            }
//        }).subscribe(s -> {
//            Log.d("ololo", s.toString());
//        }, error -> {
//            Log.d("ololo", error.toString());
//        });


        RepositoryProvider.getBeerRepository()
                .getBeers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    Log.d("ololo", "Beers result is " + result.size());
                }, error -> {
                    Log.d("ololo", error.getMessage());
                });
    }

    //endregion

    @Override
    public void finishView() {
        if (getActivity() != null){
            getActivity().finish();
        }
    }

    @Override
    public void onLoginSuccess() {
        if (getActivity() != null) {
            FabricAnalytics.sendEvent("User login", "Success");
            getActivity().startActivity(new Intent(getActivity(), MainActivity.class));
        }
    }

    @Override
    public void onLoginFailure(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    //endregion

}