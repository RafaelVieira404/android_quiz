package com.example.question_game;

public class RecyclerViewList {
    private String Questions;
    private String UserAnswer;
    private String QuestionsAnswer;

    public String getQuestions() {
        return Questions;
    }

    public void setQuestions(String questions) {
        Questions = questions;
    }

    public String getUserAnswer() {
        return UserAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        UserAnswer = userAnswer;
    }

    public String getQuestionsAnswer() {
        return QuestionsAnswer;
    }

    public void setQuestionsAnswer(String questionsAnswer) {
        QuestionsAnswer = questionsAnswer;
    }

    public static class QuestionBuilder {
        private String Questions;
        private String UserAnswer;
        private String QuestionsAnswer;

        private QuestionBuilder() {}

        public QuestionBuilder setQuestions(String questions) {
            Questions = questions;
            return this;
        }

        public QuestionBuilder setUserAnswer(String userAnswer) {
            UserAnswer = userAnswer;
            return this;
        }

        public QuestionBuilder setQuestionsAnswer(String questionsAnswer) {
            QuestionsAnswer = questionsAnswer;
            return this;
        }

        public static QuestionBuilder builder() {
            return new QuestionBuilder();
        }

        public

    }

}
