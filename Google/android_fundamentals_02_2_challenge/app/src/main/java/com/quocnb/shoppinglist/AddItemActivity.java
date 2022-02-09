package com.quocnb.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class AddItemActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.quocnb.shoppinglist.EXTRA_MESSAGE";
    String[] items = {"Cheese", "Rice", "Apples", "Grape"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        LinearLayout rootView = findViewById(R.id.add_item_root_view);
        for (String item: items) {
            Button newButton = itemButton(item);
            rootView.addView(newButton);
        }
    }

    private Button itemButton(String title) {
        Button bt = new Button(this);
        bt.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        bt.setPadding(16, 8, 16, 8);
        bt.setText(title);
        bt.setOnClickListener(this::ChooseItem);
        return bt;
    }

    public void ChooseItem(View view) {
        Button bt = (Button)view;
        String message = bt.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(EXTRA_REPLY, message);
        setResult(RESULT_OK, intent);
        finish();
    }
}