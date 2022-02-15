package com.quocnb.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent intent = getIntent();
        TextView tv = findViewById(R.id.order_textview);
        tv.setText(intent.getStringExtra(MainActivity.EXTRA_MESSAGE));
        Spinner spinner = findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.labels_array, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource
                    (android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
        EditText phoneEditText = findViewById(R.id.phone_text);
        if (phoneEditText != null) {
            phoneEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (i != EditorInfo.IME_ACTION_SEND) {
                        return false;
                    }
                    dialNumber();
                    return false;
                }
            });
        }
    }

    private void dialNumber() {
        // Find the editText_main view.
        EditText phoneText = findViewById(R.id.phone_text);
        if (phoneText == null) {
            return;
        }
        String phoneNum = "tel:" + phoneText.getText().toString();

        Intent intent = new Intent(Intent.ACTION_DIAL);

        // Set the data for the intent as the phone number.
        intent.setData(Uri.parse(phoneNum));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton)view).isChecked();
        if (!checked) {
            return;
        }
        switch (view.getId()) {
            case R.id.sameday:
                displayToast(getString(R.string.same_day_radio));
                break;
            case R.id.nextday:
                displayToast(getString(R.string.next_day_delivery));
                break;
            case R.id.pickup:
                displayToast(getString(R.string.pick_up_delivery));
                break;
            default:
                // Do nothing
                break;
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}