package com.example.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Pair;

import java.util.LinkedHashMap;

public class LessonDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "lessons.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Lessons";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_LESSON = "lesson";
    private static final String COLUMN_SCORE = "score";
    private static final String COLUMN_UNLOCKED = "unlocked";
    private static final String COLUMN_COMPLETED = "completed";

    public LessonDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_LESSON + " TEXT, "
                + COLUMN_SCORE + " REAL, "
                + COLUMN_UNLOCKED + " BOOLEAN, "
                + COLUMN_COMPLETED + " BOOLEAN);";
        db.execSQL(createTable);
        insertDefaultData(db);
    }

    private void insertDefaultData(SQLiteDatabase db) {
        addLesson(db, "1. ชนิดข้อมูล (Data Types)", 0, true, false);
        addLesson(db, "2. ตัวแปร (Variables)", 0, false, false);
        addLesson(db, "3. ตัวดำเนินการ (Operators)", 0, false, false);
        addLesson(db, "4. คำสั่งควบคุม (Control Statements)", 0, false, false);
        addLesson(db, "5. ฟังก์ชัน (Function)", 0, false, false);
    }

    private void addLesson(SQLiteDatabase db, String lesson, int score, boolean unlocked, boolean completed) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_LESSON, lesson);
        values.put(COLUMN_SCORE, score);
        values.put(COLUMN_UNLOCKED, unlocked ? 1 : 0);
        values.put(COLUMN_COMPLETED, completed ? 1 : 0);
        db.insert(TABLE_NAME, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long addLesson(String lesson, int score, boolean unlocked, boolean completed) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_LESSON, lesson);
        values.put(COLUMN_SCORE, score);
        values.put(COLUMN_UNLOCKED, unlocked ? 1 : 0);
        values.put(COLUMN_COMPLETED, completed ? 1 : 0);
        return db.insert(TABLE_NAME, null, values);
    }

    public Cursor getAllLessons() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    public int updateLesson(int id, String lesson, int score, boolean unlocked, boolean completed) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_LESSON, lesson);
        values.put(COLUMN_SCORE, score);
        values.put(COLUMN_UNLOCKED, unlocked ? 1 : 0);
        values.put(COLUMN_COMPLETED, completed ? 1 : 0);
        return db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
    }

    public void deleteLesson(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
    }

    public int getTotalScore() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT SUM(" + COLUMN_SCORE + ") FROM " + TABLE_NAME, null);
        int totalScore = 0;
        if (cursor.moveToFirst()) {
            totalScore = cursor.getInt(0);
        }
        cursor.close();
        return totalScore;
    }

    public double getCompletionPercentage() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor totalCursor = db.rawQuery("SELECT COUNT(*) FROM " + TABLE_NAME, null);
        Cursor completedCursor = db.rawQuery("SELECT COUNT(*) FROM " + TABLE_NAME + " WHERE " + COLUMN_COMPLETED + " = 1", null);

        int totalLessons = 0;
        int completedLessons = 0;

        if (totalCursor.moveToFirst()) {
            totalLessons = totalCursor.getInt(0);
        }
        if (completedCursor.moveToFirst()) {
            completedLessons = completedCursor.getInt(0);
        }

        totalCursor.close();
        completedCursor.close();

        if (totalLessons == 0) return 0;
        return (completedLessons / (double) totalLessons) * 100;
    }

    public LinkedHashMap<String, Pair<Boolean, Boolean>> getLessonsFromDatabase() {
        LinkedHashMap<String, Pair<Boolean, Boolean>> lessonsMap = new LinkedHashMap<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT lesson, unlocked, completed FROM " + TABLE_NAME, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                String lessonTitle = cursor.getString(0);
                boolean isUnlocked = cursor.getInt(1) == 1;
                boolean isCompleted = cursor.getInt(2) == 1;
                lessonsMap.put(lessonTitle, new Pair<>(isUnlocked, isCompleted));
            }
            cursor.close();
        }

        return lessonsMap;
    }

    public boolean isLessonUnlocked(String lesson) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + COLUMN_UNLOCKED + " FROM " + TABLE_NAME + " WHERE " + COLUMN_LESSON + " = ?", new String[]{lesson});

        boolean isUnlocked = false;
        if (cursor.moveToFirst()) {
            isUnlocked = cursor.getInt(0) == 1;
        }
        cursor.close();
        return isUnlocked;
    }

    public boolean isLessonCompleted(String lesson) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + COLUMN_COMPLETED + " FROM " + TABLE_NAME + " WHERE " + COLUMN_LESSON + " = ?", new String[]{lesson});

        boolean isCompleted = false;
        if (cursor.moveToFirst()) {
            isCompleted = cursor.getInt(0) == 1;
        }
        cursor.close();
        return isCompleted;
    }

    public boolean[] getCompletedArray() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + COLUMN_COMPLETED + " FROM " + TABLE_NAME, null);

        boolean[] completedArray = new boolean[cursor.getCount()];
        int index = 0;

        while (cursor.moveToNext()) {
            completedArray[index++] = cursor.getInt(0) == 1;
        }

        cursor.close();
        return completedArray;
    }

    public boolean[] getUnlockedArray() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + COLUMN_UNLOCKED + " FROM " + TABLE_NAME, null);

        boolean[] unlockedArray = new boolean[cursor.getCount()];
        int index = 0;

        while (cursor.moveToNext()) {
            unlockedArray[index++] = cursor.getInt(0) == 1;
        }

        cursor.close();
        return unlockedArray;
    }

    public void setLessonCompleted(String lesson, boolean completed) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_COMPLETED, completed ? 1 : 0);
        db.update(TABLE_NAME, values, COLUMN_LESSON + " = ?", new String[]{lesson});
    }

    public void setLessonUnlocked(String lesson, boolean unlocked) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_UNLOCKED, unlocked ? 1 : 0);
        db.update(TABLE_NAME, values, COLUMN_LESSON + " = ?", new String[]{lesson});
    }

    public void setLessonScore(String lesson, int score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SCORE, score);
        db.update(TABLE_NAME, values, COLUMN_LESSON + " = ?", new String[]{lesson});
    }

    public int getLessonScore(String lesson) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + COLUMN_SCORE + " FROM " + TABLE_NAME + " WHERE " + COLUMN_LESSON + " = ?", new String[]{lesson});

        int score = 0; // Default score if lesson is not found
        if (cursor.moveToFirst()) {
            score = cursor.getInt(0);
        }
        cursor.close();
        return score;
    }

    public void resetDatabase() {
        SQLiteDatabase db = this.getWritableDatabase();

        // Delete all rows in the Lessons table
        db.execSQL("DELETE FROM " + TABLE_NAME);

        // Reset the auto-increment counter (optional)
        db.execSQL("DELETE FROM sqlite_sequence WHERE name='" + TABLE_NAME + "'");

        // Reinsert default lessons
        insertDefaultData(db);

        db.close();
    }

    public String getLatestUnlockedNotCompletedLesson() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + COLUMN_LESSON + " FROM " + TABLE_NAME +
                " WHERE " + COLUMN_UNLOCKED + " = 1 AND " + COLUMN_COMPLETED + " = 0" +
                " ORDER BY " + COLUMN_ID + " DESC LIMIT 1", null);

        String lessonTitle = null;
        if (cursor.moveToFirst()) {
            lessonTitle = cursor.getString(0);
        }
        cursor.close();
        return lessonTitle;
    }
}
