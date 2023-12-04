package com.inGrowth.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.ads.AdView;

public class UnitActivity extends AppCompatActivity  {


    TextView tv_2,tv_3,result,name;
    ImageView image;
    Spinner sp1,sp2;
    EditText t1;
    Button convert;
    private AdView mAdView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();

        }




        t1=(EditText)findViewById(R.id.t1);

        //tv_2 =(TextView)findViewById(R.id.tv_2);
       // tv_3 =(TextView)findViewById(R.id.tv_3);
        name=(TextView)findViewById(R.id.unitName);
        image=(ImageView) findViewById(R.id.image2);


        sp1=(Spinner)findViewById(R.id.sp1);
        sp2=(Spinner)findViewById(R.id.sp2);

        result=(TextView)findViewById(R.id.result);

        convert =(Button)findViewById(R.id.convert);



       Bundle bundle = getIntent().getExtras();
       if (bundle != null ){
         String unitName =  bundle.getString("key");
         if (unitName.equals("Currency Converter")){
             showCurrencyDetails(unitName);
         }

           if (unitName.equals("Weight Converter")){
               showWeightDetails(unitName);
           }

           if (unitName.equals("Time Converter")){
               showTimeDetails(unitName);
           }
           if (unitName.equals("Length Converter")){
               showLengthDetails(unitName);
           }
           if (unitName.equals("Area Converter")){
               showAreaDetails(unitName);
           }
           if (unitName.equals("Temperature Converter")){
               showTemperatureDetails(unitName);
           }
       }










    }

    private void showTemperatureDetails(String unitName) {

        name.setText(unitName);
        image.setImageResource(R.drawable.temperature_icon);

        String[] from = {"--select one--","Celsius(C)","Fahrenheit(F)"};
        ArrayAdapter adapter =new ArrayAdapter<String>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(adapter);

        String[] to = {"--select one--","Celsius(C)","Fahrenheit(F)"};
        ArrayAdapter adapter2 =new ArrayAdapter<String>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(adapter2);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Double total;
                Double amount = Double.parseDouble(t1.getText().toString());

                if (sp1.getSelectedItem().toString() == "Celsius(C)" && sp2.getSelectedItem().toString() == "Fahrenheit(F)"){
                    total = ((amount * 9/5) + 32);
                    result.setText(Double.toString(total) + " F");
                }
                if (sp1.getSelectedItem().toString() == "Fahrenheit(F)" && sp2.getSelectedItem().toString() == "Celsius(C)"){
                    total = ((amount - 32) * 5/9) ;
                    result.setText(Double.toString(total) + " C");
                }

            }
        });
    }

    private void showAreaDetails(String unitName) {
        name.setText(unitName);
        image.setImageResource(R.drawable.area_icon);


        String[] from = {"--select one--","Square Kilometer(S.km)","Acre"};
        ArrayAdapter adapter =new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(adapter);

        String[] to = {"--select one--","Square Kilometer(S.km)","Acre"};
        ArrayAdapter adapter2 =new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(adapter2);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Double total;
                Double amount = Double.parseDouble(t1.getText().toString());

                if (sp1.getSelectedItem().toString() == "Square Kilometer(S.km)" && sp2.getSelectedItem().toString() == "Acre"){
                    total = amount * 247.105;
                    result.setText(Double.toString(total) + " (Acre)");
                }
                if (sp1.getSelectedItem().toString() == "Acre" && sp2.getSelectedItem().toString() == "Square Kilometer(S.km)"){
                    total = amount / 247.105;
                    result.setText(Double.toString(total) + " (S.km)");
                }

            }
        });


    }

    private void showLengthDetails(String unitName) {
        name.setText(unitName);
        image.setImageResource(R.drawable.length_icon);


        String[] from = {"--select one--","Meter(m)","Centi-Meter(cm)"};
        ArrayAdapter adapter =new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(adapter);

        String[] to = {"--select one--","Meter(m)","Centi-Meter(cm)"};
        ArrayAdapter adapter2 =new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(adapter2);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Double total;
                Double amount = Double.parseDouble(t1.getText().toString());

                if (sp1.getSelectedItem().toString() == "Meter(m)" && sp2.getSelectedItem().toString() == "Centi-Meter(cm)"){
                    total = amount * 100;
                    result.setText(Double.toString(total) + " (cm)");
                }
                if (sp1.getSelectedItem().toString() == "Centi-Meter(cm)" && sp2.getSelectedItem().toString() == "Meter(m)"){
                    total = amount / 100;
                    result.setText(Double.toString(total) + " (m)");
                }

            }
        });

    }

    private void showTimeDetails(String unitName) {

        name.setText(unitName);
        image.setImageResource(R.drawable.time_icon);

        String[] from = {"--select one--","Minute","Second"};
        ArrayAdapter adapter =new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(adapter);

        String[] to = {"--select one--","Minute","Second"};
        ArrayAdapter adapter2 =new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(adapter2);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Double total;
                Double amount = Double.parseDouble(t1.getText().toString());

                if (sp1.getSelectedItem().toString() == "Minute" && sp2.getSelectedItem().toString() == "Second"){
                    total = amount * 60;
                    result.setText(Double.toString(total) + " (Second)");
                }
                if (sp1.getSelectedItem().toString() == "Second" && sp2.getSelectedItem().toString() == "Minute"){
                    total = amount / 60;
                    result.setText(Double.toString(total) + " (Minute)");
                }

            }
        });
    }

    private void showWeightDetails(String unitName) {

        name.setText(unitName);
        image.setImageResource(R.drawable.weight_icon);


        String[] from = {"--select one--","Kilogram(kg)","Gram(gm)"};
        ArrayAdapter adapter =new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(adapter);

        String[] to = {"--select one--","Kilogram(kg)","Gram(gm)"};
        ArrayAdapter adapter2 =new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(adapter2);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Double total;
                Double amount = Double.parseDouble(t1.getText().toString());

                if (sp1.getSelectedItem().toString() == "Kilogram(kg)" && sp2.getSelectedItem().toString() == "Gram(gm)"){
                    total = amount * 1000;
                    result.setText(Double.toString(total) + " (gm)");
                }
                if (sp1.getSelectedItem().toString() == "Gram(gm)" && sp2.getSelectedItem().toString() == "Kilogram(kg)"){
                    total = amount / 1000;
                    result.setText(Double.toString(total) + " (kg)");
                }

            }
        });

    }

    private void showCurrencyDetails(String unitName) {
        name.setText(unitName);
        image.setImageResource(R.drawable.currency_icon);

        String[] from = {"--select one--","Bangladeshi Taka","U.S. Dollar (USD)","Indian Rupee","European Euro (EUR)","Japanese Yen (JPY)",
                "British Pound (GBP)","Swiss Franc (CHF)","Canadian Dollar (CAD)","Australian Dollar (AUD)","Singapore Dollar"};
        ArrayAdapter adapter =new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(adapter);

        String[] to = {"--select one--","Bangladeshi Taka","U.S. Dollar (USD)","Indian Rupee","European Euro (EUR)","Japanese Yen (JPY)",
                "British Pound (GBP)","Swiss Franc (CHF)","Canadian Dollar (CAD)","Australian Dollar (AUD)","Singapore Dollar"};
        ArrayAdapter adapter2 =new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(adapter2);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Double total;
                Double amount = Double.parseDouble(t1.getText().toString());

                if (sp1.getSelectedItem().toString() == "U.S. Dollar (USD)" && sp2.getSelectedItem().toString() == "Bangladeshi Taka"){
                    total = amount * 84.88;
                    result.setText(Double.toString(total) + " BDT");
                }
                if (sp1.getSelectedItem().toString() == "Bangladeshi Taka" && sp2.getSelectedItem().toString() == "U.S. Dollar (USD)"){
                    total = amount / 84.88;
                    result.setText(Double.toString(total) + " USD");
                }

                if (sp1.getSelectedItem().toString() == "U.S. Dollar (USD)" && sp2.getSelectedItem().toString() == "Indian Rupee"){
                    total = amount * 72.89;
                    result.setText(Double.toString(total) + " Rs");
                }
                if (sp1.getSelectedItem().toString() == "Indian Rupee" && sp2.getSelectedItem().toString() == "U.S. Dollar (USD)"){
                    total = amount / 72.89;
                    result.setText(Double.toString(total) + " USD");
                }

                if (sp1.getSelectedItem().toString() == "Bangladeshi Taka" && sp2.getSelectedItem().toString() == "Indian Rupee"){
                    total = amount / 1.16;
                    result.setText(Double.toString(total) + " Rs");
                }
                if (sp1.getSelectedItem().toString() == "Indian Rupee" && sp2.getSelectedItem().toString() == "Bangladeshi Taka"){
                    total = amount * 1.16;
                    result.setText(Double.toString(total) + " BDT");
                }


                if (sp1.getSelectedItem().toString() == "Bangladeshi Taka" && sp2.getSelectedItem().toString() == "European Euro (EUR)"){
                    total = amount / 103.13;
                    result.setText(Double.toString(total) + " EUR");
                }
                if (sp1.getSelectedItem().toString() == "European Euro (EUR)" && sp2.getSelectedItem().toString() == "Bangladeshi Taka"){
                    total = amount * 103.13;
                    result.setText(Double.toString(total) + " BDT");
                }
                if (sp1.getSelectedItem().toString() == "Indian Rupee" && sp2.getSelectedItem().toString() == "European Euro (EUR)"){
                    total = amount / 88.63;
                    result.setText(Double.toString(total) + " EUR");
                }
                if (sp1.getSelectedItem().toString() == "European Euro (EUR)" && sp2.getSelectedItem().toString() == "Indian Rupee"){
                    total = amount * 88.63;
                    result.setText(Double.toString(total) + " Rs");
                }
                if (sp1.getSelectedItem().toString() == "U.S. Dollar (USD)" && sp2.getSelectedItem().toString() == "European Euro (EUR)"){
                    total = amount / 1.21;
                    result.setText(Double.toString(total) + " EUR");
                }
                if (sp1.getSelectedItem().toString() == "European Euro (EUR)" && sp2.getSelectedItem().toString() == "U.S. Dollar (USD)"){
                    total = amount * 1.21;
                    result.setText(Double.toString(total) + " USD");
                }


                if (sp1.getSelectedItem().toString() == "Bangladeshi Taka" && sp2.getSelectedItem().toString() == "Japanese Yen (JPY)"){
                    total = amount * 1.22;
                    result.setText(Double.toString(total) + " JPY");
                }
                if (sp1.getSelectedItem().toString() == "Japanese Yen (JPY)" && sp2.getSelectedItem().toString() == "Bangladeshi Taka"){
                    total = amount / 1.22;
                    result.setText(Double.toString(total) + " BDT");
                }
                if (sp1.getSelectedItem().toString() == "Indian Rupee" && sp2.getSelectedItem().toString() == "Japanese Yen (JPY)"){
                    total = amount * 1.42;
                    result.setText(Double.toString(total) + " JPY");
                }
                if (sp1.getSelectedItem().toString() == "Japanese Yen (JPY)" && sp2.getSelectedItem().toString() == "Indian Rupee"){
                    total = amount / 1.42;
                    result.setText(Double.toString(total) + " Rs");
                }
                if (sp1.getSelectedItem().toString() == "U.S. Dollar (USD)" && sp2.getSelectedItem().toString() == "Japanese Yen (JPY)"){
                    total = amount * 103.79;
                    result.setText(Double.toString(total) + " JPY");
                }
                if (sp1.getSelectedItem().toString() == "Japanese Yen (JPY)" && sp2.getSelectedItem().toString() == "U.S. Dollar (USD)"){
                    total = amount / 103.79;
                    result.setText(Double.toString(total) + " USD");
                }


                if (sp1.getSelectedItem().toString() == "Bangladeshi Taka" && sp2.getSelectedItem().toString() == "British Pound (GBP)"){
                    total = amount / 116.06;
                    result.setText(Double.toString(total) + " GBP");
                }
                if (sp1.getSelectedItem().toString() == "British Pound (GBP)" && sp2.getSelectedItem().toString() == "Bangladeshi Taka"){
                    total = amount * 116.06;
                    result.setText(Double.toString(total) + " BDT");
                }
                if (sp1.getSelectedItem().toString() == "Indian Rupee" && sp2.getSelectedItem().toString() == "British Pound (GBP)"){
                    total = amount / 99.76;
                    result.setText(Double.toString(total) + " GBP");
                }
                if (sp1.getSelectedItem().toString() == "British Pound (GBP)" && sp2.getSelectedItem().toString() == "Indian Rupee"){
                    total = amount * 99.76;
                    result.setText(Double.toString(total) + " Rs");
                }
                if (sp1.getSelectedItem().toString() == "U.S. Dollar (USD)" && sp2.getSelectedItem().toString() == "British Pound (GBP)"){
                    total = amount / 1.37;
                    result.setText(Double.toString(total) + " GBP");
                }
                if (sp1.getSelectedItem().toString() == "British Pound (GBP)" && sp2.getSelectedItem().toString() == "U.S. Dollar (USD)"){
                    total = amount * 1.37;
                    result.setText(Double.toString(total) + " USD");
                }

                if (sp1.getSelectedItem().toString() == "Bangladeshi Taka" && sp2.getSelectedItem().toString() == "Swiss Franc (CHF)"){
                    total = amount / 95.79;
                    result.setText(Double.toString(total) + " CHF");
                }
                if (sp1.getSelectedItem().toString() == "Swiss Franc (CHF)" && sp2.getSelectedItem().toString() == "Bangladeshi Taka"){
                    total = amount * 95.79;
                    result.setText(Double.toString(total) + " BDT");
                }
                if (sp1.getSelectedItem().toString() == "Indian Rupee" && sp2.getSelectedItem().toString() == "Swiss Franc (CHF)"){
                    total = amount / 82.28;
                    result.setText(Double.toString(total) + " CHF");
                }
                if (sp1.getSelectedItem().toString() == "Swiss Franc (CHF)" && sp2.getSelectedItem().toString() == "Indian Rupee"){
                    total = amount * 82.28;
                    result.setText(Double.toString(total) + " Rs");
                }
                if (sp1.getSelectedItem().toString() == "U.S. Dollar (USD)" && sp2.getSelectedItem().toString() == "Swiss Franc (CHF)"){
                    total = amount / 1.13;
                    result.setText(Double.toString(total) + " CHF");
                }
                if (sp1.getSelectedItem().toString() == "Swiss Franc (CHF)" && sp2.getSelectedItem().toString() == "U.S. Dollar (USD)"){
                    total = amount * 1.13;
                    result.setText(Double.toString(total) + " USD");
                }

                if (sp1.getSelectedItem().toString() == "Bangladeshi Taka" && sp2.getSelectedItem().toString() == "Canadian Dollar (CAD)"){
                    total = amount / 66.81;
                    result.setText(Double.toString(total) + " CAD");
                }
                if (sp1.getSelectedItem().toString() == "Canadian Dollar (CAD)" && sp2.getSelectedItem().toString() == "Bangladeshi Taka"){
                    total = amount * 66.81;
                    result.setText(Double.toString(total) + " BDT");
                }
                if (sp1.getSelectedItem().toString() == "Indian Rupee" && sp2.getSelectedItem().toString() == "Canadian Dollar (CAD)"){
                    total = amount / 57.39;
                    result.setText(Double.toString(total) + " CAD");
                }
                if (sp1.getSelectedItem().toString() == "Canadian Dollar (CAD)" && sp2.getSelectedItem().toString() == "Indian Rupee"){
                    total = amount * 57.39;
                    result.setText(Double.toString(total) + " Rs");
                }
                if (sp1.getSelectedItem().toString() == "U.S. Dollar (USD)" && sp2.getSelectedItem().toString() == "Canadian Dollar (CAD)"){
                    total = amount * 1.27;
                    result.setText(Double.toString(total) + " CAD");
                }
                if (sp1.getSelectedItem().toString() == "Canadian Dollar (CAD)" && sp2.getSelectedItem().toString() == "U.S. Dollar (USD)"){
                    total = amount / 1.27;
                    result.setText(Double.toString(total) + " USD");
                }

                if (sp1.getSelectedItem().toString() == "Bangladeshi Taka" && sp2.getSelectedItem().toString() == "Australian Dollar (AUD)"){
                    total = amount / 65.59;
                    result.setText(Double.toString(total) + " AUD");
                }
                if (sp1.getSelectedItem().toString() == "Australian Dollar (AUD)" && sp2.getSelectedItem().toString() == "Bangladeshi Taka"){
                    total = amount * 65.59;
                    result.setText(Double.toString(total) + " BDT");
                }
                if (sp1.getSelectedItem().toString() == "Indian Rupee" && sp2.getSelectedItem().toString() == "Australian Dollar (AUD)"){
                    total = amount / 56.33;
                    result.setText(Double.toString(total) + " AUD");
                }
                if (sp1.getSelectedItem().toString() == "Australian Dollar (AUD)" && sp2.getSelectedItem().toString() == "Indian Rupee"){
                    total = amount * 56.33;
                    result.setText(Double.toString(total) + " Rs");
                }
                if (sp1.getSelectedItem().toString() == "U.S. Dollar (USD)" && sp2.getSelectedItem().toString() == "Australian Dollar (AUD)"){
                    total = amount * 1.29;
                    result.setText(Double.toString(total) + " AUD");
                }
                if (sp1.getSelectedItem().toString() == "Australian Dollar (AUD)" && sp2.getSelectedItem().toString() == "U.S. Dollar (USD)"){
                    total = amount / 1.29;
                    result.setText(Double.toString(total) + " USD");
                }

                if (sp1.getSelectedItem().toString() == "Bangladeshi Taka" && sp2.getSelectedItem().toString() == "Singapore Dollar"){
                    total = amount / 63.92;
                    result.setText(Double.toString(total) + " SD");
                }
                if (sp1.getSelectedItem().toString() == "Singapore Dollar" && sp2.getSelectedItem().toString() == "Bangladeshi Taka"){
                    total = amount * 63.92;
                    result.setText(Double.toString(total) + " BDT");
                }
                if (sp1.getSelectedItem().toString() == "Indian Rupee" && sp2.getSelectedItem().toString() == "Singapore Dollar"){
                    total = amount / 54.96;
                    result.setText(Double.toString(total) + " SD");
                }
                if (sp1.getSelectedItem().toString() == "Singapore Dollar" && sp2.getSelectedItem().toString() == "Indian Rupee"){
                    total = amount * 54.96;
                    result.setText(Double.toString(total) + " Rs");
                }
                if (sp1.getSelectedItem().toString() == "U.S. Dollar (USD)" && sp2.getSelectedItem().toString() == "Singapore Dollar"){
                    total = amount * 1.33;
                    result.setText(Double.toString(total) + " SD");
                }
                if (sp1.getSelectedItem().toString() == "Singapore Dollar" && sp2.getSelectedItem().toString() == "U.S. Dollar (USD)"){
                    total = amount / 1.33;
                    result.setText(Double.toString(total) + " USD");
                }

                if (sp1.getSelectedItem().toString() == "European Euro (EUR)" && sp2.getSelectedItem().toString() == "Japanese Yen (JPY)"){
                    total = amount * 126.20;
                    result.setText(Double.toString(total) + " JPY");
                }
                if (sp1.getSelectedItem().toString() == "Japanese Yen (JPY)" && sp2.getSelectedItem().toString() == "European Euro (EUR)"){
                    total = amount / 126.20;
                    result.setText(Double.toString(total) + " EUR");
                }
                if (sp1.getSelectedItem().toString() == "European Euro (EUR)" && sp2.getSelectedItem().toString() == "British Pound (GBP)"){
                    total = amount / 1.13;
                    result.setText(Double.toString(total) + " GBP");
                }
                if (sp1.getSelectedItem().toString() == "British Pound (GBP)" && sp2.getSelectedItem().toString() == "European Euro (EUR)"){
                    total = amount * 1.13;
                    result.setText(Double.toString(total) + " EUR");
                }
                if (sp1.getSelectedItem().toString() == "European Euro (EUR)" && sp2.getSelectedItem().toString() == "Swiss Franc (CHF)"){
                    total = amount * 1.08;
                    result.setText(Double.toString(total) + " CHF");
                }
                if (sp1.getSelectedItem().toString() == "Swiss Franc (CHF)" && sp2.getSelectedItem().toString() == "European Euro (EUR)"){
                    total = amount / 1.08;
                    result.setText(Double.toString(total) + " EUR");
                }
                if (sp1.getSelectedItem().toString() == "European Euro (EUR)" && sp2.getSelectedItem().toString() == "Canadian Dollar (CAD)"){
                    total = amount * 1.55;
                    result.setText(Double.toString(total) + " CAD");
                }
                if (sp1.getSelectedItem().toString() == "Canadian Dollar (CAD)" && sp2.getSelectedItem().toString() == "European Euro (EUR)"){
                    total = amount / 1.55;
                    result.setText(Double.toString(total) + " EUR");
                }
                if (sp1.getSelectedItem().toString() == "European Euro (EUR)" && sp2.getSelectedItem().toString() == "Australian Dollar (AUD)"){
                    total = amount * 1.57;
                    result.setText(Double.toString(total) + " AUD");
                }
                if (sp1.getSelectedItem().toString() == "Australian Dollar (AUD)" && sp2.getSelectedItem().toString() == "European Euro (EUR)"){
                    total = amount / 1.57;
                    result.setText(Double.toString(total) + " EUR");

                }
                if (sp1.getSelectedItem().toString() == "European Euro (EUR)" && sp2.getSelectedItem().toString() == "Singapore Dollar"){
                    total = amount * 1.61;
                    result.setText(Double.toString(total) + " SD");
                }
                if (sp1.getSelectedItem().toString() == "Singapore Dollar" && sp2.getSelectedItem().toString() == "European Euro (EUR)"){
                    total = amount / 1.61;
                    result.setText(Double.toString(total) + " EUR");
                }

                if (sp1.getSelectedItem().toString() == "Japanese Yen (JPY)" && sp2.getSelectedItem().toString() == "British Pound (GBP)"){
                    total = amount / 141.98;
                    result.setText(Double.toString(total) + " GBP");
                }
                if (sp1.getSelectedItem().toString() == "British Pound (GBP)" && sp2.getSelectedItem().toString() == "Japanese Yen (JPY)"){
                    total = amount * 141.98;
                    result.setText(Double.toString(total) + " JPY");
                }
                if (sp1.getSelectedItem().toString() == "Japanese Yen (JPY)" && sp2.getSelectedItem().toString() == "Swiss Franc (CHF)"){
                    total = amount / 117.09;
                    result.setText(Double.toString(total) + " CHF");
                }
                if (sp1.getSelectedItem().toString() == "Swiss Franc (CHF)" && sp2.getSelectedItem().toString() == "Japanese Yen (JPY)"){
                    total = amount * 117.09;
                    result.setText(Double.toString(total) + " JPY");
                }
                if (sp1.getSelectedItem().toString() == "Japanese Yen (JPY)" && sp2.getSelectedItem().toString() == "Canadian Dollar (CAD)"){
                    total = amount / 81.56;
                    result.setText(Double.toString(total) + " CAD");
                }
                if (sp1.getSelectedItem().toString() == "Canadian Dollar (CAD)" && sp2.getSelectedItem().toString() == "Japanese Yen (JPY)"){
                    total = amount * 81.56;
                    result.setText(Double.toString(total) + " JPY");
                }
                if (sp1.getSelectedItem().toString() == "Japanese Yen (JPY)" && sp2.getSelectedItem().toString() == "Australian Dollar (AUD)"){
                    total = amount / 80.18;
                    result.setText(Double.toString(total) + " AUD");
                }
                if (sp1.getSelectedItem().toString() == "Australian Dollar (AUD)" && sp2.getSelectedItem().toString() == "Japanese Yen (JPY)"){
                    total = amount * 80.18;
                    result.setText(Double.toString(total) + " JPY");
                }
                if (sp1.getSelectedItem().toString() == "Japanese Yen (JPY)" && sp2.getSelectedItem().toString() == "Singapore Dollar"){
                    total = amount / 78.22;
                    result.setText(Double.toString(total) + " SD");
                }
                if (sp1.getSelectedItem().toString() == "Singapore Dollar" && sp2.getSelectedItem().toString() == "Japanese Yen (JPY)"){
                    total = amount * 78.22;
                    result.setText(Double.toString(total) + " JPY");
                }

                if (sp1.getSelectedItem().toString() == "British Pound (GBP)" && sp2.getSelectedItem().toString() == "Swiss Franc (CHF)"){
                    total = amount * 1.21;
                    result.setText(Double.toString(total) + " CHF");
                }
                if (sp1.getSelectedItem().toString() == "Swiss Franc (CHF)" && sp2.getSelectedItem().toString() == "British Pound (GBP)"){
                    total = amount / 1.21;
                    result.setText(Double.toString(total) + " GBP");
                }
                if (sp1.getSelectedItem().toString() == "British Pound (GBP)" && sp2.getSelectedItem().toString() == "Canadian Dollar (CAD)"){
                    total = amount * 1.74;
                    result.setText(Double.toString(total) + " CAD");
                }
                if (sp1.getSelectedItem().toString() == "Canadian Dollar (CAD)" && sp2.getSelectedItem().toString() == "British Pound (GBP)"){
                    total = amount / 1.74;
                    result.setText(Double.toString(total) + " GBP");
                }
                if (sp1.getSelectedItem().toString() == "British Pound (GBP)" && sp2.getSelectedItem().toString() == "Australian Dollar (AUD)"){
                    total = amount * 1.77;
                    result.setText(Double.toString(total) + " AUD");
                }
                if (sp1.getSelectedItem().toString() == "Australian Dollar (AUD)" && sp2.getSelectedItem().toString() == "British Pound (GBP)"){
                    total = amount / 1.77;
                    result.setText(Double.toString(total) + " GBP");
                }
                if (sp1.getSelectedItem().toString() == "British Pound (GBP)" && sp2.getSelectedItem().toString() == "Singapore Dollar"){
                    total = amount * 1.82;
                    result.setText(Double.toString(total) + " SD");
                }
                if (sp1.getSelectedItem().toString() == "Singapore Dollar" && sp2.getSelectedItem().toString() == "British Pound (GBP)"){
                    total = amount / 1.82;
                    result.setText(Double.toString(total) + " GBP");
                }

                if (sp1.getSelectedItem().toString() == "Swiss Franc (CHF)" && sp2.getSelectedItem().toString() == "Canadian Dollar (CAD)"){
                    total = amount * 1.43;
                    result.setText(Double.toString(total) + " CAD");
                }
                if (sp1.getSelectedItem().toString() == "Canadian Dollar (CAD)" && sp2.getSelectedItem().toString() == "Swiss Franc (CHF)"){
                    total = amount / 1.43;
                    result.setText(Double.toString(total) + " CHF");
                }
                if (sp1.getSelectedItem().toString() == "Swiss Franc (CHF)" && sp2.getSelectedItem().toString() == "Australian Dollar (AUD)"){
                    total = amount * 1.46;
                    result.setText(Double.toString(total) + " AUD");
                }
                if (sp1.getSelectedItem().toString() == "Australian Dollar (AUD)" && sp2.getSelectedItem().toString() == "Swiss Franc (CHF)"){
                    total = amount / 1.46;
                    result.setText(Double.toString(total) + " CHF");
                }
                if (sp1.getSelectedItem().toString() == "Swiss Franc (CHF)" && sp2.getSelectedItem().toString() == "Singapore Dollar"){
                    total = amount * 1.50 ;
                    result.setText(Double.toString(total) + " SD");
                }
                if (sp1.getSelectedItem().toString() == "Singapore Dollar" && sp2.getSelectedItem().toString() == "Swiss Franc (CHF)"){
                    total = amount / 1.50 ;
                    result.setText(Double.toString(total) + " CHF");
                }

                if (sp1.getSelectedItem().toString() == "Canadian Dollar (CAD)" && sp2.getSelectedItem().toString() == "Australian Dollar (AUD)"){
                    total = amount * 1.02 ;
                    result.setText(Double.toString(total) + " AUD");
                }
                if (sp1.getSelectedItem().toString() == "Australian Dollar (AUD)" && sp2.getSelectedItem().toString() == "Canadian Dollar (CAD)"){
                    total = amount / 1.02 ;
                    result.setText(Double.toString(total) + " CAD");
                }
                if (sp1.getSelectedItem().toString() == "Canadian Dollar (CAD)" && sp2.getSelectedItem().toString() == "Singapore Dollar"){
                    total = amount * 1.04 ;
                    result.setText(Double.toString(total) + " SD");
                }
                if (sp1.getSelectedItem().toString() == "Singapore Dollar" && sp2.getSelectedItem().toString() == "Canadian Dollar (CAD)"){
                    total = amount / 1.04 ;
                    result.setText(Double.toString(total) + " CAD");
                }

                if (sp1.getSelectedItem().toString() == "Australian Dollar (AUD)" && sp2.getSelectedItem().toString() == "Singapore Dollar"){
                    total = amount * 1.03 ;
                    result.setText(Double.toString(total) + " SD");
                }
                if (sp1.getSelectedItem().toString() == "Singapore Dollar" && sp2.getSelectedItem().toString() == "Australian Dollar (AUD)"){
                    total = amount / 1.03 ;
                    result.setText(Double.toString(total) + " AUD");
                }



            }
        });


    }


}