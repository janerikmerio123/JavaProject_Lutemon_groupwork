package com.example.olio_harjoitustyo.lutemonTypes;

import com.example.olio_harjoitustyo.Lutemon;
import com.example.olio_harjoitustyo.R;

public class Black extends Lutemon {
    int attack=9;
    int defence=0;
    private static final int MAXHEALTH = 16;
    int health = MAXHEALTH;
    int getMaxhealth = MAXHEALTH;

    public Black(String name, String colour,  int id, int attack, int defence, int health, int getMaxhealth) {
        super(name, colour, id, attack, defence, health, getMaxhealth);
        image = R.drawable.black_bird_1;
    }
}
