package com.quocnb.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent intent = getIntent();
        TextView tv = findViewById(R.id.order_textview);
        tv.setText(intent.getStringExtra(MainActivity.EXTRA_MESSAGE));
    }
}