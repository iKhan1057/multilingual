package com.countrytour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Locale locale = new Locale(getIntent().getStringExtra("LANG"));
        Locale.setDefault(locale);
        Configuration config = getBaseContext().getResources().getConfiguration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
        setContentView(R.layout.activity_profile);
        ImageView img_profile_bannar = findViewById(R.id.img_profile_bannar);
        ImageView img_profile = findViewById(R.id.img_profile);
        TextView txt_profile_name = findViewById(R.id.txt_profile_name);
        Glide.with(this).load(getString(R.string.profile_bannar_image)).into(img_profile_bannar);
        Glide.with(this).load(getString(R.string.profile_image_url)).into(img_profile);
        txt_profile_name.setText(getString(R.string.profile_name));

        RecyclerView recycler_view_profile_data = findViewById(R.id.recycler_view_profile_data);
        ProfileDataAdapter profileDataAdapter = new ProfileDataAdapter(getProfileData(),this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recycler_view_profile_data.setLayoutManager(mLayoutManager);
        recycler_view_profile_data.setItemAnimator(new DefaultItemAnimator());
        recycler_view_profile_data.setAdapter(profileDataAdapter);
    }

    private List<ProfileModel> getProfileData() {
        String[] tagname = new String[]{getString(R.string.country_caption), getString(R.string.dob_caption),
                getString(R.string.age_caption),
                getString(R.string.profession_caption),getString(R.string.gender_caption),
                getString(R.string.religion_caption),getString(R.string.hobbies_caption),
                getString(R.string.height_caption),getString(R.string.weight_caption)
        };
        String[] tagValue = new String[]{getString(R.string.country), getString(R.string.dob),
                getString(R.string.age),
                getString(R.string.profession),getString(R.string.gender),
                getString(R.string.religion),getString(R.string.hobbies),
                getString(R.string.height_val),getString(R.string.weight_val)
        };
        List<ProfileModel> profileModels = new ArrayList<>();
        for (int i = 0; i < tagname.length; i++) {
            ProfileModel profileModel = new ProfileModel();
            profileModel.setTagName(tagname[i]);
            profileModel.setTagValue(tagValue[i]);
            profileModels.add(profileModel);
        }
        return profileModels;
    }
}
