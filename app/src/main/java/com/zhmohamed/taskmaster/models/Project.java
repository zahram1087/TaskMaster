package com.zhmohamed.taskmaster.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Project {
    ////source: https://developer.android.com/training/data-storage/room/defining-data


    @PrimaryKey(autoGenerate = true)
    public long id;
    public String title;
    public String description;

    public Project () {}

    public Project (String title, String description) {

        this.title = title;
        this.description = description;
    }

    public String toString(){

        return this.title + ": " + this.description;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

}
