package com.example.olio_harjoitustyo.lutemonTypes;

import com.example.olio_harjoitustyo.Lutemon;
import com.example.olio_harjoitustyo.R;

public class Orange extends Lutemon {
    int attack=8;
    int defence=1;
    private static final int MAXHEALTH=17;
    int health = MAXHEALTH;
    int getMaxhealth = MAXHEALTH;

    public Orange(String name, String colour, int id, int attack, int defence, int health, int getMaxhealth) {
        super(name, colour, id, attack, defence, health, getMaxhealth);
        image = R.drawable.orange_lutemon;
    }
}
