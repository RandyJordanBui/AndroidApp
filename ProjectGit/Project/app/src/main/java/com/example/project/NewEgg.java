package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

public class NewEgg extends AppCompatActivity {
    private static String URL = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_egg);
        Button butt = findViewById(R.id.egg_sub);
        EditText txt = findViewById(R.id.newEggURL);
butt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
            URL =  txt.getText().toString();

            if(URL.substring(0,8).equals("https://")){

            }else{
                URL = "https://" + URL;
            }
            try {
                MainActivity.updatetype(2);
                MainActivity.newInstance(URL);
            } catch (IOException e) {
                e.printStackTrace();
            }

            Intent main = new Intent(NewEgg.this, MainActivity.class);
            startActivity(main);
    }
});
        /*
        butt.setOnClickListener(new View.OnClickListener(){

            @Override
                public void onClick(View v){
                    URL = txt.getText().toString();

                    if (URL.substring(0, 8).equals("https://")) {

                    } else {
                        URL = "https://" + URL;
                    }
                    try {
                        MainActivity.updatetype(2);
                        MainActivity.newInstance(URL);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Intent main = new Intent(NewEgg.this, MainActivity.class);
                    startActivity(main);
                }

        });


         */



/*
 @Override
            public void onClick(View v) {
                URL =  txt.getText().toString();

                if(URL.substring(0,8).equals("https://")){

                }else{
                    URL = "https://" + URL;
                }
                try {
                    MainActivity.updatetype(2);
                    MainActivity.newInstance(URL);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent main = new Intent(NewEgg.this, MainActivity.class);
                startActivity(main);
 */

    }
}