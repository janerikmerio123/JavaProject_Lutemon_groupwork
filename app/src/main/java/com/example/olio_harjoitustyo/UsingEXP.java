package com.example.olio_harjoitustyo;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class UsingEXP extends AppCompatActivity {
    private Storage storage = Storage.getInstance();

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_using_exp);
        makeRadioButtons();

    }

    public void contButton (View view) {
        //getID

        RadioGroup useExpRG = findViewById(R.id.useExpRG);
        Lutemon oneLutemon = storage.getLutemon(useExpRG.getCheckedRadioButtonId());
        int id = useExpRG.getCheckedRadioButtonId();
        String id2 = String.valueOf(id);
        System.out.println(id + "-----------------");

        Intent intent = new Intent(this, changePowers.class);
        intent.putExtra("LutemonID", id2);
        startActivity(intent);
    }

    public void makeRadioButtons() {
        RadioGroup useExpRG = findViewById(R.id.useExpRG);
        ArrayList<Lutemon> lutemons = storage.getLutemons();
        RadioButton radioButton;

        int i = 0;

        for (Lutemon lut : lutemons) {
            radioButton = new RadioButton(this);
            radioButton.setText(lut.getName() + " (" + lut.getColour() + ")");
            radioButton.setId(i);
            useExpRG.addView(radioButton);
            i++;
        }
    }
}