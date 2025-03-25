package com.example.finalproject;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {
    protected DrawerLayout drawerLayout;
    protected Toolbar toolbar;
    protected NavigationView navigationView;
    protected RecyclerView lessonsRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void setupMenu(@LayoutRes int layoutRes, Context context) {
        setContentView(layoutRes);

        // Initialize views
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_view);
        lessonsRecyclerView = findViewById(R.id.lessonsRecyclerView); // Ensure this is in the layout

        // Setup toolbar
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

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
            LessonAdapter lessonAdapter = new LessonAdapter(lessonList, context);
            lessonsRecyclerView.setAdapter(lessonAdapter);
        }
    }

    private List<Lesson> createSampleLessons() {
        return new ArrayList<>(LessonModule.getAllLessons()); // Ensure LessonModule.getAllLessons() returns a valid list
    }
}
