package com.example.greenhouseappnew.network;



import androidx.room.Delete;

import com.example.greenhouseappnew.model.Greenhouse;
import com.example.greenhouseappnew.model.GreenhouseResponse;
import com.example.greenhouseappnew.model.LogListResponse;
import com.example.greenhouseappnew.model.LogResponse;
import com.example.greenhouseappnew.model.Plant;
import com.example.greenhouseappnew.model.PlantListResponse;
import com.example.greenhouseappnew.model.PlantResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface GreenHouseApi {

    @GET("GreenhouseById/{greenhouseId}")
    Call<GreenhouseResponse> getGreenHouseById(@Path("greenhouseId") int greenhouseId);

    @GET("PlantById/{plantId}")
    Call<PlantResponse> getPlantById(@Path("plantId") int plantId);

    @GET("Greenhouse/{userEmail}")
    Call<GreenhouseResponse> getGreenHouseByEmail(@Path("userMail") String userMail);

    @GET("Plants/{greenhouseId")
    Call<PlantListResponse> getPlantsFromGreenHouse(@Path("greenhouseId") int greenhouseId);

    @GET("Logs/{greenhouseId}")
    Call<LogListResponse> getLogsByGreenhouseId(@Path("greenhouseId") int greenhouseId);

    @GET("LogsById/{logId}")
    Call<LogResponse> getLogById(@Path("logId") int logId);

    @POST("Greenhouse")
    @Headers({"Accept:application/json", "Content-Type:application/json"})
    Call<GreenhouseResponse> addGreenHouse(@Body Greenhouse params);

    @POST("Plants")
    @Headers({"Accept:application/json", "Content-Type:application/json"})
    Call<PlantResponse> addPlant(@Body Plant params);

    @PUT("Greenhouse")
    Call<GreenhouseResponse> updateGreenhouse(@Body Greenhouse greenHouse);

    @PUT("Plants")
    Call<PlantResponse> updatePlant(@Body Plant plant);

    @DELETE("Greenhouse/greenhouseId")
    Call<Void> removeGreenhouse(@Path("greenhouseId") int id);

    @DELETE("Plants/{plantId}")
    Call<Void> removePlant(@Path("plantId") int id);

    @DELETE("Routine/{routineId}")
    Call<Void> removeRoutine(@Path("routineID") int id);


}