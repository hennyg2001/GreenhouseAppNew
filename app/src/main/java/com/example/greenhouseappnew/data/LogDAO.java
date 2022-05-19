package com.example.greenhouseappnew.data;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.greenhouseappnew.model.LogClass;

import java.util.List;

public interface LogDAO {

    @Query("SELECT * FROM logs")
    List<LogClass> getAll();

    @Insert
    void insert(LogClass logClass);

    @Delete
    void delete(LogClass logClass);

}
