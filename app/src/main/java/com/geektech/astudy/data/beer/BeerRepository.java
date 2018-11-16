package com.geektech.astudy.data.beer;

import android.annotation.SuppressLint;

import com.geektech.astudy.data.beer.model.Beer;

import java.util.ArrayList;
import java.util.HashMap;

// Created by askar on 11/13/18.
public class BeerRepository implements BeerDataSource {

    //region Static

    private static BeerRepository INSTANCE;

    public static BeerDataSource getInstance(
            BeerDataSource localSource,
            BeerDataSource remoteSource
    ){
        if (INSTANCE == null) {
            INSTANCE = new BeerRepository(localSource, remoteSource);
        }
        return INSTANCE;
    }

    //endregion

    private BeerRepository(
            BeerDataSource localSource,
            BeerDataSource remoteSource
    ){
        mLocalSource = localSource;
        mRemoteSource = remoteSource;
    }

    private BeerDataSource mLocalSource;
    private BeerDataSource mRemoteSource;

    @SuppressLint("UseSparseArrays")
    private HashMap<Integer, Beer> cache = new HashMap<>();

    @Override
    public void getBeers(BeersCallback callback) {
        mLocalSource.getBeers(callback);

        mRemoteSource.getBeers(new BeersCallback() {
            @Override
            public void onSuccess(ArrayList<Beer> result) {
                //Write to local DB
                mLocalSource.setBeers(result);
                callback.onSuccess(result);
            }

            @Override
            public void onFail(String message) {
                callback.onFail(message);
            }
        });
    }

    @Override
    public void getRandom(BeerCallback callback) {
        mRemoteSource.getRandom(callback);
    }

    @Override
    public void setBeers(ArrayList<Beer> data) {
        mLocalSource.setBeers(data);
    }

    @Override
    public void getBeer(int id, BeerCallback callback) {
        if (cache.containsKey(id)) {
            callback.onSuccess(cache.get(id));
        } else {
            mLocalSource.getBeer(id, new BeerCallback() {
                @Override
                public void onSuccess(Beer result) {
                    cache.put(result.getId(), result);
                    callback.onSuccess(result);
                }

                @Override
                public void onFail(String message) {
                    callback.onFail(message);
                }
            });
        }
    }
}
