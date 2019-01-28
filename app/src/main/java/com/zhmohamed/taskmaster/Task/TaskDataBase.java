package com.zhmohamed.taskmaster.Task;

import android.arch.persistence.room.Database;


import com.zhmohamed.taskmaster.Project.Project;
import com.zhmohamed.taskmaster.Project.ProjectDao;


@Database(entities = {Project.class}, version = 1)
public abstract class TaskDataBase {
    public abstract TaskDao getTaskDao();

    public abstract ProjectDao getProjectDao();


}
