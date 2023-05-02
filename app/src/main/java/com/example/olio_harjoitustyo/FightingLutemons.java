package com.example.olio_harjoitustyo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.ArrayList;


public class FightingLutemons extends AppCompatActivity {

    private Storage storage = Storage.getInstance();
    private RecyclerView recyclerView;
    private CheckBox checkBox;
    private int i = 0;
    private int typeOfFighter = 0;
    private int idAtt = 0, idDef = 0, id1, id2;
    int newHealth;
    ArrayList<Lutemon> lutemons = storage.getLutemons();
    String s1, s2, s3, s4, s5, s6, s7, s8, stringText = "--------------------THE BATTLE--------------------";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fighting_lutemons);

        //-----------------------------
        RadioGroup fightlistgroup = findViewById(R.id.CBfighterlist);
        makeRadioButtons();

    }

    public  void chooseAttacker(View view) {
        RadioGroup fightlistgroup = findViewById(R.id.CBfighterlist);

        id1 = fightlistgroup.getCheckedRadioButtonId();
        System.out.println("attacker id1 on : " + id1);
        int j=0;
        for (Lutemon lutemon : storage.getLutemons()) {
            System.out.println("attacker id1 on : " + id1);
            System.out.println("attacker j on : " + j);
            if (lutemon.getPlaceOfLutemon() == 2) {
                if (j == id1) {
                    idAtt = lutemon.getId();
                    System.out.println("attacker ID on : " + idAtt);
                }
                j++;
            }
        }
    }
    public  void chooseDefender(View view) {
        RadioGroup fightlistgroup = findViewById(R.id.CBfighterlist);

        id2 = fightlistgroup.getCheckedRadioButtonId();
        System.out.println("defender id2 on : " + id2);
        int j=0;
        for (Lutemon lutemon : storage.getLutemons()) {
            System.out.println("defender id2 on : " + id2);
            System.out.println("defender j on : " + j);
            if (lutemon.getPlaceOfLutemon() == 2) {
                if (j == id2) {
                    idDef = lutemon.getId();
                    System.out.println("attacker ID on : " + idDef);
                }
                j++;
            }
        }

    }

    public void makeRadioButtons() {
        RadioGroup battleRG = findViewById(R.id.CBfighterlist);
        ArrayList<Lutemon> lutemons = storage.getLutemons();
        RadioButton radioButton;

        int i = 0;

        for (Lutemon lut : lutemons) {
            if (lut.getPlaceOfLutemon() == 2) {
                radioButton = new RadioButton(this);
                radioButton.setText(lut.getName() + " (" + lut.getColour() + ")");
                radioButton.setId(i);
                battleRG.addView(radioButton);
                i++;
            }
        }
    }



    public void fight(View view) {

        Lutemon attacker = lutemons.get(idAtt);
        Lutemon defender = lutemons.get(idDef);

        BattleField battleField = new BattleField(attacker, defender);
        int situation = 1;
        while(situation != 0){
            if (situation == 1) {
                s1=battleField.statsOfLutemons(attacker.getColour(), attacker.getName(), attacker.getAttack(), attacker.getDefence(), attacker.getExperience(), attacker.getHealth(), attacker.getMaxHealht());
                s2=battleField.statsOfLutemons(defender.getColour(), defender.getName(), defender.getAttack(), defender.getDefence(), defender.getExperience(), defender.getHealth(), defender.getMaxHealht());
                newHealth = battleField.fightCalculatotion(defender.getDefence(), attacker.getAttack(), defender.getHealth()); // fighting
                defender.setHealth(newHealth);
                s3=battleField.figthInfo(attacker.getColour(), defender.getColour(),attacker.getName(), defender.getName());
                s4=battleField.figthOutcome(defender.getColour(), defender.getName(),defender.getHealth());
                if (defender.getHealth() <= 0) {
                    situation = 0;
                    attacker.battleOutcome("victory");
                    attacker.setExperience();
                    defender.battleOutcome("defeat");
                } else {
                    situation = 2;
                }
            }
            stringText = stringText + "\n" + s1 + "\n" + s2 + "\n" + s3 + "\n" + s4 + "\n"; //builds the printable text

            if (situation == 2) {
                s5=battleField.statsOfLutemons(defender.getColour(), defender.getName(), defender.getAttack(), defender.getDefence(), defender.getExperience(), defender.getHealth(), defender.getMaxHealht());
                s6=battleField.statsOfLutemons(attacker.getColour(), attacker.getName(), attacker.getAttack(), attacker.getDefence(), attacker.getExperience(), attacker.getHealth(), attacker.getMaxHealht());
                newHealth = battleField.fightCalculatotion(defender.getDefence(), attacker.getAttack(), defender.getHealth()); // fighting
                attacker.setHealth(newHealth);
                s7=battleField.figthInfo(defender.getColour(), attacker.getColour(),defender.getName(), attacker.getName());
                s8=battleField.figthOutcome(attacker.getColour(), attacker.getName(), attacker.getHealth());
                if (attacker.getHealth() <= 0) {
                    situation = 0;
                    defender.battleOutcome("victory");
                    defender.setExperience();
                    attacker.battleOutcome("defeat");
                } else {
                    situation = 1;
                }
            }
            stringText = stringText + "\n" + s5 + "\n" + s6 + "\n" + s7 + "\n" + s8 + "\n"; //builds the printable text

        }

        stringText = stringText + "\n" +"The battle is over.";

        //restoring health to maximum
        attacker.setHealth(attacker.getMaxHealht());
        defender.setHealth(defender.getMaxHealht());

        Intent intent = new Intent(this, FightInfoPrinter.class);
        String idOfString = String.valueOf(stringText);
        intent.putExtra("BattleSimulation", idOfString);
        startActivity(intent);

    }
}