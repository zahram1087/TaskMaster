package com.zhmohamed.taskmaster;

import androidx.annotation.Nullable;
import androidx.room.Room;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zhmohamed.taskmaster.Adapters.ProjectAdapter;
import com.zhmohamed.taskmaster.database.ProjectDataBase;
import com.zhmohamed.taskmaster.entities.Project;


import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;




public class MainActivity extends AppCompatActivity {

    private RecyclerView projectList;
    private RecyclerView.Adapter projectAdapter;
    private RecyclerView.LayoutManager projectLayoutManager;
    private List<String> projectStrings;
    private List<Project> projects;
    ProjectDataBase db;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(), ProjectDataBase.class, "projects").build();

        projects = db.getProjectDao().getAllproject();

        projectList = findViewById(R.id.project_recycler_view);

        // recycler view won't resize for content
        projectList.setHasFixedSize(true);

        // linear layout manager
        projectLayoutManager = new LinearLayoutManager(this);
        projectList.setLayoutManager(projectLayoutManager);

        // the adapter for the recycler view
        projectAdapter = new ProjectAdapter(projects);
        projectList.setAdapter(projectAdapter);

    }


    //FUNCTIONALITY TO GO TO OTHER ACTIVITIES:

    public void goToProject(View view){

        Intent projectIntent = new Intent(this, ProjectActivity.class);
        startActivityForResult(projectIntent,1997);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        projects = db.getProjectDao().getAllproject();
        projectAdapter.notifyDataSetChanged();
//        projectAdapter.updateAdapterData(projects);

    }

}