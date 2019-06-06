package com.example.thousandaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thousandaire.models.Game;
import com.example.thousandaire.models.Question;

public class MainActivity extends AppCompatActivity {

    Game game = new Game();
    TextView mQuestionTextView;
    Button choice_one_button;
    Button choice_two_button;
    Button choice_three_button;
    Button choice_four_button;
    int choices[];
    int answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game.AddQuestion(new Question(R.string.question_mickey, R.string.choice_pluto,
                new int[]{R.string.choice_pluto, R.string.choice_goofy, R.string.choice_minnie, R.string.choice_daisy},
                100));
        game.AddQuestion(new Question(R.string.question_planets, R.string.choice_jupiter,
                new int[]{R.string.choice_earth, R.string.choice_mars, R.string.choice_jupiter, R.string.choice_venus},
                200));
        game.AddQuestion(new Question(R.string.question_gilligan, R.string.choice_seven,
                new int[]{R.string.choice_two, R.string.choice_six, R.string.choice_seven, R.string.choice_eight},
                300));
        game.AddQuestion(new Question(R.string.question_elements, R.string.choice_e,
                new int[]{R.string.choice_tc, R.string.choice_o, R.string.choice_fe, R.string.choice_e},
                400));
        game.AddQuestion(new Question(R.string.question_valletta, R.string.choice_malta,
                new int[]{R.string.choice_croatia, R.string.choice_latvia, R.string.choice_estonia, R.string.choice_malta},
                500));
        game.AddQuestion(new Question(R.string.question_distance, R.string.choice_oneHundred,
                new int[]{R.string.choice_one, R.string.choice_ten, R.string.choice_oneHundred, R.string.choice_twoHundred},
                1000));

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        choices = game.getCurrentQuestion().getChoiceIds();
        answer = game.getCurrentQuestion().getAnswer();

        choice_one_button = (Button) findViewById(R.id.choice_one_button);
        choice_one_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                checkAnswer(choices[0] == answer);
            }
        });
        choice_two_button = (Button) findViewById(R.id.choice_two_button);
        choice_two_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                checkAnswer(choices[1] == answer);
            }
        });
        choice_three_button = (Button) findViewById(R.id.choice_three_button);
        choice_three_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                checkAnswer(choices[2] == answer);
            }
        });
        choice_four_button = (Button) findViewById(R.id.choice_four_button);
        choice_four_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                checkAnswer(choices[3] == answer);
            }
        });

        //game.getNextQuestion();
        updateQuestion();
    }

    //class example
    private void updateQuestion() {
        int question = game.getCurrentQuestion().getTextResId();
        mQuestionTextView.setText(question);
        choice_one_button.setText(choices[0]);
        choice_two_button.setText(choices[1]);
        choice_three_button.setText(choices[2]);
        choice_four_button.setText(choices[3]);
    }

    private void checkAnswer(boolean userPressed) {
        //boolean answer = mQuestionBank[mCurrentIndex].isAnswerTrue();

        int answerResId = 0;
        if (userPressed == true) {
            answerResId = R.string.correct_toast;
        } else {
            answerResId = R.string.incorrect_toast;
        }
        Toast.makeText(MainActivity.this, answerResId, Toast.LENGTH_SHORT).show();
    }
    //end class example
}
