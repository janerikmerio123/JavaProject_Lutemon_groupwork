package com.example.olio_harjoitustyo.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.olio_harjoitustyo.Lutemon;
import com.example.olio_harjoitustyo.MainActivity;
import com.example.olio_harjoitustyo.MovingLutemons;
import com.example.olio_harjoitustyo.R;
import com.example.olio_harjoitustyo.Storage;
import com.example.olio_harjoitustyo.TrainingArea;

import java.util.ArrayList;
import java.util.List;

public class FightFragment extends Fragment {

    private Storage storage = Storage.getInstance();
    private CheckBox checkBox;
    private TrainingArea trainingArea = new TrainingArea();
    int i = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view1 = inflater.inflate(R.layout.fragment_fight, container, false);

        RadioGroup fightGroup = view1.findViewById(R.id.CBfight);
        ArrayList<Lutemon> lutemons = storage.getLutemons();

        List<CheckBox> cb = new ArrayList<CheckBox>();

        for (Lutemon lut : lutemons) {
            if (lut.getPlaceOfLutemon() == 2) {
                checkBox = new CheckBox(this.getContext());
                checkBox.setText(lut.getName());
                checkBox.setId(i);
                fightGroup.addView(checkBox);
                i++;
                cb.add(checkBox);
            }
        }

        Button button = (Button) view1.findViewById(R.id.moveChosen4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //place your action here
                RadioGroup radioGroupHome = view1.findViewById(R.id.radioGroupFight);

                int radioIdHome = radioGroupHome.getCheckedRadioButtonId();
                RadioButton radioButton = view1.findViewById(radioIdHome);
                String place = radioButton.getText().toString();

                if (place.equals("Treenaamaan")) {
                    for (CheckBox c : cb) {
                        if (c.isChecked()){
                            String checkBoxID = (String) c.getText();
                            for (Lutemon lut : storage.getLutemons()) {
                                if (lut.getName() == checkBoxID) {
                                    trainingArea.train(lut);
                                    lut.moveLutemonTrain();
                                }
                            }
                        }
                    }
                } else if (place.equals("Kotiin")) {
                    for (CheckBox c : cb) {
                        if (c.isChecked()){
                            String checkBoxID = (String) c.getText();
                            for (Lutemon lut : storage.getLutemons()) {
                                if (lut.getName() == checkBoxID) {
                                    lut.moveLutemonHome();
                                }
                            }
                        }
                    }
                }

                Intent intent = new Intent(view1.getContext(), MainActivity.class);
                startActivity(intent);

                System.out.println(place + "----------------------");
            }
        });

        return view1;
    }
}