package com.geektech.astudy.data.beer;

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

    @Override
    public void getBeers(BeersCallback callback) {
        mRemoteSource.getBeers(callback);
    }

    @Override
    public void getRandom(BeerCallback callback) {
        mRemoteSource.getRandom(callback);
    }
}
