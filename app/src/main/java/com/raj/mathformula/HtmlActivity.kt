package com.raj.mathformula

import android.os.Bundle
import android.webkit.WebView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class HtmlActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    lateinit var mAdView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_html)

        supportActionBar?.hide()
        MobileAds.initialize(this,) {}


        webView = findViewById(R.id.web_view)

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        val fileName = intent.getStringExtra("file_name")
        fileName?.let {
            val fileUrl = "file:///android_asset/$it"
//            webView.settings.builtInZoomControls = true
//            webView.settings.displayZoomControls = true
            webView.settings.javaScriptEnabled = true
            webView.settings.builtInZoomControls = true
            webView.settings.displayZoomControls = false
            webView.settings.setSupportZoom(true)
            webView.loadUrl(fileUrl)
        }
    }
}


//import android.os.Bundle
//import android.webkit.WebSettings
//import android.webkit.WebView
//import android.webkit.WebViewClient
//import androidx.appcompat.app.AppCompatActivity
//
//class HtmlActivity : AppCompatActivity() {
//    private lateinit var webView: WebView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_html)
//
//        supportActionBar?.hide()
//
//        webView = findViewById(R.id.web_view)
//        val fileName = intent.getStringExtra("file_name")
//        fileName?.let {
//            val fileUrl = "file:///android_asset/$it"
//            webView.settings.javaScriptEnabled = true // Enable JavaScript if needed
//            webView.settings.setSupportZoom(true) // Enable zoom support
//            webView.settings.builtInZoomControls = true // Display zoom controls
//            webView.settings.displayZoomControls = false // Hide the default zoom controls
//            webView.settings.loadWithOverviewMode = true
//            webView.settings.useWideViewPort = true
//
//            webView.loadUrl(fileUrl)
//
//            // Handle navigation in the WebView itself
//            webView.webViewClient = WebViewClient()
//        }
//    }
//
//    override fun onBackPressed() {
//        if (webView.canGoBack()) {
//            webView.goBack()
//        } else {
//            super.onBackPressed()
//        }
//    }
//}
