package com.example.olio_harjoitustyo;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Storage implements Serializable {
    protected String name;
    final private String filename = "lutemons.data";
    private ArrayList<Lutemon> lutemons = new ArrayList<>();
    private static Storage storage = null;



    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public int getNumberOfCreatedLutemons(){
        int i = 0;
        for (Lutemon lutemon : lutemons) {
            i++;
        }
        return i;
    }

    public void addLutemon(Lutemon lutemon){
        lutemons.add(lutemon);
    }

    public Lutemon getLutemon(int id){
        int i = 0;
        for (Lutemon lutemon : lutemons) {
            if(i == id) {
                return lutemon;
            }
            i++;
        }
        return null;
    }

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }

    public void listLutemons(){
        System.out.println("Listataan lutemonit");
        for (Lutemon lutemon : lutemons) {
            System.out.println(lutemon.getId() + " : " + lutemon.getName());
        }
    }

    public void increaseAttack(int id){
        int i = 0;
        for (Lutemon lutemon : lutemons) {
            if(i == id) {
                lutemon.improveAttack();
            }
            i++;
        }
    }

    public void increaseDefence(int id){
        int i = 0;
        for (Lutemon lutemon : lutemons) {
            if(i == id) {
                lutemon.improveDefence();
            }
            i++;
        }
    }

    public void saveData(Context context) {
        try {
            ObjectOutputStream lutemonWrite = new ObjectOutputStream(context.openFileOutput(filename, Context.MODE_PRIVATE));
            lutemonWrite.writeObject(lutemons);
            lutemonWrite.flush();
            lutemonWrite.close();
            System.out.println("Tallentaminen onnistui");
        } catch (IOException e) {
            System.out.println("Tiedoston tallentaminen epäonnistui.");
            e.printStackTrace();
        }
    }

    public void loadData(Context context) {
        try {
            ObjectInputStream lutemonRead = new ObjectInputStream(context.openFileInput(filename));
            lutemons = (ArrayList<Lutemon>) lutemonRead.readObject();
            lutemonRead.close();
            System.out.println("Lukeminen onnistui");
        } catch (FileNotFoundException e) {
            System.out.println("Tiedoston lukeminen epäonnistui. Tiedostoa ei löytynyt\"");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Tiedoston lukeminen epäonnistui.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Tiedoston lukeminen epäonnistui.");

        }
    }
}

