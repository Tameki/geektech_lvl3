package com.geektech.core.mvp;

// Created by askar on 11/2/18.
public interface BaseMVPContract {
    interface View<T extends Presenter> {
        void finishView();

        void attachPresenter(T presenter);
    }

    interface Presenter<T extends View> {
        void attachView(T view);

        void detachView();
    }
}
