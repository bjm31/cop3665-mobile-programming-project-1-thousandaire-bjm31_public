package com.example.thousandaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.thousandaire.R;

public class ProceedActivity extends AppCompatActivity {

    TextView mCorrectTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceed);

        mCorrectTextView = (TextView) findViewById(R.id.correct_text_view);
    }
}
