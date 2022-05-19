package com.example.greenhouseappnew.network;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.greenhouseappnew.model.Greenhouse;
import com.example.greenhouseappnew.model.GreenhouseResponse;
import com.example.greenhouseappnew.model.LogClass;
import com.example.greenhouseappnew.model.LogListResponse;
import com.example.greenhouseappnew.model.LogResponse;
import com.example.greenhouseappnew.model.Plant;
import com.example.greenhouseappnew.model.PlantListResponse;
import com.example.greenhouseappnew.model.PlantResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class GreenhouseRepository {
    private static GreenhouseRepository instance;
    private final MutableLiveData<Greenhouse> greenHouse;
    private final MutableLiveData<Greenhouse> addGreenHouse;
    private final MutableLiveData<List<Greenhouse>> greenHouseList;
    private final MutableLiveData<List<Plant>> plantList;
    private final MutableLiveData<List<LogClass>> logList;
    private final MutableLiveData<Plant> addPlant;
    private final MutableLiveData<LogClass> log;

    private GreenhouseRepository()
    {
        greenHouse = new MutableLiveData<Greenhouse>();
        plantList = new MutableLiveData<List<Plant>>();
        logList = new MutableLiveData<List<LogClass>>();
        log = new MutableLiveData<LogClass>();
        greenHouseList = new MutableLiveData<List<Greenhouse>>();
        addGreenHouse = new MutableLiveData<Greenhouse>();
        addPlant = new MutableLiveData<Plant>();
    }

    public static synchronized GreenhouseRepository getInstance()
    {
        if(instance == null)
        {
            instance = new GreenhouseRepository();
        }
        return instance;
    }

    public void searchForGreenhouseById(int id) {
        GreenHouseApi greenhouseApi = ServiceProvider.getGreenHouseApi();
        Call<GreenhouseResponse> call = greenhouseApi.getGreenHouseById(id);
        call.enqueue(new Callback<GreenhouseResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<GreenhouseResponse> call, Response<GreenhouseResponse> response) {
                if (response.isSuccessful()) {
                    greenHouse.setValue(response.body().getGreenhouse());
                    Log.i("Header", response.headers().toString());
                    Log.i("Complete response", String.valueOf(response.code()));
                    Log.i("Success", response.body().toString());
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<GreenhouseResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :( " + t.getMessage());

            }
        });
    }

    public void searchForGreenhouseByEmail(String email) {
        GreenHouseApi greenhouseApi = ServiceProvider.getGreenHouseApi();
        Call<GreenhouseResponse> call = greenhouseApi.getGreenHouseByEmail(email);
        call.enqueue(new Callback<GreenhouseResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<GreenhouseResponse> call, Response<GreenhouseResponse> response) {
                if (response.isSuccessful()) {
                    greenHouse.setValue(response.body().getGreenhouse());
                    Log.i("Header", response.headers().toString());
                    Log.i("Complete response", String.valueOf(response.code()));
                    Log.i("Success", response.body().toString());
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<GreenhouseResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :( " + t.getMessage());
            }
        });
    }

    public void searchForPlantsByGreenhouseId(int id) {
        GreenHouseApi greenhouseApi = ServiceProvider.getGreenHouseApi();
        Call<PlantListResponse> call = greenhouseApi.getPlantsFromGreenHouse(id);
        call.enqueue(new Callback<PlantListResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<PlantListResponse> call, Response<PlantListResponse> response) {
                if (response.isSuccessful()) {
                    plantList.setValue(response.body().getResponse());
                    Log.i("Header", response.headers().toString());
                    Log.i("Complete response", String.valueOf(response.code()));
                    Log.i("Success", response.body().toString());
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<PlantListResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :( " + t.getMessage());
            }
        });
    }

    public void searchForLogsByGreenhouseId(int id) {
        GreenHouseApi greenhouseApi = ServiceProvider.getGreenHouseApi();
        Call<LogListResponse> call = greenhouseApi.getLogsByGreenhouseId(id);
        call.enqueue(new Callback<LogListResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<LogListResponse> call, Response<LogListResponse> response) {
                if (response.isSuccessful()) {
                    logList.setValue(response.body().getResponse());
                    Log.i("Header", response.headers().toString());
                    Log.i("Complete response", String.valueOf(response.code()));
                    Log.i("Success", response.body().toString());
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<LogListResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :( " + t.getMessage());
            }
        });
    }

    public void addGreenhouse(Greenhouse params) {
        GreenHouseApi greenhouseApi = ServiceProvider.getGreenHouseApi();
        Call<GreenhouseResponse> call = greenhouseApi.addGreenHouse(params);
        call.enqueue(new Callback<GreenhouseResponse>() {
            @Override
            public void onResponse(Call<GreenhouseResponse> call, Response<GreenhouseResponse> response) {
                if(response.isSuccessful())
                {
                    addGreenHouse.postValue(response.body().getGreenhouse());
                }
                else
                {
                    addGreenHouse.postValue(null);
                }
            }
            @Override
            public void onFailure(Call<GreenhouseResponse> call, Throwable t) {
                Log.i("Error", t.getMessage());
            }
        });
    }

    public void addPlant(Plant plant) {
        GreenHouseApi greenhouseApi = ServiceProvider.getGreenHouseApi();
        Call<PlantResponse> call = greenhouseApi.addPlant(plant);
        call.enqueue(new Callback<PlantResponse>() {
            @Override
            public void onResponse(Call<PlantResponse> call, Response<PlantResponse> response) {
                if(response.isSuccessful())
                {
                    addPlant.postValue(response.body().getPlant());
                }
                else
                {
                    addPlant.postValue(null);
                }
            }
            @Override
            public void onFailure(Call<PlantResponse> call, Throwable t) {
                Log.i("Error", t.getMessage());
            }
        });
    }

    public void updateGreenhouse(Greenhouse params)
    {
        GreenHouseApi greenhouseApi = ServiceProvider.getGreenHouseApi();
        Call<GreenhouseResponse> call = greenhouseApi.updateGreenhouse(params);

        call.enqueue(new Callback<GreenhouseResponse>() {
            @Override
            public void onResponse(Call<GreenhouseResponse> call, Response<GreenhouseResponse> response) {
                greenHouse.setValue(params);
            }

            @Override
            public void onFailure(Call<GreenhouseResponse> call, Throwable t) {
                Log.i("Error", t.getMessage());
            }
        });
    }
}
