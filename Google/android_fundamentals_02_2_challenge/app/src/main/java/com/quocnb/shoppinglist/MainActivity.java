package com.quocnb.shoppinglist;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String SHOPPING_LIST_KEY = "SHOPPING_LIST";
    private ArrayList<String> shoppingLists = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout rootView = findViewById(R.id.root_view);
        if (savedInstanceState != null) {
            shoppingLists = savedInstanceState.getStringArrayList(SHOPPING_LIST_KEY);
            for (int i = 0; i < shoppingLists.size(); i++) {
                rootView.addView(itemTextView(i, shoppingLists.get(i)));
            }
        }
        rootView.addView(addItemButton());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList(SHOPPING_LIST_KEY, shoppingLists);
    }

    private TextView itemTextView(int tvNo, String item) {
        TextView tv = new TextView(this);
        tv.setId(1000 + tvNo);
        tv.setPadding(16, 16, 16, 16);
        tv.setText(item);
        tv.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        return tv;
    }

    private Button addItemButton() {
        Button addItemButton = new Button(this);
        addItemButton.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        addItemButton.setText(R.string.add_item_button);
        addItemButton.setOnClickListener(this::addItem);
        return addItemButton;
    }

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() != Activity.RESULT_OK) {
                    return;
                }
                String item = result.getData().getStringExtra(AddItemActivity.EXTRA_REPLY);
                shoppingLists.add(item);
                LinearLayout rootView = findViewById(R.id.root_view);
                int newId = shoppingLists.size() - 1;
                TextView newTextView = itemTextView(newId, shoppingLists.get(newId));
                rootView.addView(newTextView, newId);
            }
    );

    public void addItem(View view) {
        Intent intent = new Intent(this, AddItemActivity.class);
        launcher.launch(intent);

    }
}