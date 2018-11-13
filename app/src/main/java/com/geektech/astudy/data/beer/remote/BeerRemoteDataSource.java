package com.geektech.astudy.data.beer.remote;

import com.geektech.astudy.data.beer.BeerDataSource;
import com.geektech.astudy.data.beer.model.Beer;
import com.geektech.core.retrofit.RetrofitBaseDataSource;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// Created by askar on 11/13/18.
public class BeerRemoteDataSource extends RetrofitBaseDataSource
        implements BeerDataSource {

    //region Static

    private static BeerRemoteDataSource INSTANCE;

    public static BeerDataSource getInstance(

    ){
        if (INSTANCE == null) {
            INSTANCE = new BeerRemoteDataSource();
        }
        return INSTANCE;
    }

    //endregion

    private BeerNetworkClient mClient = getRetrofit(BeerRemoteConfig.BASE_URL)
            .create(BeerNetworkClient.class);

    @Override
    public void getBeers(BeersCallback callback) {
        Call<ArrayList<Beer>> beersCall = mClient.getBeers(1, 50);

        beersCall.enqueue(new Callback<ArrayList<Beer>>() {
            @Override
            public void onResponse(Call<ArrayList<Beer>> call, Response<ArrayList<Beer>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onSuccess(response.body());
                    }
                } else {
                    callback.onFail(response.message());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Beer>> call, Throwable t) {
                callback.onFail(t.getMessage());
            }
        });
    }

    @Override
    public void getRandom(BeerCallback callback) {
        Call<Beer> randomBeer = mClient.getRandomBeer();

        randomBeer.enqueue(new Callback<Beer>() {
            @Override
            public void onResponse(Call<Beer> call, Response<Beer> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onSuccess(response.body());
                    }
                } else {
                    callback.onFail(response.message());
                }
            }

            @Override
            public void onFailure(Call<Beer> call, Throwable t) {
                callback.onFail(t.getMessage());
            }
        });
    }
}
