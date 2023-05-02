package com.example.olio_harjoitustyo;
/*
Tekijät:
Päivämäärä 2.5.2023
Lutemon harkkatyö
Jan-Erik Meriö  0611777     jan-erik.merio@student.lut.fi
Alisa Lampela   0599417     alisa.lampela@student.lut.fi
 */


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Storage storage = Storage.getInstance();
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
    }

    public void goAddLutemons(View view) {
        Intent intent = new Intent(this, AddingLutemons.class);
        startActivity(intent);
    }

    public void goListLutemons(View view) {
        Intent intent = new Intent(this, ListingLutemons.class);
        startActivity(intent);
    }

    public void goMoveLutemons(View view) {
        Intent intent = new Intent(this, MovingLutemons.class);
        startActivity(intent);
    }

    public void goUseEXP(View view) {
        Intent intent = new Intent(this, UsingEXP.class);
        startActivity(intent);
    }

    public void goToFight(View view) {
        Intent intent = new Intent(this, FightingLutemons.class);
        startActivity(intent);
    }

    public void saveInformation(View view) {
        //save information to file
        Storage.getInstance().saveData(context);
    }

    public void loadInformation(View view) {
        //load information from file
        Storage.getInstance().loadData(context);
    }


}