package com.example.greenhouseappnew.data;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.greenhouseappnew.model.Log;
import com.example.greenhouseappnew.model.Plant;

import java.util.List;

public interface LogDAO {

    @Query("SELECT * FROM logs")
    List<Log> getAll();

    @Insert
    void insert(Log log);

    @Delete
    void delete(Log log);

}
