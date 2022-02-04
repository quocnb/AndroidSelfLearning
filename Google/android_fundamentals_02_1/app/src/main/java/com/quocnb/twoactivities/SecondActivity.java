package com.quocnb.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.quocnb.twoactivities.extra.REPLY";
    private EditText mReply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mReply = findViewById(R.id.editText_reply);

        String message = getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView tv = findViewById(R.id.text_message);
        tv.setText(message);
    }

    public void returnReply(View view) {
        String message = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, message);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}