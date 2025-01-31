package com.example.question_game;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EndGame extends AppCompatActivity {

    public static final String userAnswer = "user_answer";
    private static String[] user_answer = new String[5];
    public static final String correct_answers = "correctAnswers";
    private static int correctAnswers;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_game);

        Intent intent = getIntent();
        user_answer = intent.getStringArrayExtra(userAnswer);
        correctAnswers = intent.getIntExtra(correct_answers, 0);

        TextView text = findViewById(R.id.teste);
        TextView text2 = findViewById(R.id.teste_2);
        TextView text3 = findViewById(R.id.teste_3);
        TextView text4 = findViewById(R.id.teste_4);
        TextView text5 = findViewById(R.id.teste_5);

        text.setText(user_answer[0]);
        text2.setText(user_answer[1]);
        text3.setText(user_answer[2]);
        text4.setText(user_answer[3]);
        text5.setText(user_answer[4]);


    }
}
