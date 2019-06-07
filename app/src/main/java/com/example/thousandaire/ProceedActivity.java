package com.example.thousandaire;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.thousandaire.R;

public class ProceedActivity extends AppCompatActivity {

    private TextView mCorrectTextView;
    private int mCurrentScore = 0;
    private int mNextScore = 0;

    private Button mGoOnButton;
    private Button mQuitButton;

    private static final String EXTRA_CURRENT_SCORE = "current_score";
    private static final String EXTRA_NEXT_SCORE = "next_score";
    private static final String EXTRA_GO_ON = "go_on";

    public static Intent newIntent(Context packageContext, int currentScore, int nextScore) {
        Intent intent = new Intent(packageContext, ProceedActivity.class);
        intent.putExtra(EXTRA_CURRENT_SCORE, currentScore);
        intent.putExtra(EXTRA_NEXT_SCORE, nextScore);
        return intent;
    }

    public static boolean wasGoOn(Intent result) {
        return result.getBooleanExtra(EXTRA_GO_ON, false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceed);

        mCurrentScore = getIntent().getIntExtra(EXTRA_CURRENT_SCORE, 0);
        mNextScore = getIntent().getIntExtra(EXTRA_NEXT_SCORE, 0);

        String mCorrectText = "Correct! You have earned $" + mCurrentScore + ". Would you care " +
                                "to try for $" + mNextScore + "?";

        mCorrectTextView = (TextView) findViewById(R.id.correct_text_view);
        mCorrectTextView.setText(mCorrectText);

        mGoOnButton = (Button) findViewById(R.id.go_on_button);
        mGoOnButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setGoOnResult(true);
                finish();
            }
        });

        mQuitButton = (Button) findViewById(R.id.quit_button);
        mQuitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = ScoreActivity.newIntent(ProceedActivity.this, mCurrentScore);;
                startActivity(i);
            }
        });
    }

    private void setGoOnResult(boolean isGoOn) {
        Intent data = new Intent();
        data.putExtra(EXTRA_GO_ON, isGoOn);
        setResult(RESULT_OK, data);

    }
}
