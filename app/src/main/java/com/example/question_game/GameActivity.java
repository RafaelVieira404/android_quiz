package com.example.question_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);

        RadioGroup radio_group = findViewById(R.id.answers);
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton button = (RadioButton) radio_group.findViewById(checkedId);
                String resposta = button.getText().toString();
            }
        });

        RadioButton button1 = findViewById(R.id.button_one_answer);
        button1.setText("aa");


        Button next_q = findViewById(R.id.next_question);
        next_q.setOnClickListener(View ->{
            Intent next_question = new Intent(this, GameActivity.class);
            startActivity(next_question, savedInstanceState);

        });

        TextView question_screen = findViewById(R.id.question_text);
        question_screen.setText();
    }

    ArrayList<String> words_array = new ArrayList<>();

}

