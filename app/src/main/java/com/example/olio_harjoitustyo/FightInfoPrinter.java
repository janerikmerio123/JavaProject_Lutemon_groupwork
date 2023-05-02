package com.example.olio_harjoitustyo;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FightInfoPrinter extends AppCompatActivity{
    TextView textOutput;
    String battelSimulationText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fight_view);

        battelSimulationText = "";

        textOutput =findViewById(R.id.txtBattleInfoView);

        String nameOfText = getIntent().getStringExtra("BattleSimulation");
        battelSimulationText = String.valueOf(nameOfText);
        textOutput.setText(battelSimulationText);
    }
}
