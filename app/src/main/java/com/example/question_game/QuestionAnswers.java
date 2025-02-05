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

            questionFormatList.add(new QuestionFormat(
                    "Qual é o nome do ator que interpreta o pai de Sheldon, George Cooper Sr.?",
                    "Lance Barber",
                    "Jerry O'Connell",
                    "Brian Posehn",
                    "Keith Ferguson",
                    1,
                    "Lance Barber"));

            questionFormatList.add(new QuestionFormat(
                    "Quem é o melhor amigo de Leonard Hofstadter?",
                    "Raj Koothrappali",
                    "Sheldon Cooper",
                    "Howard Wolowitz",
                    "Penny",
                    2,
                    "Sheldon Cooper"));

            questionFormatList.add(new QuestionFormat(
                    "Qual é o nome da esposa de Howard Wolowitz?",
                    "Bernadette Rostenkowski",
                    "Amy Farrah Fowler",
                    "Penny",
                    "Sheldon Cooper",
                    1,
                    "Bernadette Rostenkowski"));

            questionFormatList.add(new QuestionFormat(
                    "Em qual cidade se passa a série?",
                    "Los Angeles",
                    "Chicago",
                    "Pasadena",
                    "New York",
                    3,
                    "Pasadena"));

            questionFormatList.add(new QuestionFormat(
                    "Qual é o nome da personagem interpretada por Kaley Cuoco?",
                    "Amy Farrah Fowler",
                    "Penny",
                    "Bernadette",
                    "Lucy",
                    2,
                    "Penny"));

            questionFormatList.add(new QuestionFormat(
                    "Qual é o nome do cientista que se especializa em física teórica?",
                    "Raj Koothrappali",
                    "Howard Wolowitz",
                    "Sheldon Cooper",
                    "Leonard Hofstadter",
                    3,
                    "Sheldon Cooper"));

            questionFormatList.add(new QuestionFormat(
                    "Quem foi a primeira mulher com quem Sheldon teve um relacionamento romântico?",
                    "Penny",
                    "Amy Farrah Fowler",
                    "Leslie Winkle",
                    "Priya Koothrappali",
                    2,
                    "Amy Farrah Fowler"));

            questionFormatList.add(new QuestionFormat(
                    "Qual é a profissão de Leonard Hofstadter?",
                    "Engenheiro Aeroespacial",
                    "Físico Experimental",
                    "Físico Teórico",
                    "Cientista de Computação",
                    2,
                    "Físico Experimental"));

            questionFormatList.add(new QuestionFormat(
                    "Qual é o nome do pai de Penny?",
                    "George",
                    "Wyatt",
                    "Bob",
                    "Larry",
                    2,
                    "Wyatt"));

            questionFormatList.add(new QuestionFormat(
                    "Quem é o personagem que sempre diz: 'Bazinga!'?",
                    "Sheldon Cooper",
                    "Raj Koothrappali",
                    "Howard Wolowitz",
                    "Leonard Hofstadter",
                    1,
                    "Sheldon Cooper"));

            questionFormatList.add(new QuestionFormat(
                    "Qual é a profissão de Raj Koothrappali?",
                    "Astrofísico",
                    "Engenheiro",
                    "Biotecnólogo",
                    "Químico",
                    1,
                    "Astrofísico"));

            questionFormatList.add(new QuestionFormat(
                    "Qual é o nome do jogo favorito de Sheldon?",
                    "World of Warcraft",
                    "Halo",
                    "Age of Conan",
                    "Counter-Strike",
                    1,
                    "World of Warcraft"));

            questionFormatList.add(new QuestionFormat(
                    "Qual é o nome da mãe de Sheldon Cooper?",
                    "Mary Cooper",
                    "Sheila Cooper",
                    "Elizabeth Cooper",
                    "Janet Cooper",
                    1,
                    "Mary Cooper"));

            questionFormatList.add(new QuestionFormat(
                    "Em qual estação espacial Howard trabalha?",
                    "Estação Espacial Internacional",
                    "Estação Espacial Americana",
                    "Estação Espacial Russa",
                    "Estação Espacial Lunar",
                    1,
                    "Estação Espacial Internacional"));

            questionFormatList.add(new QuestionFormat(
                    "Quem foi a primeira pessoa a beijar Sheldon Cooper?",
                    "Penny",
                    "Amy Farrah Fowler",
                    "Leslie Winkle",
                    "Mandy Chow",
                    3,
                    "Leslie Winkle"));

            questionFormatList.add(new QuestionFormat(
                    "Qual é o nome do amigo fictício de Raj?",
                    "Carl",
                    "Kumar",
                    "Tom",
                    "Dave",
                    2,
                    "Kumar"));

            questionFormatList.add(new QuestionFormat(
                    "Qual é o nome do restaurante onde os personagens costumam se reunir?",
                    "Central Perk",
                    "The Cheesecake Factory",
                    "MacLaren's",
                    "The Big Bang Diner",
                    2,
                    "The Cheesecake Factory"));

            questionFormatList.add(new QuestionFormat(
                    "Em que ano foi transmitido o primeiro episódio de *The Big Bang Theory*?",
                    "2005",
                    "2006",
                    "2007",
                    "2008",
                    3,
                    "2007"));

            questionFormatList.add(new QuestionFormat(
                    "Qual é o nome da esposa de Sheldon?",
                    "Penny",
                    "Amy Farrah Fowler",
                    "Leslie Winkle",
                    "Bernadette",
                    2,
                    "Amy Farrah Fowler"));

            questionFormatList.add(new QuestionFormat(
                    "Qual é o nome do amigo que vive com seu pai e mora em Caltech?",
                    "Raj",
                    "Howard",
                    "Leonard",
                    "Sheldon",
                    4,
                    "Sheldon"));

            questionFormatList.add(new QuestionFormat(
                    "Quem foi o primeiro namorado de Penny?",
                    "Leonard Hofstadter",
                    "Kurt",
                    "Mike",
                    "Zack",
                    2,
                    "Kurt"));


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


