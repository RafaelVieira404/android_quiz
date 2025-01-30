package com.example.question_game;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class QuestionAnswers implements Parcelable{
        private static final QuestionAnswers instance = new QuestionAnswers();
        private List<QuestionFormat> questionFormatList;

        public QuestionAnswers() {
            questionFormatList = new ArrayList<>();

            questionFormatList.add(new QuestionFormat("Qual é o nome do ator que interpreta o pai de Sheldon, George Cooper Sr.?", "Lance Barber", "Jerry O'Connell", "Brian Posehn", "Keith Ferguson", 1));
            questionFormatList.add(new QuestionFormat("Quando Penny e Leonard se casam, onde é realizada a cerimônia?", "Em Las Vegas", "Em um hotel em Pasadena", "No apartamento de Sheldon", "Na casa de Amy", 2));
            questionFormatList.add(new QuestionFormat("Qual é o nome da irmã de Sheldon?", "Missy Cooper", "Jenny Cooper", "Sarah Cooper", "Lucy Cooper", 3));
            questionFormatList.add(new QuestionFormat("O que Howard fez para ganhar seu primeiro \"bilhete\" para o espaço?", "Enviou um e-mail para a NASA", "Fez um projeto de engenharia para a NASA", "Fui voluntário para uma missão em Marte", "Ingressou em um curso avançado de astrofísica", 6));
            questionFormatList.add(new QuestionFormat("Qual é o nome do personagem que trabalha como gerente de loja de quadrinhos e tem uma paixão por Raj?", "Stuart Bloom", "Barry Kripke", "Wil Wheaton", "Howard Wolowitz", 4));
            questionFormatList.add(new QuestionFormat("Qual era o nome do namorado da Penny, antes de Leonard?", "Zack", "Kurt", "Todd", "Josh", 5));
        }

        public static QuestionAnswers getInstance() {
            return instance;
        }

        protected QuestionAnswers(Parcel in) {
            questionFormatList = in.createTypedArrayList((Creator<QuestionFormat>) questionFormatList);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(@NonNull Parcel dest, int flags) {
            dest.writeTypedList(questionFormatList);

        }

    public static final Creator<QuestionAnswers> CREATOR = new Creator<QuestionAnswers>() {
        @Override
        public QuestionAnswers createFromParcel(Parcel in) {
            return new QuestionAnswers(in);
        }

        @Override
        public QuestionAnswers[] newArray(int size) {
            return new QuestionAnswers[size];
        }
    };

    public QuestionFormat getQuestion(int aux) {
        return questionFormatList.get(aux);
    }
}


