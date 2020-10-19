package com.countrytour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView txt_hello;
    ImageView img_flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Locale locale = new Locale(getIntent().getStringExtra("LANG"));
        Locale.setDefault(locale);
        Configuration config = getBaseContext().getResources().getConfiguration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
        setContentView(R.layout.activity_main);

        img_flag = findViewById(R.id.img_flag);
        txt_hello = findViewById(R.id.txt_hello);
        img_flag.setImageDrawable(getResources().getDrawable(R.drawable.flag));
        txt_hello.setText(getResources().getString(R.string.welcome));
    }
}
