package com.example.question_game;

import static com.example.question_game.GameActivity.EXTRA_CORRECT_ANSWER;
import static com.example.question_game.GameActivity.EXTRA_QUESTION_INDEX;
import static com.example.question_game.GameActivity.EXTRA_USER_ANSWER;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class EndGame extends AppCompatActivity {

    private static int[] EXTRA_QUESTION_ANSWER = new int[5];
    private static String[] user_answer = new String[5];
    private static int correctAnswers;
    private QuestionFormat question;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_game);

        Intent intent = getIntent();
        user_answer = intent.getStringArrayExtra(EXTRA_USER_ANSWER);
        EXTRA_QUESTION_ANSWER = intent.getIntArrayExtra(EXTRA_QUESTION_INDEX);
        correctAnswers = intent.getIntExtra(EXTRA_CORRECT_ANSWER, 1);
        question = QuestionAnswers.getInstance().getQuestion(EXTRA_QUESTION_ANSWER[0]);



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent Home = new Intent(this, MainActivity.class);
        startActivity(Home);
        finishAffinity();
    }
}
