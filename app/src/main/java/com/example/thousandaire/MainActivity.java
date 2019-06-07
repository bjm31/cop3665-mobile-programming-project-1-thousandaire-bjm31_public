package com.example.thousandaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thousandaire.models.Game;
import com.example.thousandaire.models.Question;

public class MainActivity extends AppCompatActivity {

    private Game mGame;
    private TextView mQuestionTextView;
    private Button mChoiceOneButton;
    private Button mChoiceTwoButton;
    private Button mChoiceThreeButton;
    private Button mChoiceFourButton;
    private int choices[];
    private int answer;
    private int mCurrentScore;
    private int mNextScore;

    private static final String TAG = "MainActivity";
    private static final String KEY_INDEX = "index";
    private static final String KEY_CURRENT_SCORE = "current_score";
    private static final String KEY_NEXT_SCORE = "next_score";
    private static final String KEY_TOTAL_SCORE = "total_score";

    private void createGame() {
        mGame = new Game();
        mGame.AddQuestion(new Question(R.string.question_mickey, R.string.choice_pluto,
                new int[]{R.string.choice_pluto, R.string.choice_goofy, R.string.choice_minnie, R.string.choice_daisy},
                100));
        mGame.AddQuestion(new Question(R.string.question_planets, R.string.choice_jupiter,
                new int[]{R.string.choice_earth, R.string.choice_mars, R.string.choice_jupiter, R.string.choice_venus},
                200));
        mGame.AddQuestion(new Question(R.string.question_gilligan, R.string.choice_seven,
                new int[]{R.string.choice_two, R.string.choice_six, R.string.choice_seven, R.string.choice_eight},
                300));
        mGame.AddQuestion(new Question(R.string.question_elements, R.string.choice_e,
                new int[]{R.string.choice_tc, R.string.choice_o, R.string.choice_fe, R.string.choice_e},
                400));
        mGame.AddQuestion(new Question(R.string.question_valletta, R.string.choice_malta,
                new int[]{R.string.choice_croatia, R.string.choice_latvia, R.string.choice_estonia, R.string.choice_malta},
                500));
        mGame.AddQuestion(new Question(R.string.question_distance, R.string.choice_oneHundred,
                new int[]{R.string.choice_one, R.string.choice_ten, R.string.choice_oneHundred, R.string.choice_twoHundred},
                1000));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            //mTotalScore = savedInstanceState.getInt(KEY_TOTAL_SCORE, 0);
        }
        else {
            createGame();
        }

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        choices = mGame.getCurrentQuestion().getChoiceIds();
        answer = mGame.getCurrentQuestion().getAnswer();

        mChoiceOneButton = (Button) findViewById(R.id.choice_one_button);
        mChoiceOneButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                checkAnswer(choices[0] == answer);
            }
        });
        mChoiceTwoButton = (Button) findViewById(R.id.choice_two_button);
        mChoiceTwoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                checkAnswer(choices[1] == answer);
            }
        });
        mChoiceThreeButton = (Button) findViewById(R.id.choice_three_button);
        mChoiceThreeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                checkAnswer(choices[2] == answer);
            }
        });
        mChoiceFourButton = (Button) findViewById(R.id.choice_four_button);
        mChoiceFourButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                checkAnswer(choices[3] == answer);
            }
        });

        updateQuestion();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        //savedInstanceState.putInt(KEY_TOTAL_SCORE, mTotalScore);
    }

    private void updateQuestion() {
        int question = mGame.getCurrentQuestion().getTextResId();
        mQuestionTextView.setText(question);
        mChoiceOneButton.setText(choices[0]);
        mChoiceTwoButton.setText(choices[1]);
        mChoiceThreeButton.setText(choices[2]);
        mChoiceFourButton.setText(choices[3]);
    }

    private void checkAnswer(boolean userPressed) {
        mCurrentScore = mGame.getCurrentQuestion().getAmount();
        if (userPressed) {
            if (!mGame.isFinalQuestion()) {
                mNextScore = mGame.getNextQuestion().getAmount();
                mGame.proceedToNextQuestion();
                updateQuestion();
                Intent i = ProceedActivity.newIntent(MainActivity.this, mCurrentScore, mNextScore);
                startActivity(i);
            }
            else {
                Intent i = ScoreActivity.newIntent(MainActivity.this, mCurrentScore);;
                startActivity(i);
            }
        }
        else {
            Intent i = new Intent(MainActivity.this, GameOverActivity.class);
            startActivity(i);
        }
    }
}
