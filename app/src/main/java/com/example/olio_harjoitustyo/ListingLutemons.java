package com.example.olio_harjoitustyo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.olio_harjoitustyo.R;

public class ListingLutemons extends AppCompatActivity {

    private Storage storage;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing_lutemons);

        storage = Storage.getInstance();
        recyclerView = findViewById(R.id.listingRV);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonsListAdapter(getApplicationContext(), storage.getLutemons()));
        int i = 0;
        for(Lutemon lut : storage.getLutemons()) {
            System.out.println("lutemon : " + lut.getName() + " " + lut.getId()); //-------
            lut.setId(i);
            System.out.println("lutemon's new ID : " + lut.getName() + " " + lut.getId()); //-------
            i++;
        }
    }
}