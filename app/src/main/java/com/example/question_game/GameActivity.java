package com.example.question_game;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);

       RadioButton answer_one = findViewById(R.id.button_one_answer);
       RadioButton answer_two = findViewById(R.id.button_two_answer);
       RadioButton answer_three = findViewById(R.id.button_three_answer);
       Button answer_four = findViewById(R.id.button_four_answer);


        answer_one.setOnClickListener(View -> Toast.makeText(this,"teste",Toast.LENGTH_SHORT).show());

    }

    @Override
    protected void onPause() {
        super.onPause();
        
    }
}
