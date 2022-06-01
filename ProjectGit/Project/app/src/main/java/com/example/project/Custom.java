package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

public class Custom extends AppCompatActivity {
    private static String URL = "";
    private static String html = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        Button btn = findViewById(R.id.CustomButton);
        EditText txt = findViewById(R.id.CustomURL);
        EditText txt2 = findViewById(R.id.CustomHTML);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL =  txt.getText().toString();
                html =  txt2.getText().toString();

                if(URL.substring(0,8).equals("https://")){

                }else{
                    URL = "https://" + URL;
                }
                MainActivity.updatetype(1);
                    MainActivity.newInstance(URL, html);


                Intent main = new Intent(Custom.this, MainActivity.class);
                startActivity(main);

            }
        });
    }
}