package com.zhmohamed.taskmaster.Project;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.zhmohamed.taskmaster.Task.Task;

import java.util.List;

@Entity
public class Project {
    ////source: https://developer.android.com/training/data-storage/room/defining-data

    @PrimaryKey(autoGenerate = true)
    public long id;

    public String title;
    public String description;
//    public List<Task> task;

    // empty constructor
    public Project(){}

    //constructor
    public Project(String title, String description){
        this.title = title;
        this.description = description;
    }

    public String toString() {
        return this.title + ": " + this.description;
    }

    //oneproject many task
    //oneToMany
    //ManytoOne
}
