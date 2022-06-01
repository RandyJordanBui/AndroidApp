package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

public class Amazon extends AppCompatActivity {
private static String URL = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amazon);
        Button btn = findViewById(R.id.sub_ama);
        EditText txt = findViewById(R.id.Ama_url);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL =  txt.getText().toString();
                if(URL.substring(0,8).equals("https://")){

                }else {
                    URL = "https://" + URL;
                }
                try {
                    MainActivity.updatetype(0);
                    MainActivity.newInstance(URL);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent main = new Intent(Amazon.this, MainActivity.class);
                startActivity(main);

            }
        });
    }

}