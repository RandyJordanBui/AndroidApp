package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PresetPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preset_page);
        Button amaButton = findViewById(R.id.amaPage);
        Button eggButton = findViewById(R.id.eggPage);
        Button customButton = findViewById(R.id.CustomPage);
            Button helpButton = findViewById(R.id.Help);


            helpButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent helpPage = new Intent(PresetPage.this, help.class);
                    startActivity(helpPage);
                }
            });
        amaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent amazonPage = new Intent(PresetPage.this, Amazon.class);
                startActivity(amazonPage);

            }
        });

        eggButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent eggPage = new Intent(PresetPage.this, NewEgg.class);
                startActivity(eggPage);
            }
        });
        customButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent customPage = new Intent(PresetPage.this, Custom.class);
                startActivity(customPage);
            }
        });
    }
}