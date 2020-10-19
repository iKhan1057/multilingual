package com.countrytour;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CountryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);

        RecyclerView recycler_view_country_data = findViewById(R.id.recycler_view_country_data);
        CountryListAdapter countryListAdapter = new CountryListAdapter(this, getCountryData());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recycler_view_country_data.setLayoutManager(mLayoutManager);
        recycler_view_country_data.setItemAnimator(new DefaultItemAnimator());
        recycler_view_country_data.setAdapter(countryListAdapter);
    }

    private List<CountryListModel> getCountryData() {
        String countryname[] = new String[]{"India", "Bangladesh", "Pakistan", "Spain", "USA"};
        String countrycode[] = new String[]{"hi", "bn", "ur", "es", "en"};
        String countryflag[] = new String[]{"https://www.countries-ofthe-world.com/flags-normal/flag-of-India.png",
                "https://www.countries-ofthe-world.com/flags-normal/flag-of-Bangladesh.png",
                "https://www.countries-ofthe-world.com/flags-normal/flag-of-Pakistan.png",
                "https://www.countries-ofthe-world.com/flags-normal/flag-of-Spain.png",
                "https://www.countries-ofthe-world.com/flags-normal/flag-of-United-States-of-America.png"};
        List<CountryListModel> countryListModels = new ArrayList<>();
        for (int i = 0; i < countryname.length; i++) {
            CountryListModel listModel = new CountryListModel();
            listModel.setCountryflag(countryflag[i]);
            listModel.setCountrylocale(countrycode[i]);
            listModel.setCountryname(countryname[i]);
            countryListModels.add(listModel);
        }
        return countryListModels;
    }
}
