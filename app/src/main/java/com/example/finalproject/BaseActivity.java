package com.example.finalproject;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {

    protected LessonDatabaseHelper lessonDatabaseHelper;
    protected DrawerLayout drawerLayout;
    protected Toolbar toolbar;
    protected NavigationView navigationView;
    protected RecyclerView lessonsRecyclerView;
    protected Button btnReset, btnHome;
    protected Activity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void setupMenu(@LayoutRes int layoutRes, Context context, Activity activity, boolean[] isCompleted, boolean[] isUnlocked) {
        setContentView(layoutRes);
        lessonDatabaseHelper = new LessonDatabaseHelper(context);

        // Initialize views
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_view);
        lessonsRecyclerView = findViewById(R.id.lessonsRecyclerView);
        btnReset = findViewById(R.id.btnReset);
        btnHome = findViewById(R.id.btnHome);

        btnReset.setOnClickListener(view -> {
            new AlertDialog.Builder(context)
                    .setTitle("⚠\uFE0F Warning: Reset Data")
                    .setMessage("This action will permanently erase all progress, including scores, unlocked lessons, and completed lessons.\n\nThis cannot be undone. Are you sure you want to reset your data?")
                    .setPositiveButton("Reset Data", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            lessonDatabaseHelper.resetDatabase();
                            // Start quiz
                            Intent mainAct = new Intent(context, MainActivity.class);
                            startActivity(mainAct);
                            activity.finish();
                        }
                    })
                    .setNegativeButton("Cancel", null)
                    .show();
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainAct = new Intent(context, MainActivity.class);
                startActivity(mainAct);
            }
        });


//        setSupportActionBar(toolbar);
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setDisplayShowTitleEnabled(false);
//        }
//
        // Setup drawer toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                (Activity) context, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Setup RecyclerView in drawer
        if (lessonsRecyclerView != null) {
            lessonsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            List<Lesson> lessonList = createSampleLessons();
            LessonAdapter lessonAdapter = new LessonAdapter(lessonList, context, activity, isCompleted, isUnlocked);
            lessonsRecyclerView.setAdapter(lessonAdapter);
        }
    }

    private List<Lesson> createSampleLessons() {
        return new ArrayList<>(LessonModule.getAllLessons()); // Ensure LessonModule.getAllLessons() returns a valid list
    }
}
