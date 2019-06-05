package com.example.project1.models;

import java.util.ArrayList;

public class Game {

    private ArrayList<Question> mQuestions;
    private int mCurrentQuestionIndex;

    Game() {

        mCurrentQuestionIndex = 0;
    }

    void AddQuestion(Question newQuestion) {

        mQuestions.add(newQuestion);
    }

    Question getCurrentQuestion() {

        return mQuestions.at(mCurrentQuestionIndex);
    }

    Question getNextQuestion() {

        return mQuestion.at(mCurrentQuestionIndex + 1);
    }

    boolean isFinalQuestion() {

        return false;
    }

    void proceedToNextQuestion() {

        ++mCurrentQuestionIndex;
    }

}
