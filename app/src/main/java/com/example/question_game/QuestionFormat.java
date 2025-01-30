package com.example.question_game;

import android.os.Parcel;
import android.os.Parcelable;

public class QuestionFormat implements Parcelable {
    private final String question, a, b, c, d;
    private final int answer;


    public QuestionFormat(String question, String a, String b, String c, String d, int answer) {
        this.question = question;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.answer = answer;
    }

    protected QuestionFormat(Parcel in) {
        question = in.readString();
        a = in.readString();
        b = in.readString();
        c = in.readString();
        d = in.readString();
        answer = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeString(a);
        dest.writeString(b);
        dest.writeString(c);
        dest.writeString(d);
        dest.writeInt(answer);
    }

    public String getQuestion(){
        return question;
    }
    public String getA(){
        return a;
    }
    public String getB(){
        return b;
    }
    public String getC(){
        return c;
    }
    public String getD(){
        return d;
    }
    public int getAnswer(){
        return answer;
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
