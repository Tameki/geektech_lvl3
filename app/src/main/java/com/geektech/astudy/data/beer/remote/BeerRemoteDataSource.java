package com.geektech.astudy.data.beer.remote;

import com.geektech.astudy.data.beer.BeerDataSource;
import com.geektech.astudy.data.beer.model.Beer;
import com.geektech.core.retrofit.RetrofitBaseDataSource;

import java.util.ArrayList;

import io.reactivex.Single;

// Created by askar on 11/13/18.
public class BeerRemoteDataSource extends RetrofitBaseDataSource
        implements BeerDataSource {

    //region Static

    private static BeerRemoteDataSource INSTANCE;

    public static BeerDataSource getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new BeerRemoteDataSource();
        }
        return INSTANCE;
    }

    //endregion

    private BeerNetworkClient mClient = getRetrofit(BeerRemoteConfig.BASE_URL)
            .create(BeerNetworkClient.class);

    @Override
    public Single<ArrayList<Beer>> getBeers() {
        return mClient.getBeers(1, 50);
    }

    @Override
    public Single<Beer> getRandom() {
        return mClient.getRandomBeer();
    }

    @Override
    public Beer getBeer(int id) {
        return null;
    }

    @Override
    public void setBeers(ArrayList<Beer> data) {

    }
}
