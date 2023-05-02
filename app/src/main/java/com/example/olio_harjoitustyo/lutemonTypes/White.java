package com.example.olio_harjoitustyo.lutemonTypes;

import com.example.olio_harjoitustyo.Lutemon;
import com.example.olio_harjoitustyo.R;

public class White extends Lutemon {
    int attack=5;
    int defence=4;
    private static final int MAXHEALTH=20;
    int heatlth = MAXHEALTH;
    int getMaxhealth = MAXHEALTH;

    public White(String name, String colour, int id, int attack, int defence, int health, int getMaxhealth) {
        super(name, colour, id, attack, defence, health, getMaxhealth);
        image = R.drawable.white_lutemon;
    }
}
