package com.raj.mathformula

import android.app.Application
import android.content.Context
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.appopen.AppOpenAd


class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        try {
            MobileAds.initialize(this) {}
            AppOpenAdManager(this)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}
