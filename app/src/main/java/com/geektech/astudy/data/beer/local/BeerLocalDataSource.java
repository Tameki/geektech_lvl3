package com.geektech.astudy.data.beer.local;

import com.geektech.astudy.data.beer.BeerDataSource;
import com.geektech.astudy.data.beer.model.Beer;

import java.util.ArrayList;

import io.reactivex.Single;

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
    public Single<ArrayList<Beer>> getBeers() {
        return null;
    }

    @Override
    public Single<Beer> getRandom() {
        return null;
    }

    @Override
    public Beer getBeer(int id) {
        return null;
    }

    @Override
    public void setBeers(ArrayList<Beer> data) {
        //TODO: Save to DB
    }
}
