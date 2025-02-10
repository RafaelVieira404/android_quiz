package com.example.question_game;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int[] questionNum = new int[10];
    private int questionCount = 0;
    private int correctAnswer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        for (int num = 0; num < 10; num++){
            questionNum[num] = new Random().nextInt(20);
        }

        for (int count = 0; count < 10; count++){
            for (int a = count + 1; a < 10; a++){
                if (questionNum[count] == questionNum[a]){
                    questionNum[count] = new Random().nextInt(20);
                    a = count;
                }
            }
        }


        Button start_button = findViewById(R.id.start_button);
        start_button.setOnClickListener(View ->{
                Intent intent = new Intent(this, GameActivity.class)
                        .putExtra(GameActivity.EXTRA_QUESTION_INDEX, questionNum)
                        .putExtra(GameActivity.EXTRA_QUESTION_COUNT, questionCount)
                        .putExtra(GameActivity.EXTRA_CORRECT_ANSWER, correctAnswer);
                startActivity(intent);
            Toast.makeText(this, "start game", Toast.LENGTH_SHORT).show();

        });


    }
}