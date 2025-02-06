package com.example.question_game;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionAdapterViewHolder> {

    private final ArrayList<QuestionFormat> questionQuiz;

    public QuestionAdapter(ArrayList<QuestionFormat> questionQuiz) {
        this.questionQuiz = questionQuiz;
    }

    @NonNull
    @Override
    public QuestionAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.question_layout_endgame, parent, false);

        return new QuestionAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionAdapterViewHolder holder, int position) {
        QuestionFormat question = questionQuiz.get(position);
        holder.bind(question);
    }

    @Override
    public int getItemCount() {
        return questionQuiz.size();
    }

    class QuestionAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView txtUser;
        TextView question_answers;
        TextView user_answer;


        public QuestionAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            txtUser = itemView.findViewById(R.id.question_endGame);
            question_answers = itemView.findViewById(R.id.question_answers);
            user_answer = itemView.findViewById(R.id.user_answer);
        }

        public void bind(QuestionFormat question) {
            txtUser.setText(question.getQuestion());
            question_answers.setText(question.getAllAnswers());
            user_answer.setText(question.getUserAnswer());
        }
    }
}


