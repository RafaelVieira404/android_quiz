package com.example.question_game;

import android.os.Parcel;
import android.os.Parcelable;

public class QuestionFormat implements Parcelable {
    private final String question;
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final int answerForComparison;
    private final String answerInString;
    private String userAnswer;


    public QuestionFormat(String question, String a, String b, String c, String d, int answerForComparison, String answerInString, String userAnswer) {
        this.question = question;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.answerForComparison = answerForComparison;
        this.answerInString = answerInString;
        this.userAnswer = userAnswer;
    }

    protected QuestionFormat(Parcel in) {
        question = in.readString();
        a = in.readString();
        b = in.readString();
        c = in.readString();
        d = in.readString();
        answerForComparison = in.readInt();
        answerInString = in.readString();
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
        return "A) " + a;
    }

    public String getB() {
        return "B) " + b;
    }

    public String getC() {
        return "C) " + c;
    }

    public String getD() {
        return "D) " + d;
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

    public void setCorrectQuestion(String userAnswer) {
        this.userAnswer = userAnswer;
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
