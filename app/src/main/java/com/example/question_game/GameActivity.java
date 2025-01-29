package com.example.question_game;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity {

    public static final String extra_question_index_num = "question_num";
    public static final String extra_question_counter = "question_count";
    private static final String current_question = "current_question";
    private static final String[] user_answer = new String[5];
    private static int [] question_num = new int[5];
    private int question_count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);

        Intent intent = getIntent();
        question_num = intent.getIntArrayExtra(extra_question_index_num);
        question_count = intent.getIntExtra(extra_question_counter, -1);
        setup();



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(),GameActivity.class);

    }

    private void setup(){

        RadioGroup radio_group = findViewById(R.id.answers);
        RadioButton button1 = findViewById(R.id.button_one_answer);
        RadioButton button2 = findViewById(R.id.button_two_answer);
        RadioButton button3 = findViewById(R.id.button_three_answer);
        RadioButton button4 = findViewById(R.id.button_four_answer);
        Button next_question = findViewById(R.id.next_question);

        button1.setOnClickListener(View ->{
            user_answer[question_count] = "a";
        });
        next_question.setOnClickListener(View ->{
            if (user_answer[question_count] != null){
                question_count += 1;
                Intent next_q = new Intent(getApplicationContext(), GameActivity.class)
                        .putExtra(GameActivity.extra_question_index_num, question_num)
                        .putExtra(GameActivity.extra_question_counter, question_count);

                startActivity(next_q);
            } else {
                Toast.makeText(this,"Please sign one answer",Toast.LENGTH_SHORT).show();
            }


        });

        TextView question_screen = findViewById(R.id.question_text);
        question_screen.setText("aaa");
    }
}

