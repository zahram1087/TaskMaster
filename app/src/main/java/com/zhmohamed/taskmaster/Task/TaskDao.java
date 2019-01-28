package com.zhmohamed.taskmaster.Task;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.zhmohamed.taskmaster.Project.Project;

import java.util.List;

@Dao
public interface TaskDao {

    @Update
    void update(Task... tasks);

    // Gets all tasks in the database
    @Query("SELECT * FROM task")
    List<Task> getAlltask();

    @Query("SELECT * FROM task WHERE id=:id")
    Task getById(long id);

    @Insert
    void insertAll(Task task);

    @Delete
    void delete(Task task);

    //source: https://stackoverflow.com/questions/14018394/android-sqlite-query-getting-latest-10-records
    @Query("SELECT * FROM task order by id DESC limit 1")
    Task getLast();




}
