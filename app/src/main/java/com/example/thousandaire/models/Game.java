package com.example.thousandaire.models;

import java.util.ArrayList;

public class Game {

    private ArrayList<Question> mQuestions;
    private int mCurrentQuestionIndex;

    public Game() {
        mQuestions = new ArrayList<Question>();
        mCurrentQuestionIndex = 0;
    }

    public void AddQuestion(Question newQuestion) {
        mQuestions.add(newQuestion);
    }

    public Question getCurrentQuestion() {
        return mQuestions.get(mCurrentQuestionIndex);
    }

    public Question getNextQuestion() {
        return mQuestions.get(mCurrentQuestionIndex + 1);
    }

    public boolean isFinalQuestion() {
        return false;
    }

    public void proceedToNextQuestion() {
        if (mCurrentQuestionIndex < (mQuestions.size() - 1)) {
            mCurrentQuestionIndex = (mCurrentQuestionIndex + 1) % mQuestions.size();
        }
        else {

        }
    }

}
