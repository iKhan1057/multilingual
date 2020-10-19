package com.countrytour;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProfileDataAdapter extends RecyclerView.Adapter<ProfileDataAdapter.ViewHolder> {
    private List<ProfileModel> models;
    private ProfileActivity activity;

    public ProfileDataAdapter(List<ProfileModel> models, ProfileActivity activity) {
        this.models = models;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_profile_data, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txt_tagname.setText(models.get(position).getTagName());
        holder.txt_tagvalue.setText(models.get(position).getTagValue());
    }

    @Override
    public int getItemCount() {
        return models != null ? models.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_tagname, txt_tagvalue;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_tagname = itemView.findViewById(R.id.txt_tagname);
            txt_tagvalue = itemView.findViewById(R.id.txt_tagvalue);
        }
    }
}
