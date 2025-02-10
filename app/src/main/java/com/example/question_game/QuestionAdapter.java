package com.example.question_game;

import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
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
        TextView txt_user;
//        TextView txt_congrats;
//        TextView txt_count;
        RelativeLayout question_backGround;
        TextView question_answer1;
        TextView question_answer2;
        TextView question_answer3;
        TextView question_answer4;
        TextView user_answer;
        ImageView checkbox;


        public QuestionAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_user = itemView.findViewById(R.id.question_endGame);
//            txt_congrats = itemView.findViewById(R.id.text_congrats);
//            txt_count = itemView.findViewById(R.id.count_num);
            question_backGround = itemView.findViewById(R.id.question_format_display);
            question_answer1 = itemView.findViewById(R.id.question_answer1);
            question_answer2 = itemView.findViewById(R.id.question_answer2);
            question_answer3 = itemView.findViewById(R.id.question_answer3);
            question_answer4 = itemView.findViewById(R.id.question_answer4);
            user_answer = itemView.findViewById(R.id.user_answer);
            checkbox = itemView.findViewById(R.id.checkbox);
        }

        public void bind(QuestionFormat question) {
            int hash = question.getUserCorrect().hashCode();
            txt_user.setText(question.getQuestion());
            question_answer1.setText(question.getA());
            question_answer2.setText(question.getB());
            question_answer3.setText(question.getC());
            question_answer4.setText(question.getD());

            checkbox.setBackground(oval(Color.WHITE, checkbox));

            final boolean isCorrectAnswer = question.getUserCorrect().booleanValue();
            checkbox.setBackground(oval(isCorrectAnswer ? Color.GREEN : Color.RED, checkbox));
            user_answer.setText("Answer: " + question.getUserAnswer());

            checkbox.setImageResource(question.getUserCorrect() ? R.drawable.baseline_check_24 : R.drawable.outline_close_24);
        }

        private ShapeDrawable oval(@ColorInt int color, View view) {
            ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
            shapeDrawable.setIntrinsicHeight(view.getHeight());
            shapeDrawable.setIntrinsicWidth(view.getWidth());
            shapeDrawable.getPaint().setColor(color);
            return shapeDrawable;
        }

    }
}


