package com.example.thousandaire;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    private Button mPlayOverButton;
    private Button mQuitGameButton;
    private int mScore = 0;

    private static final String EXTRA_SCORE = "total_score";

    public static Intent newIntent(Context packageContext, int score) {
        Intent intent = new Intent(packageContext, ScoreActivity.class);
        intent.putExtra(EXTRA_SCORE, score);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        mScore = getIntent().getIntExtra(EXTRA_SCORE, 0);

        String mScoreText = "Congratulations! You earned $" + mScore + ".";
        TextView mScoreTextView = (TextView) findViewById(R.id.score_text_view);
        mScoreTextView.setText(mScoreText);

        mPlayOverButton = (Button) findViewById(R.id.play_over_button);
        mPlayOverButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ScoreActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        mQuitGameButton = (Button) findViewById(R.id.quit_game_button);
        mQuitGameButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
