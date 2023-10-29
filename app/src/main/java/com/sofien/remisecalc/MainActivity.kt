package com.sofien.remisecalc

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.sofien.remisecalc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val value = binding.value
        val seekBar = binding.seekBar
        val seekBarValue = binding.seekbarValue
        val discount = binding.discount
        val total = binding.total
        total.isEnabled = false //make the total field readonly
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                seekBarValue.text = "$progress%"
                //TODO : Fix this
                discount.setText("$value".toInt().toString())
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                Toast.makeText(this@MainActivity, "working", Toast.LENGTH_LONG)

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                Toast.makeText(this@MainActivity, "working", Toast.LENGTH_LONG)
            }
        })

    }
}