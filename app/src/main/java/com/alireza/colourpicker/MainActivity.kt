package com.alireza.colourpicker

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.SeekBar
import com.alireza.colourpicker.Utilities.InputFilterMinMax
import kotlinx.android.synthetic.main.activity_main.*
import android.view.WindowManager




class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setBrightness(100)

        editA.filters = arrayOf(InputFilterMinMax(0, 255))
        editR.filters = arrayOf(InputFilterMinMax(0, 255))
        editG.filters = arrayOf(InputFilterMinMax(0, 255))
        editB.filters = arrayOf(InputFilterMinMax(0, 255))

        editA.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                seekA.progress = s.toString().toInt()
            }
        })

        editR.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                seekR.progress = s.toString().toInt()
            }
        })

        editG.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                seekG.progress = s.toString().toInt()
            }
        })

        editB.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                seekB.progress = s.toString().toInt()
            }
        })


        seekA.setOnSeekBarChangeListener(this)
        seekR.setOnSeekBarChangeListener(this)
        seekG.setOnSeekBarChangeListener(this)
        seekB.setOnSeekBarChangeListener(this)
        brightnessBar.setOnSeekBarChangeListener(this)

        fullscreenButton.setOnClickListener {
            var myIntent = Intent(this, ColorActivity::class.java)
            myIntent.putExtra("alphaColor", seekA.progress)
            myIntent.putExtra("redColor", seekR.progress)
            myIntent.putExtra("greenColor", seekG.progress)
            myIntent.putExtra("blueColor", seekB.progress)
            myIntent.putExtra("brightness", brightnessBar.progress)

            startActivity(myIntent)
        }
    }

    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromTouch: Boolean) {
        //Get the chnaged value
        when (seekBar) {
            seekA -> {
                seekA.progress =  progress
                editA.setText(progress.toString())
            }
            seekR -> {
                seekR.progress = progress
                editR.setText(progress.toString())
            }
            seekG -> {
                seekG.progress = progress
                editG.setText(progress.toString())
            }
            seekB -> {
                seekB.progress = progress
                editB.setText(progress.toString())
            }
            brightnessBar -> brightnessBar.progress = progress
        //Build and show the new color
        //show the color value
//        ShowColor.setText("0x" + String.format("%02x", A) + String.format("%02x", R)
//                + String.format("%02x", G) + String.format("%02x", B))
//        //some math so text shows (needs improvement for greys)
//        ShowColor.setTextColor(Color.argb(0xff, 255 - R, 255 - G, 255 - B))
        }
        //Build and show the new color
        setBrightness(brightnessBar.progress);

        main_activity.setBackgroundColor(Color.argb(seekA.progress, seekR.progress, seekG.progress, seekB.progress))
        //show the color value
//        ShowColor.setText("0x" + String.format("%02x", A) + String.format("%02x", R)
//                + String.format("%02x", G) + String.format("%02x", B))
//        //some math so text shows (needs improvement for greys)
//        ShowColor.setTextColor(Color.argb(0xff, 255 - R, 255 - G, 255 - B))
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {
    }

    override fun onStopTrackingTouch(p0: SeekBar?) {
    }

    private fun setBrightness(brightness: Int){
        val lp = window.attributes
        lp.screenBrightness = brightness / 100.0f
        window.attributes = lp
    }
}
