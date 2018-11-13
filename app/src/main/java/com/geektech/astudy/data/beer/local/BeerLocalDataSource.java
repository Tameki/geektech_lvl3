package com.geektech.astudy.data.beer.local;

import com.geektech.astudy.data.beer.BeerDataSource;

// Created by askar on 11/13/18.
public class BeerLocalDataSource implements BeerDataSource {

    //region Static

    private static BeerLocalDataSource INSTANCE;

    public static BeerDataSource getInstance(

    ){
        if (INSTANCE == null) {
            INSTANCE = new BeerLocalDataSource();
        }
        return INSTANCE;
    }

    //endregion


    @Override
    public void getBeers(BeersCallback callback) {

    }

    @Override
    public void getRandom(BeerCallback callback) {
    }
}
