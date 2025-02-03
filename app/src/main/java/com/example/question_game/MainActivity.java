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
    private int[] question_num = new int[5];
    private int question_count = 0;
    private int correct_answer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        for (int num = 0; num < 5; num++){
            question_num[num] = new Random().nextInt(5);
        }

        for (int count = 0; count < 5; count++){
            for (int a = count + 1; a < 5; a++){
                if (question_num[count] == question_num[a]){
                    question_num[count] = new Random().nextInt(20);
                    a = count;
                }
            }
        }


        Button start_button = findViewById(R.id.start_button);
        start_button.setOnClickListener(View ->{
                Intent intent = new Intent(this, GameActivity.class)
                        .putExtra(GameActivity.EXTRA_QUESTION_INDEX, question_num)
                        .putExtra(GameActivity.EXTRA_QUESTION_COUNT, question_count)
                        .putExtra(GameActivity.EXTRA_CORRECT_ANSWER, correct_answer);
                startActivity(intent);
            Toast.makeText(this, "start game", Toast.LENGTH_SHORT).show();

        });


    }
}