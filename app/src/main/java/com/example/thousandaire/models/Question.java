package com.example.thousandaire.models;

public class Question {

    private int mTextResId;
    private int mAnswer;
    private int[] mChoiceIds;
    private int mAmount;

    public Question(int questionTextId, int answerId, int[] choiceIds, int amount) {

        this.mTextResId = questionTextId;
        this.mAnswer = answerId;
        this.mChoiceIds = choiceIds;
        this.mAmount = amount;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public int getAnswer() {
        return mAnswer;
    }

    public int[] getChoiceIds() {
        return mChoiceIds;
    }

    public int getAmount() {
        return mAmount;
    }
}
