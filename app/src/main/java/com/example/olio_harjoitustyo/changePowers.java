package com.example.olio_harjoitustyo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class changePowers extends AppCompatActivity{
    Storage storage = Storage.getInstance();
    TextView LutName, LutEXP, LutAttack, LutDefence;
    Lutemon lutemon = null;
    int id1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_powers);

        String id2 = getIntent().getStringExtra("LutemonID");
        id1 = Integer.parseInt(id2);

        lutemon = storage.getLutemon(id1);

        LutName = findViewById(R.id.LutName);
        LutEXP = findViewById(R.id.LutEXP);
        LutAttack = findViewById(R.id.LutAttack);
        LutDefence = findViewById(R.id.LutDefence);

        LutName.setText(lutemon.getName() + " (" + lutemon.getColour() + ")");
        LutEXP.setText("Kokemus: " + lutemon.getExperience());
        LutAttack.setText("Hyökkäys: " + lutemon.getAttack());
        LutDefence.setText("Puolustus: " + lutemon.getDefence());
    }

    public void doneButton (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void addAttack (View view) {
        //add attack attack and reduce exp
        storage.increaseAttack(id1);
        LutEXP.setText("Kokemus: " + lutemon.getExperience());
        LutAttack.setText("Hyökkäys: " + lutemon.getAttack());
    }

    public void addDefence (View view) {
        //add defence and reduce exp
        storage.increaseDefence(id1);
        LutEXP.setText("Kokemus: " + lutemon.getExperience());
        LutDefence.setText("Puolustus: " + lutemon.getDefence());
    }
}