package com.example.testsensordata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlin.random.Random
import android.os.Handler

private const val initialValue = "20"
class MainActivity : AppCompatActivity() {
    private lateinit var tvsensor: TextView
    private lateinit var tvTempOut: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvsensor =findViewById(R.id.tvSensorData)
        tvTempOut = findViewById(R.id.tvTempOut)

        //Create a handler to update the textview every second.
        val handler = Handler()
        val delayMillis = 1000L

        //create a runnable to update the textview.

        val UpdateTextViewRunnable = object: Runnable{
            override fun run() {
                val sensorValue = sensorData()
                val outTemp = sensorData()
                tvsensor.text = "%.2f".format(sensorValue)+" °C"
                tvTempOut.text = "%.2f".format(outTemp)+" °C"
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
    private fun DoorSim(): Int{

        return TODO("Provide the return value")
    }
}