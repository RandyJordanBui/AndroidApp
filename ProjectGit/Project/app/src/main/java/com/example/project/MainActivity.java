package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static Document[] doc = new Document[18];
    private static TextView[] textList = new TextView[18];
    private static String mainhtml[] = new String[9];

    private static String[] URLS = new String[9];
    private static int count = 0;
    private static Element[] elementList = new Element[9];
    private static boolean toggle = false;
    private static int count2 = 0;
    private static String[] statusList = new String[9];
    private static int[] type = new int[18];

    private static int saveCurrent = 0;
    //private static String amazonCondition = "<div id=\"availability\" class=\"a-section a-spacing-base }\"> <span class=\"a-size-base a-color-success\"> In Stock. </span> ";
    private Handler testHandler = new Handler();
    private static boolean toggler = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

process p = new process();
        assignIds();


        FloatingActionButton btn = findViewById(R.id.nextPage);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toPres = new Intent(MainActivity.this, PresetPage.class);
                startActivity(toPres);
            }
        });

        FloatingActionButton refresh = findViewById(R.id.RefreshListings);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                for (int i = 0; i < textList.length; i++) {
                    if(i == 0){
                        textList[0].setText(URLS[0]);
                    }else if(i < 8) {
                        textList[i *2].setText(URLS[i]);
                    }else if(i == 9){
                        textList[i * 2 -1].setText(URLS[i-1]);
                    }

                    if(i <= 7){
                        textList[i * 2 +1].setText(statusList[i]);
                    }



                }

                for (int i = 0; i <= count + 1; i++) {
                    textList[i].setVisibility(View.VISIBLE);

                }
                if (count < 19) {
                    count++;
                }
                saveCurrent = count2;
                System.out.println(count2);
                for(int i =0; i < count2; i++){
                    System.out.println(count2);
                    count2 = i;
                    System.out.println(count2);
                    try {
                        process p = new process();
                        p.execute();
                    }catch (Exception e){}
                }


            }
        });

    }

    protected static void newInstance(String URL) throws IOException {
        URLS[count2] = URL;
    process p = new process();
    try {
        p.execute();
    }catch(Exception e){

    }
    }

    protected static void newInstance(String URL, String html) {
        URLS[count2] = URL;
        mainhtml[count2] = html;
        process p = new process();
        try {
            p.execute();
        }catch(Exception e){

        }
    }

    protected static void findStatus(Document document) {

    }
/* not used anymore
    protected static void Display(){

textList[count].setVisibility(View.VISIBLE);
count++;
        textList[count].setVisibility(View.VISIBLE);
        count++;
    }

 */

    protected void assignIds() {
        TextView txt1 = (TextView) findViewById(R.id.text1);
        TextView txt2 = (TextView) findViewById(R.id.text3);
        TextView txt3 = (TextView) findViewById(R.id.text4);
        TextView txt4 = (TextView) findViewById(R.id.text5);
        TextView txt5 = (TextView) findViewById(R.id.text6);
        TextView txt6 = (TextView) findViewById(R.id.text7);
        TextView txt7 = (TextView) findViewById(R.id.text8);
        TextView txt8 = (TextView) findViewById(R.id.text9);
        TextView txt9 = (TextView) findViewById(R.id.text10);
        TextView txt10 = (TextView) findViewById(R.id.text11);
        TextView txt11 = (TextView) findViewById(R.id.text12);
        TextView txt12 = (TextView) findViewById(R.id.text13);
        TextView txt13 = (TextView) findViewById(R.id.text14);
        TextView txt14 = (TextView) findViewById(R.id.text15);
        TextView txt15 = (TextView) findViewById(R.id.text16);
        TextView txt16 = (TextView) findViewById(R.id.text17);
        TextView txt17 = (TextView) findViewById(R.id.text18);
        TextView txt18 = (TextView) findViewById(R.id.text19);
        textList[0] = txt1;
        textList[1] = (txt2);
        textList[2] = txt3;
        textList[3] = (txt4);
        textList[4] = (txt5);
        textList[5] = (txt6);
        textList[6] = (txt7);
        textList[7] = (txt8);
        textList[8] = (txt9);
        textList[9] = (txt10);
        textList[10] = (txt11);
        textList[11] = (txt12);
        textList[12] = (txt13);
        textList[13] = (txt14);
        textList[14] = (txt15);
        textList[15] = (txt16);
        textList[16] = (txt17);
        textList[17] = (txt18);
    }

/*
    private static class process extends AsyncTask<Void, Void, Void> {

protected void onPreExecute(){
    super.onPreExecute();
}


        @Override
        protected Void doInBackground(Void... voids) {
            try {
                System.out.println(URLS[0]);

        doc[0] = Jsoup.connect(URLS[0]).get();
        System.out.println(doc[0]);
            } catch (Exception e) { }




return null;
        }
        protected void onPostExecute(Void avoid){

        }

    }
*/

