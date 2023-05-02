package com.example.olio_harjoitustyo.lutemonTypes;

import com.example.olio_harjoitustyo.Lutemon;
import com.example.olio_harjoitustyo.R;

public class Green extends Lutemon {
    int attack=6;
    int defence=3;
    private static final int MAXHEALTH=19;
    int health = MAXHEALTH;
    int getMaxhealth = MAXHEALTH;

    public Green(String name, String colour, int id, int attack, int defence, int health, int getMaxhealth) {
        super(name, colour, id, attack, defence, health, getMaxhealth);
        image = R.drawable.green_lutemon;
    }
}
