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

public class AreaActivity extends AppCompatActivity {
    private AdView mAdView;
    TextView tv_2,tv_3,result,name;
    ImageView image;
    Spinner sp1,sp2;
    EditText t1;
    Button convert;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
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
        showAreaDetails();
    }

    private void showAreaDetails() {

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
}