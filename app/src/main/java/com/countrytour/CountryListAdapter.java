package com.countrytour;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Locale;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.ViewHolder> {
    private CountryListActivity countryListActivity;
    private List<CountryListModel> countryListModelList;
    private Locale myLocale;

    public CountryListAdapter(CountryListActivity countryListActivity, List<CountryListModel> countryListModelList) {
        this.countryListActivity = countryListActivity;
        this.countryListModelList = countryListModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_countrylist, parent, false);
        return new CountryListAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(countryListActivity).load(countryListModelList.get(position).getCountryflag()).into(holder.img_country);
        holder.txt_country_name.setText(countryListModelList.get(position).getCountryname());
        holder.lin_parent_countrylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = LocaleHelper.setLocale(countryListActivity, countryListModelList.get(position).getCountrylocale());
                //Resources resources = context.getResources();
                myLocale = new Locale(countryListModelList.get(position).getCountrylocale());
                Resources res = context.getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                Configuration conf = res.getConfiguration();
                conf.locale = myLocale;
                res.updateConfiguration(conf, dm);

                Intent refresh = new Intent(countryListActivity, ProfileActivity.class);
                refresh.putExtra("LANG", countryListModelList.get(position).getCountrylocale());
                countryListActivity.startActivity(refresh);
            }
        });
    }

    @Override
    public int getItemCount() {
        return countryListModelList != null ? countryListModelList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_country;
        TextView txt_country_name;
        LinearLayout lin_parent_countrylist;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_country = itemView.findViewById(R.id.img_country);
            txt_country_name = itemView.findViewById(R.id.txt_country_name);
            lin_parent_countrylist = itemView.findViewById(R.id.lin_parent_countrylist);
        }
    }
}
