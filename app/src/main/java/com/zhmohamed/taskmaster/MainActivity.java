package com.zhmohamed.taskmaster;

import androidx.annotation.Nullable;
import androidx.room.Room;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.zhmohamed.taskmaster.Adapters.ProjectAdapter;
import com.zhmohamed.taskmaster.models.Project;


import java.util.Arrays;
import java.util.List;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;




public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter projectAdapter;
    private RecyclerView.LayoutManager layoutManager;
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

    //FUNCTIONALITY TO GO TO OTHER ACTIVITIES:

    public void goToProject(View view){

        Intent projectIntent = new Intent(this, AddProjectActivity.class);
        startActivityForResult(projectIntent,1997);
    }

    public void renderRecyclerView(){

        recyclerView = (RecyclerView) findViewById(R.id.project_recycler_view);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // define an adapter
//        projectAdapter = new ProjectAdapter(projectDatabase.projectDao().getAll());
//        recyclerView.setAdapter(projectAdapter);
    }

    public void onLoginButtonClick(View v){

        // Choose authentication providers
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build());

        // Create and launch sign-in intent
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                RC_SIGN_IN);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                TextView showName = findViewById(R.id.textView);
                showName.setText(user.getDisplayName());
                // ...
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }

}