package com.example.thousandaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameOverActivity extends AppCompatActivity {

    private Button mQuitGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        mQuitGameButton = (Button) findViewById(R.id.quit_game_button);
        mQuitGameButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}
