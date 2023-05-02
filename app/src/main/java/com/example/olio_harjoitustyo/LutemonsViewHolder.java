package com.example.olio_harjoitustyo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonsViewHolder extends RecyclerView.ViewHolder{

    ImageView lutemonImage;

    TextView txtName, txtAttack, txtDefence, txtLife, txtEXP, txtWins, txtDefeats, txtFights, txtTrainDays, cbLutemonFighter;

    public LutemonsViewHolder(@NonNull View itemView) {
        super(itemView);
        txtName = itemView.findViewById(R.id.txtName);
        txtAttack = itemView.findViewById(R.id.txtAttack);
        txtDefence = itemView.findViewById(R.id.txtDefence);
        txtLife = itemView.findViewById(R.id.txtLife);
        txtEXP = itemView.findViewById(R.id.txtEXP);
        txtWins = itemView.findViewById(R.id.txtWins);
        txtDefeats = itemView.findViewById(R.id.txtDefeats);
        txtFights = itemView.findViewById(R.id.txtFights);
        txtTrainDays = itemView.findViewById(R.id.txtTrainDays);
        lutemonImage = itemView.findViewById((R.id.ivLutemonImage));
    }
}
