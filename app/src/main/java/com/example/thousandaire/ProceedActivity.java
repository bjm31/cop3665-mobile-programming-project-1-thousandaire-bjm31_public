package com.example.thousandaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.thousandaire.R;

public class ProceedActivity extends AppCompatActivity {

    private TextView mCorrectTextView;
    private int prevQScore = 0;
    private int nextQScore = 0;
    private int totalScore = 0;

    private Button mGoOnButton;
    private Button mQuitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceed);

        mCorrectTextView = (TextView) findViewById(R.id.correct_text_view);
        mCorrectTextView.setText("Correct! You have earned $" + prevQScore + ". Would you care to try for $" + nextQScore);

        mGoOnButton = (Button) findViewById(R.id.go_on_button);
        mGoOnButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProceedActivity.this, MainActivity.class);
                //game.proceedToNextQuestion();
                startActivity(i);
            }
        });

        mQuitButton = (Button) findViewById(R.id.quit_button);
        mQuitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProceedActivity.this, ScoreActivity.class);
                startActivity(i);
            }
        });
    }
}
