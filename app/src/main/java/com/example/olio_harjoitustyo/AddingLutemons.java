package com.example.olio_harjoitustyo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class AddingLutemons extends AppCompatActivity {
    private EditText giveName;
    private RadioButton radioButton;
    private RadioGroup radioGroup;
    private String colour;
    Lutemon lutemon = null;
    Home home = new Home();
    Storage storage = Storage.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_lutemons);
        giveName = findViewById(R.id.giveName);
        radioGroup = findViewById(R.id.radioGroup);
    }

    public void onClickAdd (View view) {
        //add all information
        String name = giveName.getText().toString();

        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        colour = radioButton.getText().toString();

        home.createLutemon(name, colour);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}