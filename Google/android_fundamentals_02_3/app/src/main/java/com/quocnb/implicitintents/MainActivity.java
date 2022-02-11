package com.quocnb.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openWebsite(View view) {
        EditText etWebsite = findViewById(R.id.website_edittext);
        String uri = etWebsite.getText().toString();

        Uri webpage = Uri.parse(uri);
        Intent intent = new Intent(Intent.ACTION_VIEW).setData(webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void openLocation(View view) {
        EditText etLocation = findViewById(R.id.location_edittext);
        String loc = etLocation.getText().toString();

        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        startActivity(intent);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void shareText(View view) {
        EditText etShare = findViewById(R.id.share_edittext);
        String txt = etShare.getText().toString();
        String mimeType = "text/plain";
        new ShareCompat.IntentBuilder(this)
                .setType(mimeType)
                .setChooserTitle(R.string.edittext_share)
                .setText(txt)
                .startChooser();
    }
}