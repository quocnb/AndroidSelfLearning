package com.quocnb.counterhomework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String COUNTER_KEY = "counter_key";
    private static final String MESSAGE_KEY = "message_key";
    private int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            setCounter(savedInstanceState.getInt(COUNTER_KEY));
            setMessage(savedInstanceState.getString(MESSAGE_KEY));
        } else {
            setCounter(0);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNTER_KEY, counter);
        EditText messageEt = findViewById(R.id.message_edit_text);
        outState.putString(MESSAGE_KEY, messageEt.getText().toString());
    }

    private void setCounter(int count) {
        counter = count;
        TextView counterTv = findViewById(R.id.counter_textview);
        counterTv.setText(String.format("%d", count));
    }

    private void setMessage(String message) {
        EditText messageEt = findViewById(R.id.message_edit_text);
        messageEt.setText(message);
    }

    public void countButtonOnClick(View view) {
        setCounter(counter + 1);
    }
}