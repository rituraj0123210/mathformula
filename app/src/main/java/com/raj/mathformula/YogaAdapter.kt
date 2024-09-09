package com.raj.mathformula

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat

class YogaAdapter(var yogaActivity: YogaActivity, var title: Array<String>) : BaseAdapter() {
    @JvmField
    var animation: Animation? = null
    override fun getCount(): Int {
        return title.size
    }

    override fun getItem(i: Int): Any {
        return i
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
        var mView = view
        mView = LayoutInflater.from(yogaActivity).inflate(R.layout.new_item_layout, viewGroup, false)
        animation = AnimationUtils.loadAnimation(yogaActivity, R.anim.animation1)
        val textView: TextView
        val ll_bg: LinearLayout
        ll_bg = mView.findViewById(R.id.ll_bg)
        textView = mView.findViewById(R.id.textView)
        val number = getRandom(8)
        if (number == 1) {
            ll_bg.background = ContextCompat.getDrawable(yogaActivity, R.drawable.gradient)
        } else if (number == 2) {
            ll_bg.background = ContextCompat.getDrawable(yogaActivity, R.drawable.gradient_2)
        } else if (number == 3) {
            ll_bg.background = ContextCompat.getDrawable(yogaActivity, R.drawable.gradient_3)
        } else if (number == 4) {
            ll_bg.background = ContextCompat.getDrawable(yogaActivity, R.drawable.gradient_4)
        } else if (number == 5) {
            ll_bg.background = ContextCompat.getDrawable(yogaActivity, R.drawable.gradient_5)
        } else if (number == 6) {
            ll_bg.background = ContextCompat.getDrawable(yogaActivity, R.drawable.gradient_6)
        } else if (number == 7) {
            ll_bg.background = ContextCompat.getDrawable(yogaActivity, R.drawable.gradient_7)
        } else if (number == 8) {
            ll_bg.background = ContextCompat.getDrawable(yogaActivity, R.drawable.gradient_8)
        } else {
            ll_bg.background = ContextCompat.getDrawable(yogaActivity, R.drawable.snow_bg)
        }
        textView.text = title[i]
        textView.animation = animation

        // Adding onClickListener to each item in the ListView
//        mView.setOnClickListener {
//            when(title[i]) {
//                "Bhujangasana" -> {
//                    val intent = Intent(yogaActivity, Bhujangasana::class.java)
//                    yogaActivity.startActivity(intent)
//                }
//                "Dhanurasana" -> {
//                    val intent = Intent(yogaActivity, Dhanurasana::class.java)
//                    yogaActivity.startActivity(intent)
//                }
//                // Add more cases for other items in the list
//            }
//        }
        return mView
    }

    companion object {
        @JvmStatic
        fun getRandom(max: Int): Int {
            return (Math.random() * max).toInt()
        }
    }
}