package com.example.thousandaire;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    private int mTotalScore = 0;

    private static final String EXTRA_TOTAL_SCORE = "total_score";

    public static Intent newIntent(Context packageContext, int totalScore) {
        Intent intent = new Intent(packageContext, ScoreActivity.class);
        intent.putExtra(EXTRA_TOTAL_SCORE, totalScore);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        mTotalScore = getIntent().getIntExtra(EXTRA_TOTAL_SCORE, 0);

        String mScoreText = "Congratulations! You earned $ " + mTotalScore + ".";
        TextView mScoreTextView = (TextView) findViewById(R.id.score_text_view);
        mScoreTextView.setText(mScoreText);
    }
}
