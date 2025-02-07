package com.example.question_game;

import static com.example.question_game.GameActivity.EXTRA_CORRECT_ANSWER;
import static com.example.question_game.GameActivity.EXTRA_QUESTION_INDEX;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EndGame extends AppCompatActivity {

    private static QuestionFormat quizQuestions;
    private final ArrayList<QuestionFormat> questionQuiz = new ArrayList<>();

    private String userCorrectAnswerCount;
    private static int[] questionNum = new int[5];
    private QuestionAdapter questionAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_game);

        Intent intent = getIntent();
        questionNum = intent.getIntArrayExtra(EXTRA_QUESTION_INDEX);
        userCorrectAnswerCount = intent.getStringExtra(EXTRA_CORRECT_ANSWER);
        getQuestionsSetup();

        RecyclerSetup();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent Home = new Intent(this, MainActivity.class);
        startActivity(Home);
        finishAffinity();
    }

    public void RecyclerSetup() {

        questionAdapter = new QuestionAdapter(questionQuiz);
        RecyclerView rv = findViewById(R.id.recycle_view_endGame);
        rv.setAdapter(questionAdapter);
    }

    public void getQuestionsSetup(){
        for (int i = 0; i < 5; i += 1) {
            quizQuestions = QuestionAnswers.getInstance().getQuestion(questionNum[i]);
            questionQuiz.add(quizQuestions);
        }

        Intent intent = getIntent();
        intent = new Intent(this,QuestionAdapter.class);
    }

}

