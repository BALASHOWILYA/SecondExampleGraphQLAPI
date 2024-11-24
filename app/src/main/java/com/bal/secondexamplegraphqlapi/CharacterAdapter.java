package com.bal.secondexamplegraphqlapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {
    private final Context context;
    private final List<GetChractersQuery.Result> characterList;


    public CharacterAdapter(Context context, List<GetCharatersQuery.Result> characterList) {
        this.context = context;
        this.characterList = characterList
    }




    @NonNull
    @Override
    public CharacterAdapter.CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterAdapter.CharacterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class  CharacterViewHolder extends RecyclerView.ViewHolder{

        TextView characterName, characterSpecies;
        ImageView characterImage;

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
            characterName = itemView.findViewById(R.id.characterName);
            characterSpecies = itemView.findViewById(R.id.characterSpecies);
            characterImage = itemView.findViewById(R.id.characterImage);
        }
    }
}
