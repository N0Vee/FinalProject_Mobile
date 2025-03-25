package com.example.finalproject;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private Button startLessonButton;
    private RecyclerView lessonsRecyclerView;
    private TextView usernameText;
    private TextView userScoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        startLessonButton = findViewById(R.id.startLessonButton);
        lessonsRecyclerView = findViewById(R.id.lessonsRecyclerView);
        usernameText = findViewById(R.id.username);
        userScoreText = findViewById(R.id.userScore);

        // Setup toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Setup drawer toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Setup RecyclerView in drawer
        lessonsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Lesson> lessonList = createSampleLessons();
        LessonAdapter lessonAdapter = new LessonAdapter(lessonList, MainActivity.this);
        lessonsRecyclerView.setAdapter(lessonAdapter);

        // Set user data
        usernameText.setText("John Doe");
        userScoreText.setText("750 points");

        // Setup start lesson button
        startLessonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Lesson lesson : lessonList) {
                    if (!lesson.isCompleted() && lesson.isUnlocked()) {
                        Toast.makeText(MainActivity.this,
                                "Starting lesson: " + lesson.getTitle(),
                                Toast.LENGTH_SHORT).show();

                        break;
                    }
                }
            }
        });
    }

    private List<Lesson> createSampleLessons() {
        return new ArrayList<>(LessonModule.getAllLessons()); //return hashmap in to array
    }
}