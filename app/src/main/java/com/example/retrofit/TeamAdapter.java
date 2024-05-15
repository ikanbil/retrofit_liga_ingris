package com.example.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retrofit.R;
import com.example.retrofit.Team;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {
    private List<Team> teams;

    public TeamAdapter(List<Team> teams) {
        this.teams = teams;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Team team = teams.get(position);
        holder.txtTeamName.setText(team.getStrTeam());
        Glide.with(holder.itemView.getContext())
                .load(team.getStrTeamBadge())
                .into(holder.ivLogo);
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTeamName;
        ImageView ivLogo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTeamName = itemView.findViewById(R.id.tvName);
            ivLogo = itemView.findViewById(R.id.ivLogo);
        }
    }
}
