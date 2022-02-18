package com.quocnb.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.quocnb.scorekeeper.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String SCORE_KEY = "com.quocnb.scorekeeper.score";
    public Score score = new Score(0, 0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            score = savedInstanceState.getParcelable(SCORE_KEY);
        }
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setScore(score);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(SCORE_KEY, score);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.night_mode) {
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }
        return super.onOptionsItemSelected(item);
    }

    public void decreaseScore(View view) {
        int viewID = view.getId();
        switch (viewID){
            //If it was on Team 1
            case R.id.decreaseTeam1:
                //Decrement the score and update the TextView
                score.firstScore.set(score.firstScore.get() - 1);
                break;
            //If it was Team 2
            case R.id.decreaseTeam2:
                //Decrement the score and update the TextView
                score.secondScore.set(score.secondScore.get() - 1);
                break;
        }
    }

    public void increaseScore(View view) {
        int viewID = view.getId();
        switch (viewID){
            //If it was on Team 1
            case R.id.increaseTeam1:
                //Decrement the score and update the TextView
                score.firstScore.set(score.firstScore.get() + 1);
                break;
            //If it was Team 2
            case R.id.increaseTeam2:
                //Decrement the score and update the TextView
                score.secondScore.set(score.secondScore.get() + 1);
                break;
        }
    }
}