package com.zhmohamed.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zhmohamed.taskmaster.database.ProjectDataBase;
import com.zhmohamed.taskmaster.entities.Project;

public class ProjectActivity extends AppCompatActivity {

    ProjectDataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        db = Room.databaseBuilder(getApplicationContext(), ProjectDataBase.class, "projects").allowMainThreadQueries().build();
    }



    public void onCreateProject(View v) {

        // Get the inputs
        TextView titleView = findViewById(R.id.project_name_input);
        TextView descriptionView = findViewById(R.id.description_input);
        String title = titleView.getText().toString();
        String description = descriptionView.getText().toString();

        // Make the project
        Project theProject = new Project(title, description);

        // Save the project
        db.getProjectDao().insertProject(theProject);

        // End activity, also redirects you back to where the activity was intialized from (mainActivity)
        finish();
    }
}
