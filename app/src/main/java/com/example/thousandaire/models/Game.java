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
        if (!isFinalQuestion()) {
            return mQuestions.get(mCurrentQuestionIndex + 1);
        }
        else {
            return null;
        }
    }

    public boolean isFinalQuestion() {
        if (mCurrentQuestionIndex == mQuestions.size() - 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public void proceedToNextQuestion() {
        if (mCurrentQuestionIndex < (mQuestions.size() - 1)) {
            mCurrentQuestionIndex = (mCurrentQuestionIndex + 1) % mQuestions.size();
        }
    }

}
