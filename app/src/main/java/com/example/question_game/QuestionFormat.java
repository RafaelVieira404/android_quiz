package com.example.question_game;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

public class QuestionFormat implements Parcelable {
    private final String question;
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final int answerForComparison;
    private final String correctAnswer;
    private String userAnswer;
    private Boolean userCorrect;


    public QuestionFormat(String question, String a, String b, String c, String d, int answerForComparison, String userAnswer, Boolean userCorrect, String correctAnswer) {
        this.question = question;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.answerForComparison = answerForComparison;
        this.userAnswer = userAnswer;
        this.userCorrect = userCorrect;
        this.correctAnswer = correctAnswer;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    protected QuestionFormat(Parcel in) {
        question = in.readString();
        a = in.readString();
        b = in.readString();
        c = in.readString();
        d = in.readString();
        answerForComparison = in.readInt();
        userCorrect = in.readBoolean();
        correctAnswer = in.readString();

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeString(a);
        dest.writeString(b);
        dest.writeString(c);
        dest.writeString(d);
        dest.writeInt(answerForComparison);
    }

    public String getQuestion() {
        return question;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    public String getD() {
        return d;
    }

    public int getAnswerForComparison() {
        return answerForComparison;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public String getAllAnswers() {
        return getA() + "\n" + getB() + "\n" + getC() + "\n" + getD();
    }

    public String getCorrectAnswer() {
      return correctAnswer;
    }

    public Boolean getUserCorrect() {
        return userCorrect;
    }

    public void setUserCorrectQuestion(String userAnswer) {
        this.userAnswer = userAnswer;
    }
    public void setUserCorrect(Boolean userCorrect) {
        this.userCorrect = userCorrect;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<QuestionFormat> CREATOR = new Creator<QuestionFormat>() {
        @Override
        public QuestionFormat createFromParcel(Parcel in) {
            return new QuestionFormat(in);
        }

        @Override
        public QuestionFormat[] newArray(int size) {
            return new QuestionFormat[size];
        }
    };
}
