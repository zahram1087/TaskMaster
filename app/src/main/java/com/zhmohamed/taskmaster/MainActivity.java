package com.zhmohamed.taskmaster;

import androidx.annotation.Nullable;
import androidx.room.Room;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zhmohamed.taskmaster.Adapters.ProjectAdapter;
import com.zhmohamed.taskmaster.models.Project;


import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;




public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter projectAdapter;
    private RecyclerView.LayoutManager projectLayoutManager;
    private List<String> projectStrings;
    private List<Project> projects;

    private static final int RC_SIGN_IN = 482;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        renderRecyclerView();

    }


    @Override
    protected void onRestart() {
        renderRecyclerView();
        super.onRestart();
    }

    public void renderRecyclerView(){

        recyclerView = (RecyclerView) findViewById(R.id.project_recycler_view);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    //FUNCTIONALITY TO GO TO OTHER ACTIVITIES:

    public void goToProject(View view){

        Intent projectIntent = new Intent(this, AddProjectActivity.class);
        startActivityForResult(projectIntent,1997);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        projects = db.getProjectDao().getAllproject();
        projectAdapter.notifyDataSetChanged();
//        projectAdapter.updateAdapterData(projects);

    }

}