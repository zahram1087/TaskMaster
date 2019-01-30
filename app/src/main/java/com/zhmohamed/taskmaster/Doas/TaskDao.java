package com.zhmohamed.taskmaster.Doas;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.zhmohamed.taskmaster.entities.Task;

import java.util.List;

@Dao
public interface TaskDao {

    @Update
    void update(Task... tasks);

    // Gets all tasks in the database
    @Query("SELECT * FROM Task")
    List<Task> getTasks ();

    @Update
    void updateTask (Task task);

    @Query("SELECT * FROM task WHERE taskId=:taskId")
    Task getById(long taskId);

    @Insert
    void insertTask(Task task);

    @Insert
    void insertMultipleTasks (List<Task> taskList);

    @Delete
    void delete(Task task);

    //source: https://stackoverflow.com/questions/14018394/android-sqlite-query-getting-latest-10-records
    @Query("SELECT * FROM task order by taskId DESC limit 1")
    Task getLast();

    @Query("SELECT * FROM Task WHERE projectId = :projectId")
    List<Task> getTasksByProjectId (long projectId);




}
