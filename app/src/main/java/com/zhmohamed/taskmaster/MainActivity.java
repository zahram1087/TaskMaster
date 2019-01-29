package com.zhmohamed.taskmaster;

import androidx.room.Room;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zhmohamed.taskmaster.Adapters.ProjectAdapter;
import com.zhmohamed.taskmaster.database.ProjectDataBase;
import com.zhmohamed.taskmaster.entities.Project;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.room.Room;
import androidx.room.RoomDatabase;


public class MainActivity extends AppCompatActivity {

    private RecyclerView projectList;
    private RecyclerView.Adapter projectAdapter;
    private RecyclerView.LayoutManager projectLayoutManager;
    private List<String> projectStrings;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProjectDataBase db = Room.databaseBuilder(getApplicationContext(), ProjectDataBase.class, "projects").build();



        List<Project> projects = db.getProjectDao().getAllproject();
        projectStrings = new ArrayList<>();
        for (Project project : projects) {
            projectStrings.add(project.toString());

        }



        projectList = findViewById(R.id.project_recycler_view);

        // recycler view won't resize for content
        projectList.setHasFixedSize(true);

        // linear layout manager
        projectLayoutManager = new LinearLayoutManager(this);
        projectList.setLayoutManager(projectLayoutManager);

        // the adapter for the recycler view
        projectAdapter = new ProjectAdapter(projectStrings);
        projectList.setAdapter(projectAdapter);

    }


    //FUNCTIONALITY TO GO TO OTHER ACTIVITIES:

    public void goToProject (View view){

        Intent projectIntent = new Intent(this, ProjectActivity.class);
        startActivity(projectIntent);
    }

}