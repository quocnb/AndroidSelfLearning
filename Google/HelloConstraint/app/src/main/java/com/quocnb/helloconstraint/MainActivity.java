package com.quocnb.helloconstraint;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;

    private void setCount(int count) {
        mCount = count;
        TextView tvShowCount = findViewById(R.id.tv_show_count);
        Button btnCount = findViewById(R.id.button_count);
        Button btnZero = findViewById(R.id.button_zero);;

        if (tvShowCount != null) {
            tvShowCount.setText(Integer.toString(mCount));
        }
        // Update Count Button background
        if (btnCount != null) {
            btnCount.setBackgroundColor(mCount % 2 == 0 ? Color.BLUE : Color.MAGENTA);
        }
        // Update count button background
        if (btnZero != null) {
            btnZero.setBackgroundColor(mCount == 0 ? Color.GRAY : Color.BLUE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setCount(0);
    }

    public void showToast(View view) {
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT)
                .show();
    }

    public void countUp(View view) {
        setCount(mCount + 1);
    }

    public void reset(View view) {
        setCount(0);
    }
}