package com.geektech.astudy.data.beer;

import android.annotation.SuppressLint;

import com.geektech.astudy.data.beer.model.Beer;

import java.util.ArrayList;
import java.util.HashMap;

import io.reactivex.Single;

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
    public void setBeers(ArrayList<Beer> data) {
        mLocalSource.setBeers(data);
    }

    @Override
    public Single<ArrayList<Beer>> getBeers() {
        return mRemoteSource.getBeers()
                .map( it -> {
                    for (Beer beer : it) {
                        cache.put(beer.getId(), beer);
                    }
                    return it;
                });
    }

    @Override
    public Single<Beer> getRandom() {
        return mRemoteSource.getRandom();
    }

    @Override
    public Beer getBeer(int id) {
        return null;
    }
}
