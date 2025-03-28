package com.example.finalproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LessonCanva extends BaseActivity {

    private TextView usernameText, userScoreText;
    private LessonDatabaseHelper myDatabaseHelper;
    private TextView lessonTitleTextView;
    private TextView lessonContentTextView;
    private Button nextPageButton;
    private Button prevPageButton;
    private Button quizButton;

    private String currentLessonTitle;
    private int currentPage = 1;
    private int maxPages;
    private boolean[] isCompleted;
    private boolean[] isUnlocked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lesson_canva);

        // Setup Menu
        myDatabaseHelper = new LessonDatabaseHelper(this);
        isCompleted = myDatabaseHelper.getCompletedArray();
        isUnlocked = myDatabaseHelper.getUnlockedArray();
        setupMenu(R.layout.activity_lesson_canva, this, LessonCanva.this,isCompleted,isUnlocked);

        // Initialize views
        lessonTitleTextView = findViewById(R.id.lessonTitleTextView);
        lessonContentTextView = findViewById(R.id.lessonContentTextView);
        nextPageButton = findViewById(R.id.nextPageButton);
        prevPageButton = findViewById(R.id.prevPageButton);
        quizButton = findViewById(R.id.quizButton);
        usernameText = findViewById(R.id.username);
        userScoreText = findViewById(R.id.userScore);

        // Get the lesson title from the intent
        currentLessonTitle = getIntent().getStringExtra("LESSON_TITLE");
        int score = myDatabaseHelper.getTotalScore();
        double progress = myDatabaseHelper.getCompletionPercentage();

        usernameText.setText("JS Learner");
        userScoreText.setText(score+"/50 points");

        if (currentLessonTitle != null) {
            // Get max pages for this lesson
            maxPages = LessonModule.getMaxPage(currentLessonTitle);

            // Load initial page
            loadPage(currentPage);

            // Setup page navigation buttons
            nextPageButton.setOnClickListener(v -> {
                if (currentPage < maxPages) {
                    currentPage++;
                    loadPage(currentPage);
                }
            });

            prevPageButton.setOnClickListener(v -> {
                if (currentPage > 1) {
                    currentPage--;
                    loadPage(currentPage);
                }
            });


            updateNavigationButtons();


            quizButton.setOnClickListener(v -> {
                // Show AlertDialog to confirm Quiz start
                new AlertDialog.Builder(LessonCanva.this)
                        .setTitle("Start Quiz")
                        .setMessage("Do you want to start the quiz now?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Start the quiz activity
                                Intent quizIntent = new Intent(LessonCanva.this, QuizActivity.class);
                                quizIntent.putExtra("LESSON_TITLE", currentLessonTitle);
                                startActivity(quizIntent);
                                finish();
                            }
                        })
                        .setNegativeButton("No", null) // Do nothing if user clicks No
                        .show();
            });

        } else {

            Toast.makeText(this, "No lesson selected", Toast.LENGTH_SHORT).show();
            finish();
        }


        //Handle window insets
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.lessonsRecyclerView), (v, insets) -> {
//            WindowInsetsCompat.Type.systemBars();
//            return insets;
//        });
    }

    private void loadPage(int page) {
        String pageTitle = LessonModule.getLessonContent(currentLessonTitle, page, "title");
        String pageContent = LessonModule.getLessonContent(currentLessonTitle, page, "content");

        lessonTitleTextView.setText(pageTitle);
        lessonContentTextView.setText(pageContent);
        updateNavigationButtons();
    }

    private void updateNavigationButtons() {
        prevPageButton.setVisibility(currentPage > 1 ? View.VISIBLE : View.INVISIBLE);
        if (currentPage < maxPages) {
            nextPageButton.setVisibility(View.VISIBLE);
            quizButton.setVisibility(View.GONE);
        } else {
            nextPageButton.setVisibility(View.GONE);
            quizButton.setVisibility(View.VISIBLE);
        }
    }
}
