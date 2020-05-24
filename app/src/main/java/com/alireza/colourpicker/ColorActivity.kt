package com.alireza.colourpicker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.graphics.Color
import kotlinx.android.synthetic.main.activity_color.*


class ColorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)

        val intent = intent

        val aColor = intent.getIntExtra("alphaColor", 255)
        val rColor = intent.getIntExtra("redColor",255)
        val gColor = intent.getIntExtra("greenColor",255)
        val bColor = intent.getIntExtra("blueColor",255)
        val brightness = intent.getIntExtra("blueColor",100)

        color_activity.setBackgroundColor(Color.argb(aColor, rColor, gColor, bColor))
        setBrightness(brightness)
    }

    private fun setBrightness(brightness: Int){
        val lp = window.attributes
        lp.screenBrightness = brightness / 100.0f
        window.attributes = lp
    }
}
