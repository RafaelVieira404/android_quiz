package com.example.question_game;

import android.os.Parcel;
import android.os.Parcelable;

public class question_format implements Parcelable {
    private String question, a, b, c, d;
    private int answer;


    public question_format(String question, String a, String b, String c, String d, int answer) {
        this.question = question;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.answer = answer;
    }

    protected question_format(Parcel in) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<question_format> CREATOR = new Creator<question_format>() {
        @Override
        public question_format createFromParcel(Parcel in) {
            return new question_format(in);
        }

        @Override
        public question_format[] newArray(int size) {
            return new question_format[size];
        }
    };
}
