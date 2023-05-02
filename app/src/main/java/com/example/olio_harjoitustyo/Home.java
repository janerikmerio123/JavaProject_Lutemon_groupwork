package com.example.olio_harjoitustyo;

import com.example.olio_harjoitustyo.lutemonTypes.Black;
import com.example.olio_harjoitustyo.lutemonTypes.Green;
import com.example.olio_harjoitustyo.lutemonTypes.Orange;
import com.example.olio_harjoitustyo.lutemonTypes.Pink;
import com.example.olio_harjoitustyo.lutemonTypes.White;

import java.io.Serializable;
import java.util.Objects;

public class Home implements Serializable {

    Storage storage = Storage.getInstance();

    protected int idCreator = 0;

    public void createLutemon(String name, String colour){
        if (Objects.equals(colour, "Black")) {
            storage.addLutemon(new Black(name, colour, idCreator, 9, 0, 16, 16));
            this.idCreator++;
        }
        if (Objects.equals(colour, "Green")) {
            storage.addLutemon(new Green(name, colour, idCreator, 6,3,19,19));
            this.idCreator++;
        }
        if (Objects.equals(colour, "Orange")) {
            storage.addLutemon(new Orange(name, colour, idCreator,8,1,17,17));
            this.idCreator++;
        }
        if (Objects.equals(colour, "Pink")) {
            storage.addLutemon(new Pink(name, colour, idCreator,7,2,18,18));
            this.idCreator++;
        }
        if (Objects.equals(colour, "White")) {
            storage.addLutemon(new White(name, colour, idCreator,5,4,20,20));
            this.idCreator++;
        }
    }
}


