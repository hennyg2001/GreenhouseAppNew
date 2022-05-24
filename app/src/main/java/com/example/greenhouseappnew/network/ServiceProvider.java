package com.example.greenhouseappnew.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceProvider {
    private static GreenHouseApi greenHouseApi;

    public static GreenHouseApi getGreenHouseApi()
    {
        if(greenHouseApi == null)
        {
            greenHouseApi = new Retrofit.Builder()
                    .baseUrl("http://localhost:5001/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(GreenHouseApi.class);
        }
        return greenHouseApi;
    }
}
