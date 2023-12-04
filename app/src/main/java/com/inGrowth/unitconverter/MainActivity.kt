package com.inGrowth.unitconverter

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.OnUserEarnedRewardListener
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback


class MainActivity : AppCompatActivity(), View.OnClickListener {
    var currency: CardView? = null
    var weight: CardView? = null
    var time: CardView? = null
    var length: CardView? = null
    var area: CardView? = null
    var temperature: CardView? = null

    private var mInterstitialAd: InterstitialAd? = null
    private var rewardedAd: RewardedAd? = null





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var adRequest = AdRequest.Builder().build()

        InterstitialAd.load(this,"ca-app-pub-9919495400639035/2037388867", adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {

                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {

                mInterstitialAd = interstitialAd
            }
        })


      //work on it add  real ad unit id
        RewardedAd.load(this,"ca-app-pub-9919495400639035/1174680981", adRequest, object : RewardedAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {

                rewardedAd = null
            }

            override fun onAdLoaded(ad: RewardedAd) {

                rewardedAd = ad
            }
        })








        currency = findViewById<View>(R.id.currency) as CardView
        weight = findViewById<View>(R.id.weight) as CardView
        time = findViewById<View>(R.id.time) as CardView
        length = findViewById<View>(R.id.length) as CardView
        area = findViewById<View>(R.id.area) as CardView
        temperature = findViewById<View>(R.id.temperature) as CardView
        currency!!.setOnClickListener(this)
        weight!!.setOnClickListener(this)
        time!!.setOnClickListener(this)
        length!!.setOnClickListener(this)
        area!!.setOnClickListener(this)
        temperature!!.setOnClickListener(this)



    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
          when(item.itemId){
              R.id.exit -> {
                  rewardedAd?.let { ad ->
                      ad.show(this, OnUserEarnedRewardListener { rewardItem ->
                          // Handle the reward.
                          val rewardAmount = rewardItem.amount
                          val rewardType = rewardItem.type

                      })
                  } ?: run {

                  }
                 finish()

              }

              R.id.about -> {
                  rewardedAd?.let { ad ->
                      ad.show(this, OnUserEarnedRewardListener { rewardItem ->
                          // Handle the reward.
                          val rewardAmount = rewardItem.amount
                          val rewardType = rewardItem.type

                      })
                  } ?: run {

                  }
                  val intent = Intent(this, AboutActivity::class.java)
                  startActivity(intent)

              }


          }
        return super.onOptionsItemSelected(item)


    }

    override fun onClick(v: View) {


        if (v.id == R.id.currency) {
            if (mInterstitialAd != null) {
                mInterstitialAd?.show(this)
            } else {

            }
            val intent = Intent(this@MainActivity, CurrencyActivity::class.java)

            startActivity(intent)
        }
        if (v.id == R.id.weight) {
            if (mInterstitialAd != null) {
                mInterstitialAd?.show(this)
            } else {

            }
            val intent = Intent(this@MainActivity, WeightActivity::class.java)

            startActivity(intent)
        }
        if (v.id == R.id.time) {
            if (mInterstitialAd != null) {
                mInterstitialAd?.show(this)
            } else {

            }
            val intent = Intent(this@MainActivity, TimeActivity::class.java)
           /* intent.putExtra("key", "Time Converter")*/
            startActivity(intent)
        }
        if (v.id == R.id.length) {
            if (mInterstitialAd != null) {
                mInterstitialAd?.show(this)
            } else {

            }
            val intent = Intent(this@MainActivity, LengthActivity::class.java)
           /* intent.putExtra("key", "Length Converter")*/
            startActivity(intent)
        }
        if (v.id == R.id.area) {
            if (mInterstitialAd != null) {
                mInterstitialAd?.show(this)
            } else {

            }
            val intent = Intent(this@MainActivity, AreaActivity::class.java)
           /* intent.putExtra("key", "Area Converter")*/
            startActivity(intent)
        }
        if (v.id == R.id.temperature) {
            if (mInterstitialAd != null) {
                mInterstitialAd?.show(this)
            } else {

            }
            val intent = Intent(this@MainActivity, TemperatureActivity::class.java)
            /*intent.putExtra("key", "Temperature Converter")*/
            startActivity(intent)
        }
    }
}