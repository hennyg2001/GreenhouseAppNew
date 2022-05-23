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
import com.example.greenhouseappnew.model.Routine;
import com.example.greenhouseappnew.model.RoutineListResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class GreenhouseRepository {

    private static GreenhouseRepository instance;
    private final MutableLiveData<Greenhouse> greenHouse;
    private final MutableLiveData<Plant> plant;
    private final MutableLiveData<Greenhouse> addGreenHouse;
    private final MutableLiveData<List<Greenhouse>> greenHouseList;
    private final MutableLiveData<List<Plant>> plantList;
    private final MutableLiveData<List<LogClass>> logList;
    private final MutableLiveData<Plant> addPlant;
    private final MutableLiveData<LogClass> log;
    private final MutableLiveData<Plant> updatedPlant;
    private final MutableLiveData<Greenhouse> updatedGreenhouse;
    private final MutableLiveData<List<Routine>> routineList;

    public GreenhouseRepository()
    {
        greenHouse = new MutableLiveData<Greenhouse>();
        plantList = new MutableLiveData<List<Plant>>();
        logList = new MutableLiveData<List<LogClass>>();
        log = new MutableLiveData<LogClass>();
        greenHouseList = new MutableLiveData<List<Greenhouse>>();
        addGreenHouse = new MutableLiveData<Greenhouse>();
        addPlant = new MutableLiveData<Plant>();
        updatedPlant = new MutableLiveData<Plant>();
        updatedGreenhouse = new MutableLiveData<Greenhouse>();
        plant = new MutableLiveData<Plant>();
        routineList = new MutableLiveData<List<Routine>>();
    }

    public static synchronized GreenhouseRepository getInstance()
    {
        if(instance == null)
        {
            instance = new GreenhouseRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Routine>> getRoutineList() {
        return routineList;
    }

    public MutableLiveData<Plant> getUpdatedPlant() {
        return updatedPlant;
    }

    public MutableLiveData<Greenhouse> getGreenHouse() {
        return greenHouse;
    }

    public MutableLiveData<Greenhouse> getAddGreenHouse() {
        return addGreenHouse;
    }

    public MutableLiveData<List<Greenhouse>> getGreenHouseList() {
        return greenHouseList;
    }

    public MutableLiveData<List<Plant>> getPlantList() {
        return plantList;
    }

    public MutableLiveData<List<LogClass>> getLogList() {
        return logList;
    }

    public MutableLiveData<Plant> getAddPlant() {
        return addPlant;
    }

    public MutableLiveData<LogClass> getLog() {
        return log;
    }

    public MutableLiveData<Greenhouse> getUpdatedGreenhouse() {
        return updatedGreenhouse;
    }

    public MutableLiveData<Plant> getPlant() {
        return plant;
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

    public void searchForRoutinesById(int id) {
        GreenHouseApi greenhouseApi = ServiceProvider.getGreenHouseApi();
        Call<RoutineListResponse> call = greenhouseApi.getRoutinesByPlantId(id);
        call.enqueue(new Callback<RoutineListResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<RoutineListResponse> call, Response<RoutineListResponse> response) {
                if (response.isSuccessful()) {
                    routineList.setValue(response.body().getResponse());
                    Log.i("Header", response.headers().toString());
                    Log.i("Complete response", String.valueOf(response.code()));
                    Log.i("Success", response.body().toString());
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<RoutineListResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :( " + t.getMessage());

            }
        });
    }

    public void searchForPlantById(int id) {
        GreenHouseApi greenhouseApi = ServiceProvider.getGreenHouseApi();
        Call<PlantResponse> call = greenhouseApi.getPlantById(id);
        call.enqueue(new Callback<PlantResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<PlantResponse> call, Response<PlantResponse> response) {
                if (response.isSuccessful()) {
                    plant.setValue(response.body().getPlant());
                    Log.i("Header", response.headers().toString());
                    Log.i("Complete response", String.valueOf(response.code()));
                    Log.i("Success", response.body().toString());
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<PlantResponse> call, Throwable t) {
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
                updatedGreenhouse.setValue(params);
            }

            @Override
            public void onFailure(Call<GreenhouseResponse> call, Throwable t) {
                Log.i("Error", t.getMessage());
            }
        });
    }

    public void updatePlant(Plant params)
    {
        GreenHouseApi greenhouseApi = ServiceProvider.getGreenHouseApi();
        Call<PlantResponse> call = greenhouseApi.updatePlant(params);

        call.enqueue(new Callback<PlantResponse>() {
            @Override
            public void onResponse(Call<PlantResponse> call, Response<PlantResponse> response) {
                updatedPlant.setValue(params);
            }

            @Override
            public void onFailure(Call<PlantResponse> call, Throwable t) {
                Log.i("Error", t.getMessage());
            }
        });
    }

    public void deleteGreenhouse(int id)
    {
        GreenHouseApi greenHouseApi = ServiceProvider.getGreenHouseApi();
        Call<Void> call =  greenHouseApi.removeGreenhouse(id);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    public void deletePlant(int id)
    {
        GreenHouseApi greenHouseApi = ServiceProvider.getGreenHouseApi();
        Call<Void> call =  greenHouseApi.removePlant(id);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    public void deleteRoutine(int id)
    {
        GreenHouseApi greenHouseApi = ServiceProvider.getGreenHouseApi();
        Call<Void> call =  greenHouseApi.removeRoutine(id);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    public void activateWatering(int greenhouseId)
    {
        GreenHouseApi greenHouseApi = ServiceProvider.getGreenHouseApi();
        Call<Void> call =  greenHouseApi.activeActuator(greenhouseId);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

}
