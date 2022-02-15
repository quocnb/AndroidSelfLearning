package com.quocnb.inputcontrolshomework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {
    ArrayList<CheckBox> checkBoxes = new ArrayList<>();
    int[] checkBoxContents = {R.string.checkbox_chocolate, R.string.checkbox_sprinkles, R.string.checkbox_nuts, R.string.checkbox_cherries, R.string.checkbox_cookie};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int content: checkBoxContents) {
            addCheckBox(content);
        }
        addButton();
    }

    private void addCheckBox(int titleId) {
        CheckBox cb = new CheckBox(this);
        cb.setText(titleId);
        LinearLayout rootView = findViewById(R.id.root_view);
        rootView.addView(cb);
        cb.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        checkBoxes.add(cb);
    }

    private void addButton() {
        Button showToastButton = new Button(this);
        showToastButton.setOnClickListener(this::clickedToastButton);
        LinearLayout rootView = findViewById(R.id.root_view);
        rootView.addView(showToastButton);
        showToastButton.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        showToastButton.setText(R.string.show_toast_button);
    }

    public void clickedToastButton(View view) {
        String[] selectedCheckBoxText = checkBoxes.stream()
                .filter(cb -> cb.isChecked())
                .map(cb -> cb.getText().toString())
                .toArray(String[]::new);
        String message = "Toppings:" + String.join(", ", selectedCheckBoxText);
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT)
                .show();
    }

}