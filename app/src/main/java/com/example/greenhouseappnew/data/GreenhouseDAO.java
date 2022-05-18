package com.example.greenhouseappnew.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.greenhouseappnew.model.Greenhouse;
import com.example.greenhouseappnew.model.Plant;

import java.util.List;

@Dao
public interface GreenhouseDAO {

    @Query("SELECT * FROM greenhouses")
    List<Greenhouse> getAll();

    @Insert
    void insert(Greenhouse greenhouse);

    @Delete
    void delete(Greenhouse greenhouse);

}
