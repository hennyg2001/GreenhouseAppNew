package com.example.greenhouseappnew.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

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
    List<Greenhouse> getAllGreenhouses();

    @Update
    void updateGreenhouse(Greenhouse greenhouse);

    @Query("SELECT * FROM Greenhouse WHERE id = :id")
    Greenhouse getGreenhouseById(int id);

    @Query("SELECT * FROM Greenhouse WHERE userEmail = :mail")
    List<Greenhouse> getGreenhouseByEmail(String mail);






}
