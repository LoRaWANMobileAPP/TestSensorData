package com.example.testsensordata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlin.random.Random
import android.os.Handler

class MainActivity : AppCompatActivity() {
    private lateinit var tvsensor: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvsensor =findViewById(R.id.tvSensorData)

        //Create a handler to update the textview every second.
        val handler = Handler()
        val delayMillis = 1000L

        //create a runnable to update the textview.

        val UpdateTextViewRunnable = object: Runnable{
            override fun run() {
                val sensorValue = sensorData()
                tvsensor.text = "Sensor Data: $sensorValue"
                handler.postDelayed(this, delayMillis)
            }
        }
        //start updating the textview
        handler.postDelayed(UpdateTextViewRunnable, delayMillis)

    }
    private fun sensorData(): Float {
        var sensor: Float       //Declare an float value
        var max = 35
        var min = 20
        sensor = min+Random.nextFloat()*(max-min)
        return sensor

    }
}