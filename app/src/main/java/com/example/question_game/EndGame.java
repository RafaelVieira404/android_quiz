package com.example.question_game;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EndGame extends AppCompatActivity {

    private static String[] user_answer = new String[5];
    private static int correctAnswers;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_game);

        Intent intent = getIntent();
        user_answer = intent.getStringArrayExtra(GameActivity.EXTRA_USER_ANSWER);
        correctAnswers = intent.getIntExtra(GameActivity.EXTRA_CORRECT_ANSWER, -1);

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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent Home = new Intent(this, MainActivity.class);
        startActivity(Home);
        finishAffinity();
    }
}
