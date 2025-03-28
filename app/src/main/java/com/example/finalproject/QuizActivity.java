package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private LessonDatabaseHelper lessonDatabaseHelper;
    private TextView questionTextView;
    private RadioGroup answerRadioGroup;
    private Button submitButton,nextQuestionButton,btnBack;
    private TextView quizProgressTextView;
    private List<QuizQuestion> quizQuestions;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private String currentLessonTitle;
    private static String[] LESSON = {
            "1. ชนิดข้อมูล (Data Types)", "2. ตัวแปร (Variables)", "3. ตัวดำเนินการ (Operators)",
            "4. คำสั่งควบคุม (Control Statements)", "5. ฟังก์ชัน (Function)"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        lessonDatabaseHelper = new  LessonDatabaseHelper(this);
//        setupMenu(R.layout.activity_quiz, this);

        // Initialize views
        questionTextView = findViewById(R.id.questionTextView);
        answerRadioGroup = findViewById(R.id.answerRadioGroup);
        submitButton = findViewById(R.id.submitButton);
        btnBack = findViewById(R.id.btnToTitle);
        nextQuestionButton = findViewById(R.id.nextQuestionButton);
        quizProgressTextView = findViewById(R.id.quizProgressTextView);

        // Get lesson title from intent
        currentLessonTitle = getIntent().getStringExtra("LESSON_TITLE");

        if (currentLessonTitle == null) {
            Toast.makeText(this, "No lesson selected for quiz", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        // Load quiz questions for the specific lesson
        quizQuestions = loadQuizQuestions(currentLessonTitle);

        if (quizQuestions.isEmpty()) {
            Toast.makeText(this, "No quiz available for this lesson", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        // Initial setup
        setupQuizUI();

        btnBack.setOnClickListener(v -> back());
        submitButton.setOnClickListener(v -> checkAnswer());
        nextQuestionButton.setOnClickListener(v -> loadNextQuestion());
    }

    private List<QuizQuestion> loadQuizQuestions(String lessonTitle) {
        List<QuizQuestion> questions = new ArrayList<>();

        // Retrieve quiz questions dynamically from LessonModule
        int quizQuestionCount = LessonModule.getQuizQuestionCount(lessonTitle);

        for (int i = 1; i <= quizQuestionCount; i++) {
            String questionText = LessonModule.getQuizQuestionText(lessonTitle, i);
            String[] options = LessonModule.getQuizQuestionOptions(lessonTitle, i);
            int correctIndex = LessonModule.getQuizQuestionCorrectIndex(lessonTitle, i);

            questions.add(new QuizQuestion(questionText, options, correctIndex));
        }

        return questions;
    }

    private void back() {
        Intent MainAct = new Intent(QuizActivity.this, MainActivity.class);
        startActivity(MainAct);
        finish();
    }
    private void setupQuizUI() {
        // Reset UI
        answerRadioGroup.clearCheck();
        submitButton.setVisibility(View.VISIBLE);
        nextQuestionButton.setVisibility(View.GONE);

        // Update progress
        quizProgressTextView.setText(String.format("Question %d of %d",
                currentQuestionIndex + 1, quizQuestions.size()));

        // Load current question
        QuizQuestion currentQuestion = quizQuestions.get(currentQuestionIndex);
        questionTextView.setText(currentQuestion.getQuestionText());

        // Clear previous radio buttons
        answerRadioGroup.removeAllViews();

        // Add new radio buttons for current question
        for (int i = 0; i < currentQuestion.getAnswerOptions().length; i++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(currentQuestion.getAnswerOptions()[i]);
            radioButton.setId(View.generateViewId());
            answerRadioGroup.addView(radioButton);
        }
    }

    private void checkAnswer() {
        int selectedAnswerId = answerRadioGroup.getCheckedRadioButtonId();
        if (selectedAnswerId == -1) {
            Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show();
            return;
        }

        QuizQuestion currentQuestion = quizQuestions.get(currentQuestionIndex);
        RadioButton selectedRadioButton = findViewById(selectedAnswerId);
        int selectedAnswerIndex = answerRadioGroup.indexOfChild(selectedRadioButton);

        if (selectedAnswerIndex == currentQuestion.getCorrectAnswerIndex()) {
            score++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();
        }

        // Disable submit button and show next question button
        submitButton.setVisibility(View.GONE);
        nextQuestionButton.setVisibility(View.VISIBLE);
    }

    private void loadNextQuestion() {
        currentQuestionIndex++;

        if (currentQuestionIndex < quizQuestions.size()) {
            setupQuizUI();
        } else {
            // Quiz completed
            showQuizResult();
        }
    }

    public int index(String lessonTitle) {
        for (int i = 0; i < LESSON.length; i++) {
            if (LESSON[i].equals(lessonTitle)) {
                return i;
            }
        }
        return -1;
    }

    private void showQuizResult() {
        // Calculate pass percentage
        double passPercentage = (double) score / quizQuestions.size() * 100;

        // Determine pass/fail status
        boolean isPassed = passPercentage >= 70.0; // 70% pass threshold

        // Update UI with result
        questionTextView.setText(String.format(
                "Quiz Completed!\n\nYour Score: %d/%d\nPercentage: %.1f%%\n\n%s",
                score,
                quizQuestions.size(),
                passPercentage,
                isPassed ? "Congratulations! You Passed!" : "Sorry, Please Try Again."
        ));

        // Mark lesson as completed if passed
        if (isPassed) {
            int INDEX = index(currentLessonTitle);
            lessonDatabaseHelper.setLessonCompleted(currentLessonTitle,true);
            int highScore = lessonDatabaseHelper.getLessonScore(currentLessonTitle);
            if(score>highScore){
                lessonDatabaseHelper.setLessonScore(currentLessonTitle,score);
            }
            try {
                lessonDatabaseHelper.setLessonUnlocked(LESSON[INDEX+1], true);
                Toast.makeText(this, "Lesson "+LESSON[INDEX+1]+" Unlocked!", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "Congratulation!! You completed all the lesson.", Toast.LENGTH_LONG).show();
            }
        }

        // Clear radio group and buttons
        answerRadioGroup.removeAllViews();
        submitButton.setVisibility(View.GONE);
        nextQuestionButton.setVisibility(View.GONE);
    }

    // Inner class to represent a quiz question
    private static class QuizQuestion {
        private String questionText;
        private String[] answerOptions;
        private int correctAnswerIndex;

        public QuizQuestion(String questionText, String[] answerOptions, int correctAnswerIndex) {
            this.questionText = questionText;
            this.answerOptions = answerOptions;
            this.correctAnswerIndex = correctAnswerIndex;
        }

        public String getQuestionText() { return questionText; }
        public String[] getAnswerOptions() { return answerOptions; }
        public int getCorrectAnswerIndex() { return correctAnswerIndex; }
    }
}