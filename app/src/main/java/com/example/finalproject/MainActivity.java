package com.example.finalproject;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

//    private DrawerLayout drawerLayout;
//    private Toolbar toolbar;
    private Button startLessonButton;
//    private RecyclerView lessonsRecyclerView;
    private TextView usernameText, userScoreText, progressText;

    private ProgressBar progressBar;

    private LessonDatabaseHelper myDatabaseHelper;

    private boolean[] isCompleted;
    private boolean[] isUnlocked;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Setup Menu
        myDatabaseHelper = new LessonDatabaseHelper(this);
        isCompleted = myDatabaseHelper.getCompletedArray();
        isUnlocked = myDatabaseHelper.getUnlockedArray();
        setupMenu(R.layout.activity_main, this, MainActivity.this,isCompleted,isUnlocked);

        // Initialized
        startLessonButton = findViewById(R.id.startLessonButton);
        progressText = findViewById(R.id.progressText);
        progressBar = findViewById(R.id.courseProgress);
        usernameText = findViewById(R.id.username);
        userScoreText = findViewById(R.id.userScore);

        List<Lesson> lessonList = createSampleLessons();

        int score = myDatabaseHelper.getTotalScore();
        double progress = myDatabaseHelper.getCompletionPercentage();

        // Set user data
        usernameText.setText("John Doe");
        userScoreText.setText(score+"/50 points");
        progressText.setText(String.format("%d%%", (int) progress));
        progressBar.setProgress((int) progress);

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