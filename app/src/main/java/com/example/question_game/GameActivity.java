package com.example.question_game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class GameActivity extends AppCompatActivity {

    public static final String EXTRA_QUESTION_INDEX = "EXTRA_QUESTION_INDEX";
    public static final String EXTRA_QUESTION_COUNT = "EXTRA_QUESTION_COUNT";
    public static final String EXTRA_CORRECT_ANSWER = "EXTRA_CORRECT_ANSWER";
    public static final String EXTRA_USER_ANSWER = "EXTRA_USER_ANSWER";
    public static final int REQUEST_CODE_NEXT_QUESTION = 42;

    private static final String[] user_answer = new String[5];
    private static int[] question_num = new int[5];

    private QuestionFormat currentQuestions;
    private int question_count;
    private int correctAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        setResult(Activity.RESULT_CANCELED);

        Intent intent = getIntent();
        question_num = intent.getIntArrayExtra(EXTRA_QUESTION_INDEX);
        question_count = intent.getIntExtra(EXTRA_QUESTION_COUNT, -1);
        correctAnswer = intent.getIntExtra(EXTRA_CORRECT_ANSWER, 0);
        currentQuestions = QuestionAnswers.getInstance().getQuestion(question_num[question_count]);

        setup();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_NEXT_QUESTION && resultCode == Activity.RESULT_CANCELED) {
            if (data == null) return;
            question_num = data.getIntArrayExtra(EXTRA_QUESTION_INDEX);
            question_count = data.getIntExtra(EXTRA_QUESTION_COUNT, -1);
            correctAnswer = data.getIntExtra(EXTRA_CORRECT_ANSWER, 0);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        navigateToPreviousQuestion();
    }

    private void setup() {

        RadioButton button1 = findViewById(R.id.button_one_answer);
        RadioButton button2 = findViewById(R.id.button_two_answer);
        RadioButton button3 = findViewById(R.id.button_three_answer);
        RadioButton button4 = findViewById(R.id.button_four_answer);
        Button next_question = findViewById(R.id.next_question);
        Button back_question = findViewById(R.id.back_question);

        button1.setText(currentQuestions.getA());
        button2.setText(currentQuestions.getB());
        button3.setText(currentQuestions.getC());
        button4.setText(currentQuestions.getD());

        TextView question_screen = findViewById(R.id.question_text);
        question_screen.setText(currentQuestions.getQuestion());
        next_question.setOnClickListener(View -> {
            if (!answerValidation()) return;

            if (question_count >= question_num.length) {
                navigateToEndGameActivity();
                return;
            }
            nextQuestion();
        });
        back_question.setOnClickListener(v -> navigateToPreviousQuestion());

    }

    private boolean answerValidation() {
        RadioGroup radioGroup = findViewById(R.id.answers);
        final int selectedButton = radioGroup.getCheckedRadioButtonId();
        switch (selectedButton) {
            case R.id.button_one_answer:
                if (currentQuestions.getAnswerForComparison() == 1) correctAnswer += 1;
                user_answer[question_count] += 1;
                break;
            case R.id.button_two_answer:
                if (currentQuestions.getAnswerForComparison() == 2) correctAnswer += 1;
                user_answer[question_count] += 2;
                break;
            case R.id.button_three_answer:
                if (currentQuestions.getAnswerForComparison() == 3) correctAnswer += 1;
                user_answer[question_count] += 3;
                break;
            case R.id.button_four_answer:
                if (currentQuestions.getAnswerForComparison() == 4) correctAnswer += 1;
                user_answer[question_count] += 4;
                break;
            default:
                return false;
        }

        question_count += 1;
        return true;
    }

    private void nextQuestion() {
        Intent next_q = new Intent(getApplicationContext(), GameActivity.class)
                .putExtra(GameActivity.EXTRA_QUESTION_INDEX, question_num)
                .putExtra(GameActivity.EXTRA_USER_ANSWER, user_answer)
                .putExtra(GameActivity.EXTRA_CORRECT_ANSWER, correctAnswer)
                .putExtra(GameActivity.EXTRA_QUESTION_COUNT, question_count);
        startActivityForResult(next_q, REQUEST_CODE_NEXT_QUESTION);
    }

    private void navigateToEndGameActivity() {
        Intent intent = new Intent(getApplicationContext(), EndGame.class)
                .putExtra(GameActivity.EXTRA_USER_ANSWER, user_answer)
                .putExtra(GameActivity.EXTRA_CORRECT_ANSWER, correctAnswer)
                .putExtra(GameActivity.EXTRA_QUESTION_INDEX, question_num);
        startActivity(intent);
    }

    private void navigateToPreviousQuestion() {
        if (correctAnswer != 0) correctAnswer -= 1;
        question_count -= 1;
        setResult(Activity.RESULT_CANCELED, new Intent()
                .putExtra(GameActivity.EXTRA_CORRECT_ANSWER, correctAnswer)
                .putExtra(GameActivity.EXTRA_QUESTION_INDEX, question_num)
                .putExtra(GameActivity.EXTRA_QUESTION_COUNT, question_count)
        );
        super.onBackPressed();
    }
}
