package com.example.olio_harjoitustyo;

import java.io.Serializable;

public class Lutemon implements Serializable {
    protected String name, colour;
    protected int attack, defence, experience, health, maxHealht, id, numberOfVictories = 0, numberOfDefeats = 0, numberOfTrainingDays = 0, battles = 0, placeOfLutemon = 0;
    //placeOfLutemon: 0 = home, 1 = training, 2 = fighting;
    protected int image;

    public Lutemon(String name, String colour, int id, int attack, int defence, int health, int maxHealht) {
        this.name=name;
        this.colour=colour;
        this.id=id;
        this.attack=attack;
        this.defence=defence;
        this.health=health;
        this.maxHealht=maxHealht;
    }

    public String getName(){
        return name;
    }
    public String getColour(){
        return colour;}

    public  int getAttack(){return attack;}

    public  int getDefence(){return defence;}

    public  int getExperience(){return experience;}

    public void setExperience(){
        this.experience++;
    }

    public  int getHealth(){return health;}

    public void setHealth(int health) {
        this.health = health;
    }

    public void setId(int i) {
        this.id = i;
    }

    public int getMaxHealht(){return maxHealht;}

    public  int getId(){return id;}
    public int getImage() {
        return image;
    }

    public int getNumberOfVictories(){
        return numberOfVictories;
    }
    public int getNumberOfDefeats(){
        return numberOfDefeats;
    }
    public int getNumberOfTrainingDays(){
        return numberOfTrainingDays;
    }
    public int getPlaceOfLutemon() { return placeOfLutemon; }

    public int getBattles() {
        return battles;
    }

    public void improveAttack(){
        if (experience > 0){
            this.attack++;
            this.experience--;
        }
    }

    public void improveDefence(){
        if (experience > 0){
            this.defence++;
            this.experience--;
        }
    }

    public void battleOutcome(String outcome){
        this.battles++;
        if (outcome == "victory") {
            this.numberOfVictories++;
        }
        if (outcome == "defeat") {
            this.numberOfDefeats++;
        }
    }

    public void training() {
        this.numberOfTrainingDays++;
        this.experience++;
    }

    public void moveLutemonHome(){
        this.placeOfLutemon = 0;
        this.health = maxHealht;
    }

    public void moveLutemonTrain(){
        this.placeOfLutemon = 1;
    }

    public void moveLutemonFight(){
        this.placeOfLutemon = 2;
    }

}
