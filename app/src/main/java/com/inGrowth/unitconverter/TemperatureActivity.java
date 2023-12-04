package com.inGrowth.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class TemperatureActivity extends AppCompatActivity {
    TextView tv_2,tv_3,result,name;
    ImageView image;
    Spinner sp1,sp2;
    EditText t1;
    Button convert;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();

        }

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        t1=(EditText)findViewById(R.id.t1);

        //tv_2 =(TextView)findViewById(R.id.tv_2);
        // tv_3 =(TextView)findViewById(R.id.tv_3);
        name=(TextView)findViewById(R.id.unitName);
        image=(ImageView) findViewById(R.id.image2);


        sp1=(Spinner)findViewById(R.id.sp1);
        sp2=(Spinner)findViewById(R.id.sp2);

        result=(TextView)findViewById(R.id.result);

        convert =(Button)findViewById(R.id.convert);
        showTemperatureDetails();
    }

    private void showTemperatureDetails() {


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
}