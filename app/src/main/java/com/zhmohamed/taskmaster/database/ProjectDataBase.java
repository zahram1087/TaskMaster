package com.zhmohamed.taskmaster.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.zhmohamed.taskmaster.Doas.TaskDao;
import com.zhmohamed.taskmaster.entities.Project;
import com.zhmohamed.taskmaster.Doas.ProjectDao;
import com.zhmohamed.taskmaster.entities.Task;


@Database(entities = {Project.class,Task.class}, version = 1)
public abstract class ProjectDataBase extends RoomDatabase {
    public abstract TaskDao getTaskDao();
    public abstract ProjectDao getProjectDao();
}
