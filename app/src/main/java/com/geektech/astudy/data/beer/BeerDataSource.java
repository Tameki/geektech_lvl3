package com.geektech.astudy.data.beer;

import com.geektech.astudy.data.beer.model.Beer;
import com.geektech.core.callback.BaseCallback;

import java.util.ArrayList;

// Created by askar on 11/13/18.
public interface BeerDataSource {
    void getBeers(BeersCallback callback);

    void getRandom(BeerCallback callback);

    void setBeers(ArrayList<Beer> data);

    void getBeer(int id, BeerCallback callback);

    interface BeerCallback extends BaseCallback<Beer> {}

    interface BeersCallback extends BaseCallback<ArrayList<Beer>> {}
}
