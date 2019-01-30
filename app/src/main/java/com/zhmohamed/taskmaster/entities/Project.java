package com.zhmohamed.taskmaster.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Project {
    ////source: https://developer.android.com/training/data-storage/room/defining-data

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String title;
    private String description;
//    public List<Task> task;

    // empty constructor
    public Project(){}

    //constructor
    public Project(String title, String description){
        this.title = title;
        this.description = description;
    }

    public long getId () {return this.id;}
    public String getTitle () {return this.title;}
    public String getDescription () {return this.description;}

    public void setId (long id) {this.id = id;}
    public void setTitle (String title) {this.title = title;}
    public void setDescription (String description) {this.description = description;}


    public String toString() {
        return this.title + ": " + this.description;
    }


}
