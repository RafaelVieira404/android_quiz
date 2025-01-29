package com.example.question_game;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class question_answers {
    public static class Main implements Parcelable {
        private static final question_answers instance = new question_answers();
        private List<question_format> questionFormatList;

        public Main(List<question_format> questionFormatList) {
            this.questionFormatList = questionFormatList;
        }

        public void main_questions() {
            questionFormatList = new ArrayList <> ();

            questionFormatList.add(new question_format("Qual é o nome do ator que interpreta o pai de Sheldon, George Cooper Sr.?", "Lance Barber", "Jerry O'Connell", "Brian Posehn", "Keith Ferguson", 1));
            questionFormatList.add(new question_format("Quando Penny e Leonard se casam, onde é realizada a cerimônia?", "Em Las Vegas", "Em um hotel em Pasadena", "No apartamento de Sheldon", "Na casa de Amy", 2));
            questionFormatList.add(new question_format("Qual é o nome da irmã de Sheldon?", "Missy Cooper", "Jenny Cooper", "Sarah Cooper", "Lucy Cooper", 3));
            questionFormatList.add(new question_format("O que Howard fez para ganhar seu primeiro \"bilhete\" para o espaço?", "Enviou um e-mail para a NASA", "Fez um projeto de engenharia para a NASA", "Fui voluntário para uma missão em Marte", "Ingressou em um curso avançado de astrofísica", 6));
            questionFormatList.add(new question_format("Qual é o nome do personagem que trabalha como gerente de loja de quadrinhos e tem uma paixão por Raj?", "Stuart Bloom", "Barry Kripke", "Wil Wheaton", "Howard Wolowitz", 4));
            questionFormatList.add(new question_format("Qual era o nome do namorado da Penny, antes de Leonard?", "Zack", "Kurt", "Todd", "Josh", 5));
        }

        public static question_answers getInstance() {
            return instance;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(@NonNull Parcel dest, int flags) {

        }
    }
}


