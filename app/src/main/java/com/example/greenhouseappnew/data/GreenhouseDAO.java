package com.example.greenhouseappnew.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.greenhouseappnew.model.Greenhouse;
import com.example.greenhouseappnew.model.Plant;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface GreenhouseDAO
{
    @Insert
    void insert(Greenhouse greenhouse);

    @Delete
    void delete(Greenhouse greenhouse);

    @Query("SELECT * FROM Greenhouse")
    LiveData<List<Greenhouse>> getAllGreenhouses();

    @Query("SELECT * FROM Greenhouse WHERE id = :id")
    LiveData<Greenhouse> getGreenhouseById(int id);

    @Query("SELECT * FROM Greenhouse WHERE userEmail = :mail")
    LiveData<Greenhouse> getGreenhouseByEmail(String mail);

    @Query("UPDATE Greenhouse SET name = :Name, userEmail = :UserEmail, location = :Location, description = :Description, area = :Area, co2Preferred = :PreferredCo2, temperaturePreferred = :PreferredTemperature, humidityPreferred = :PreferredHumidity, actuatorSet = :actuatorSet  WHERE id = :id")
    LiveData<Greenhouse> updateGreenhouse(int id, String Name, String UserEmail, String Location, String Description, Double Area, Double PreferredCo2, Double PreferredTemperature, Double PreferredHumidity, boolean actuatorSet);





}
