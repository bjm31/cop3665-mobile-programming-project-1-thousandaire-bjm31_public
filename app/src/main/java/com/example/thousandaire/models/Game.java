package com.example.thousandaire.models;

import java.util.ArrayList;

public class Game {

    private ArrayList<Question> mQuestions;
    private int mCurrentQuestionIndex;

    public Game() {
        mQuestions = new ArrayList<>();
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
            int nextIndex = mCurrentQuestionIndex + 1;
            return mQuestions.get(nextIndex);
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
            ++mCurrentQuestionIndex;
        }
    }

}
