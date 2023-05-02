package com.example.olio_harjoitustyo.lutemonTypes;

import com.example.olio_harjoitustyo.Lutemon;
import com.example.olio_harjoitustyo.R;

public class Pink extends Lutemon {
    int attack=7;
    int defence=2;
    private static final int MAXHEALTH=18;
    int health = MAXHEALTH;
    int getMaxhealth = MAXHEALTH;

    public Pink(String name, String colour, int id, int attack, int defence, int health, int getMaxhealth) {
        super(name, colour, id, attack, defence, health, getMaxhealth);
        image = R.drawable.pink_lutemon;
    }
}
