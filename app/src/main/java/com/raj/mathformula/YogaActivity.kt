package com.raj.mathformula

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds


class YogaActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var title: Array<String>
    lateinit var mAdView: AdView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yoga)
//        supportActionBar?.hide()


        MobileAds.initialize(this,) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        listView = findViewById(R.id.list_view)
        title = resources.getStringArray(R.array.title)

        val adapter = YogaAdapter(this@YogaActivity, title)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, i, _ ->
            val selectedItem = title[i]

            val selectedHtmlFile = when (selectedItem) {
                "Logarithm" -> "log.html"
                "Trignomerty" -> "trigo.html"
                "Quadratic" -> "quadratic.html"
                "Determinant and Matrices" -> "determinant.html"
                "Straight Line" -> "straightline.html"
                "Circle" -> "circle.html"
                "3D" -> "3d.html"
                "aod" -> "aod.html"
                "Area Under Curve" -> "areaundercurve.html"
                "Continuity - Differentiability" -> "continuitydifferentiability.html"
                "Differential Equation" -> "differentialequation.html"
                "Differentiation" -> "differentiation.html"
                "Ellipse" -> "ellipse.html"
                "Function" -> "function.html"
                "Hyperbola" -> "hyperbola.html"
                "Integration" -> "integration.html"
                "ITF" -> "itf.html"
                "Limit" -> "limit.html"
                "Mathematical Reasoning" -> "mathematicalreasoning.html"
                "Parabola" -> "parabola.html"
                "Probability" -> "probability.html"
                "Relation" -> "relations.html"
                "Set" -> "set.html"
                "Statistics" -> "statistics.html"
                "Vector" -> "vector.html"
                "Binomial" -> "binomial.html"
                "Complex Number" -> "complex.html"
                "Permutation - Combination" -> "pnc.html"
                "Sequence Series" -> "sequence.html"

                else -> "default.html"
            }
            val intent = Intent(this@YogaActivity, HtmlActivity::class.java)
            intent.putExtra("file_name", selectedHtmlFile)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.share_app -> {
                val appPackageName = packageName
                try {
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "All Maths Formulas")
                    var shareMessage = "Let me recommend you this application\n\n"
                    shareMessage += "https://play.google.com/store/apps/details?id=$appPackageName"

                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                    startActivity(Intent.createChooser(shareIntent, "Choose one"))
                    true
                } catch (e: Exception) {
                    e.printStackTrace()
                    false // Return false to indicate that the item was not handled
                }
            }

            R.id.nav_privacy -> {
                val privacyUrl = "https://irockyapps.blogspot.com/p/this-privacy-policy-applies-to.html"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(privacyUrl)
                startActivity(intent)
                true
            }


            R.id.rate_app -> {
                // Open the Play Store page for rating the app
                val appPackageName = packageName
                try {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$appPackageName")))
                } catch (e: ActivityNotFoundException) {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")))
                }
                true
            }

            R.id.update_app -> {
                // Open the Play Store page for rating the app
                val appPackageName = packageName
                try {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$appPackageName")))
                } catch (e: ActivityNotFoundException) {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")))
                }
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }



}