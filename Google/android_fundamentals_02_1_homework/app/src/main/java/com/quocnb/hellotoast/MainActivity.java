package com.quocnb.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.quocnb.hellotoast.EXTRA_MESSAGE";
    private int mCount = 0;
    private TextView tvShowCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvShowCount = findViewById(R.id.tv_show_count);
    }

    public void sayHello(View view) {
        Intent intent = new Intent(this, GreetingActivity.class);
        intent.putExtra(EXTRA_MESSAGE, tvShowCount.getText().toString());
        startActivity(intent);
    }

    public void countUp(View view) {
        mCount++;
        if (tvShowCount != null) {
            tvShowCount.setText(Integer.toString(mCount));
        }
    }
}