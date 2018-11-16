package com.geektech.astudy.data.beer.remote;

import com.geektech.astudy.data.beer.model.Beer;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

// Created by askar on 11/13/18.
public interface BeerNetworkClient {
    @GET(BeerRemoteConfig.BEERS_URL)
    Call<ArrayList<Beer>> getBeers(@Query("page") int page, @Query("per_page") int perPage);

    @GET(BeerRemoteConfig.RANDOM_BEER_URL)
    Call<Beer> getRandomBeer();
}
