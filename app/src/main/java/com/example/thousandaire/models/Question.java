package com.example.project1.models;

public class Question {

    private int mTextResId;
    private int mAnswer;
    private int[] mChoiceIds;
    private int mAmount;

    Question(int questionTextId, int answerId, int[] choiceIds, int amount) {

        this.mTextResId = questionTextId;
        this.mAnswer = answerId;
        this.mChoiceIds = choiceIds;
        this.mAmount = amount;
    }

    int getAmount() {

        return mAmount;
    }

    int getQuestionTextId() {

        return mTextResId;
    }

    int getAnswerId() {

        return mAnswer;
    }

    int[] getChoiceIds() {

        return mChoiceIds;
    }

}
