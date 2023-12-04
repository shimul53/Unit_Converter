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

public class CurrencyActivity extends AppCompatActivity {

    private AdView mAdView;

    TextView tv_2,tv_3,result,name;
    ImageView image;
    Spinner sp1,sp2;
    EditText t1;
    Button convert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
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
        showCurrencyDetails();
    }

    private void showCurrencyDetails() {

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