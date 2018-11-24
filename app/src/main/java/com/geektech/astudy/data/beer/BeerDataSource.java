package com.geektech.astudy.data.beer;

import com.geektech.astudy.data.beer.model.Beer;

import java.util.ArrayList;

import io.reactivex.Single;

// Created by askar on 11/13/18.
public interface BeerDataSource {
    Single<ArrayList<Beer>> getBeers();

    Single<Beer> getRandom();

    void setBeers(ArrayList<Beer> data);

    Beer getBeer(int id);
}
