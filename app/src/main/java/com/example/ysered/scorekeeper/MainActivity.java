package com.example.ysered.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int score1 = 0;
    private int score2 = 0;
    private TextView scoreText1;
    private TextView scoreText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreText1 = findViewById(R.id.scoreTeam1);
        scoreText2 = findViewById(R.id.scoreTeam2);

        findViewById(R.id.increaseTeam1).setOnClickListener(this);
        findViewById(R.id.increaseTeam2).setOnClickListener(this);
        findViewById(R.id.decreaseTeam1).setOnClickListener(this);
        findViewById(R.id.decreaseTeam2).setOnClickListener(this);

        updateScoreForTeam1(score1);
        updateScoreForTeam2(score2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.decreaseTeam1:
                updateScoreForTeam1(--score1);
                break;

            case R.id.increaseTeam1:
                updateScoreForTeam1(++score1);
                break;

            case R.id.decreaseTeam2:
                updateScoreForTeam2(--score2);
                break;

            case R.id.increaseTeam2:
                updateScoreForTeam2(++score2);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem item = menu.findItem(R.id.itemThemeMode);
        if (isNightModeOn()) {
            item.setTitle(R.string.day_mode);
        } else {
            item.setTitle(R.string.night_mode);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.itemThemeMode) {
            if (isNightModeOn()) {
                item.setTitle(R.string.day_mode);
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                item.setTitle(R.string.night_mode);
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean isNightModeOn() {
        return AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES;
    }

    private void updateScoreForTeam1(int score) {
        score1 = score <= 0 ? 0 : score;
        scoreText1.setText(String.valueOf(score1));
    }

    private void updateScoreForTeam2(int score) {
        score2 = score <= 0 ? 0 : score;
        scoreText2.setText(String.valueOf(score2));
    }
}
