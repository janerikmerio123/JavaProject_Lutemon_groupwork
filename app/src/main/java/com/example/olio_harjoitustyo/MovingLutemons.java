package com.example.olio_harjoitustyo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.olio_harjoitustyo.fragments.FightFragment;
import com.example.olio_harjoitustyo.fragments.HomeFragment;
import com.example.olio_harjoitustyo.fragments.TrainingFragment;

public class MovingLutemons extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moving_lutemons);
        Button homeButton = findViewById(R.id.homeButton);
        Button trainingButton = findViewById(R.id.trainingButton);
        Button fightingButton = findViewById(R.id.fightingButton);

        homeButton.setOnClickListener(listener);
        trainingButton.setOnClickListener(listener);
        fightingButton.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment;

            switch (view.getId()){
                case R.id.homeButton:
                    fragment = new HomeFragment();
                    break;
                case R.id.trainingButton:
                    fragment = new TrainingFragment();
                    break;
                case R.id.fightingButton:
                    fragment = new FightFragment();
                    break;
                default:
                    fragment = new HomeFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame, fragment)
                    .commit();
        }
    };
}