package com.quocnb.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class GreetingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);
        TextView greetingTextView = findViewById(R.id.greeting_textview);
        String count = getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE);
        greetingTextView.setText("Hello!\n" + count);
    }
}