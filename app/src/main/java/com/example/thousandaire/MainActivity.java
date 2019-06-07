package com.example.thousandaire;

import android.app.Activity;
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
    private int question;
    private int choices[];
    private int answer;
    private int mCurrentScore;
    private int mNextScore;
    private boolean mIsGoOn;

    private static final int REQUEST_CODE_GO_ON = 0;

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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == REQUEST_CODE_GO_ON) {
            if (data == null) {
                return;
            }
            mGame.proceedToNextQuestion();
            updateQuestion();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createGame();

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

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



    private void updateQuestion() {
        choices = mGame.getCurrentQuestion().getChoiceIds();
        answer = mGame.getCurrentQuestion().getAnswer();
        question = mGame.getCurrentQuestion().getTextResId();

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
                Intent i = ProceedActivity.newIntent(MainActivity.this, mCurrentScore, mNextScore);
                startActivityForResult(i, REQUEST_CODE_GO_ON);
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