protected static void updatetype(int brand){
    type[count2] = brand;
}

    private static class process extends AsyncTask<Void, Void, Void>{
protected void onPreExecute(){
    super.onPreExecute();
}
        @SuppressLint("SetTextI18n")
        @Override
        protected Void doInBackground(Void... voids){

            try {
System.out.println(count2);
                System.out.println(URLS[0]);
                   doc[count2] = Jsoup.connect(URLS[count2]).get();

            } catch (IOException e) {
                e.printStackTrace();
            }
            int instance = 0;


                switch(type[count2]){
                    case 0:

       elementList[count2] = doc[count2].getElementById("availability");

       try {
           for (int i = 0; i < elementList[count2].toString().length() -8; i++) {
            instance++;
            System.out.println(elementList[count2].toString());
            System.out.println((elementList[count2].toString().substring(i, i + 8)));
               if ((elementList[count2].toString().substring(i, i + 8)).equalsIgnoreCase("In Stock")) {
                   System.out.println("true");
                   toggler = true;
               }
           }
       }catch(Exception e){ System.out.println("error on instance: " + instance); }

           if(toggler){
               if(count2 <=7) {
                   textList[(count2 * 2) + 1].setText("In Stock.");
                   statusList[count2] = "In Stock.";
                   System.out.println("true");
                   toggler = false;
               }
           }else{
               if(count2 <= 7) {
                   textList[(count2 *2 )+ 1].setText("Out of Stock");
                   statusList[count2] = "Out of Stock";
               }
           }

        count2 = saveCurrent;
       count2++;
                        break;

                    case 1:
//custom case, we are going to look for the html type
                        //take away the '<'
                        boolean firstloop = true;
                        int lastIndex = 0;
                        int saveIndex = 0;
                        String _class = "";
                        String header = "";
                       mainhtml[count2] =  mainhtml[count2].substring(1);
                        for(int i =0; i < mainhtml[count2].length(); i++){
                            if(mainhtml[count2].charAt(i) == ' ' && firstloop){
                                saveIndex = i;
                                firstloop = false;
                            }
                        }
                         header = mainhtml[count2].substring(0,saveIndex);
                        firstloop = true;

                        for(int i =0; i < mainhtml[count2].length(); i++){
                            if(mainhtml[count2].substring(i,i+6).equalsIgnoreCase("class=") && firstloop){
                                //add one more for the quotation mark
                                saveIndex = i+7;
                                firstloop = false;
                            }
                        }
                        firstloop = true;
                        for(int i =0; i < mainhtml[count2].length(); i++){
                            //find next quotation mark
                            if(mainhtml[count2].charAt(i) == '"' && firstloop){
                                lastIndex = i;
                            }
                            _class = mainhtml[count2].substring(saveIndex,lastIndex);
                        }
                        //when there is class we can search in this fashion
                        elementList[count2] = doc[count2].select(header + "." + _class).last();
                        firstloop = true;
                        //check if we got anything back
                        if(elementList[count2].hasText()){

                        }else{
                            for(int i =0; i < mainhtml[count2].length(); i++){
                                if(mainhtml[count2].substring(i, i+3).equalsIgnoreCase("Id=") && firstloop){
                                    saveIndex = i+3;
                                }
                            }
                            firstloop = true;
                            for(int i =0; i < mainhtml[count2].length(); i++){
                                if(mainhtml[count2].charAt(i) == '"' && firstloop){
                                    lastIndex = i;
                                }
                            }
                            //useable when html has an id
                            elementList[count2] = doc[count2].getElementById(mainhtml[count2].substring(saveIndex,lastIndex));
                        }
if(elementList[count2].hasText()){
    statusList[count2] = "The HTML was Found.";
}else{
    statusList[count2] = "The HTML was not Found.";
}
                        count2 = saveCurrent;
                        count2++;
                        break;

                    case 2:
                        elementList[count2] = doc[count2].select("div.product-inventory").last();


                        try {
                            for (int i = 0; i < elementList[count2].toString().length() -8; i++) {
                                instance++;
                                System.out.println((elementList[count2].toString().substring(i, i + 8)));
                                if ((elementList[count2].toString().substring(i, i + 8)).equalsIgnoreCase("In Stock")) {
                                    System.out.println("true");
                                    toggler = true;
                                }
                            }
                        }catch(Exception e){ System.out.println("error on instance" + instance); }

                        if(toggler){
                            if(count2 <=7) {
                                textList[(count2 * 2) + 1].setText("In Stock.");
                                statusList[count2] = "In Stock.";
                                System.out.println("true");
                                toggler = false;
                            }
                        }else{
                            if(count2 <= 7) {
                                textList[(count2 *2 )+ 1].setText("Out of Stock");
                                statusList[count2] = "Out of Stock";
                            }

                        }
                        count2 = saveCurrent;
                        count2++;

                        break;

                }
            return null;
        }
    }
}