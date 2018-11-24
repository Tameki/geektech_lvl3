package com.geektech.astudy.data.beer.remote;

import com.geektech.astudy.data.beer.model.Beer;

import java.util.ArrayList;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

// Created by askar on 11/13/18.
public interface BeerNetworkClient {
    @GET(BeerRemoteConfig.BEERS_URL)
    Single<ArrayList<Beer>> getBeers(@Query("page") int page, @Query("per_page") int perPage);

    @GET(BeerRemoteConfig.RANDOM_BEER_URL)
    Single<Beer> getRandomBeer();
}
