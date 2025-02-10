package com.example.question_game;

import static com.example.question_game.GameActivity.EXTRA_QUESTION_INDEX;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EndGame extends AppCompatActivity {

    private static QuestionFormat quizQuestions;
    private final ArrayList<QuestionFormat> questionQuiz = new ArrayList<>();

    private int userCorrectAnswerCount;
    private static int[] questionNum = new int[5];
    private QuestionAdapter questionAdapter;

    public static Intent createIntentToEndGame(Context context, int correctAnswer, int[] question_num) {
        return new Intent(context, EndGame.class)
                .putExtra(GameActivity.EXTRA_CORRECT_ANSWER, correctAnswer)
                .putExtra(GameActivity.EXTRA_QUESTION_INDEX, question_num);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_game);

        Intent intent = getIntent();
        questionNum = intent.getIntArrayExtra(EXTRA_QUESTION_INDEX);

        findViewById(R.id.float_button_endGame).setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                setReturnButton();
            }
        });

        getQuestionsSetup();
        getCorrectAnswerCount();
        countSetup();
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

    public void getQuestionsSetup() {
        for (int i = 0; i < 10; i += 1) {
            quizQuestions = QuestionAnswers.getInstance().getQuestion(questionNum[i]);
            questionQuiz.add(quizQuestions);
        }

    }

    public void getCorrectAnswerCount() {
        for (int i = 0; i < 10; i += 1) {
            if (QuestionAnswers.getInstance().getQuestion(questionNum[i]).getUserCorrect().equals(true))
                userCorrectAnswerCount += 1;
        }
    }

    public void countSetup() {
        TextView screen = findViewById(R.id.count_num);
        screen.setText(userCorrectAnswerCount + "/" + questionQuiz.size());
    }

    public void setReturnButton(){
            Intent home_button = new Intent(this, MainActivity.class);
            startActivity(home_button);
            finishAffinity();
    }
}

