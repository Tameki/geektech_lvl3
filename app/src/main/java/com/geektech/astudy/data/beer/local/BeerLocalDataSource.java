package com.geektech.astudy.data.beer.local;

import com.geektech.astudy.data.beer.BeerDataSource;
import com.geektech.astudy.data.beer.model.Beer;

import java.util.ArrayList;

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
        //TODO: Return saved beers
    }

    @Override
    public void getRandom(BeerCallback callback) {

    }

    @Override
    public void setBeers(ArrayList<Beer> data) {
        //TODO: Save to DB
    }

    @Override
    public void getBeer(int id, BeerCallback callback) {
        //TODO: Return beer by id
    }
}
