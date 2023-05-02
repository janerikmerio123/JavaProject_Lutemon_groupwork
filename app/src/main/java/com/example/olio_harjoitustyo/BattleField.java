package com.example.olio_harjoitustyo;

import java.lang.Math;

public class BattleField {

    public BattleField(Lutemon lute1, Lutemon lute2){

    }

    public int fightCalculatotion(int defence, int attack, int health) {
        int minus;
        int attackPower;
        attackPower = (int) (attack + (Math.random() * 3));
        minus = defence - attackPower;
        if (minus >= 0) {
            minus = 0;
        }
        health = health + minus;
        return health;

    }

    public String statsOfLutemons(String colour, String name, int attack, int defence, int experience, int health, int maxHealth) {
        String sentance = String.format("%s(%s) att: %d; def: %d; exp: %d; health: %d/%d", colour, name, attack, defence, experience, health, maxHealth);
        System.out.println(sentance);
        return sentance;
    }

    public String figthInfo(String colour1,String colour2, String name1, String name2) {
        String sentance = String.format("%s(%s) attacks %s(%s)", colour1, name1, colour2, name2);
        System.out.println(sentance);
        return sentance;
    }

    public String figthOutcome(String colour, String name, int health) {
        String sentance = "this is a test sentance here";
        if (health <= 0) {
            sentance = String.format("%s(%s) gets defeated", colour, name);
        }   else {
            sentance = String.format("%s(%s) manages to escape defeat.", colour, name);

        }
        System.out.println(sentance);
        return sentance;
    }


}
