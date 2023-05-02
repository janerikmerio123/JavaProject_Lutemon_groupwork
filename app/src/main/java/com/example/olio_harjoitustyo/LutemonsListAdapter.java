package com.example.olio_harjoitustyo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonsListAdapter extends RecyclerView.Adapter<LutemonsViewHolder>{
    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public LutemonsListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public LutemonsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonsViewHolder(LayoutInflater.from(context).inflate(R.layout.list_lutemons_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonsViewHolder holder, int position) {
        holder.txtName.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getColour() + ")");
        holder.txtAttack.setText("Hyökkäys: " + lutemons.get(position).getAttack());
        holder.txtDefence.setText("Puolustus: " + lutemons.get(position).getDefence());
        holder.txtLife.setText("Elämä: " + lutemons.get(position).getHealth() + "/" + lutemons.get(position).getMaxHealht());
        holder.txtEXP.setText("Kokemus: " + lutemons.get(position).getExperience());
        holder.txtWins.setText("Voitot: " + lutemons.get(position).getNumberOfVictories());
        holder.txtDefeats.setText("Häviöt: " + lutemons.get(position).getNumberOfDefeats());
        holder.txtFights.setText("Taistelut: " + lutemons.get(position).getBattles());
        holder.txtTrainDays.setText("Treenipäivät: " + lutemons.get(position).getNumberOfTrainingDays());
        holder.lutemonImage.setImageResource(lutemons.get(position).getImage());
        //holder.cbLutemonFighter.setText(lutemons.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
