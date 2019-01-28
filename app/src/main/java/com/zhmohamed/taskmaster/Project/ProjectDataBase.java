package com.zhmohamed.taskmaster.Project;

import android.arch.persistence.room.Database;



@Database(entities = {Project.class}, version = 1)
public abstract class ProjectDataBase {
    public abstract ProjectDao getProjectDao();
}
