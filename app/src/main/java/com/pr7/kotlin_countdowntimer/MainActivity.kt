package com.pr7.kotlin_countdowntimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.Chronometer
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var chronemeter:Chronometer
    lateinit var buttonshow: Button
    lateinit var buttonstart: Button
    lateinit var buttonpause: Button
    lateinit var buttonstop: Button
    var lastpause=0
    var anytime=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chronemeter=findViewById(R.id.chronemeter1)
        buttonshow=findViewById(R.id.buttonshow)
        buttonstart=findViewById(R.id.buttonstart)
        buttonpause=findViewById(R.id.buttonpause)
        buttonstop=findViewById(R.id.buttonstop)

        //chronemeter.base = SystemClock.elapsedRealtime()+180*1000


        chronemeter.setOnChronometerTickListener {
            //val time=(SystemClock.elapsedRealtime()-it.base).toInt()/1000
//            if (time==10){
//                chronemeter.stop()//when->countdown=false
//            }
            //Toast.makeText(this,"${chronemeter.text}",Toast.LENGTH_SHORT).show()

        }

        buttonshow.setOnClickListener {
            val time=SystemClock.elapsedRealtime()-chronemeter.base
            Toast.makeText(this,"${time/1000}",Toast.LENGTH_SHORT).show()
        }

        buttonstart.setOnClickListener {

            chronemeter.base =(SystemClock.elapsedRealtime()-lastpause)
            chronemeter.start()
        }
        buttonpause.setOnClickListener {
            lastpause= (SystemClock.elapsedRealtime()-chronemeter.base).toInt()
            chronemeter.stop()
        }
        buttonstop.setOnClickListener {
            chronemeter.base =SystemClock.elapsedRealtime()
            lastpause=0
            chronemeter.stop()
        }








    }


    fun customCountDownTimer(minute:Int){
        var second=minute*60*1000

        val timer=object : CountDownTimer(second.toLong(),1000){
            override fun onTick(millisUntilFinished: Long) {
                Log.d("PR77777 ", "minute: ${millisUntilFinished/1000}")
            }
            override fun onFinish() {
                Log.d("PR77777 ", "minute")
            }
        }
        timer.start()

    }


}