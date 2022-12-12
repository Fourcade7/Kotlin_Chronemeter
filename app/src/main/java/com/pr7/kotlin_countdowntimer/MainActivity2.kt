package com.pr7.kotlin_countdowntimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    lateinit var chronemeter: Chronometer
    lateinit var buttonshow: Button
    lateinit var buttonstart: Button
    lateinit var buttonpause: Button
    lateinit var buttonstop: Button
    lateinit var textView: TextView

    var lastpause=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        textView=findViewById(R.id.textviewshowtime)
        chronemeter=findViewById(R.id.chronemeter2)
        buttonshow=findViewById(R.id.buttonshow2)
        buttonstart=findViewById(R.id.buttonstart2)
        buttonpause=findViewById(R.id.buttonpause2)
        buttonstop=findViewById(R.id.buttonstop2)

        chronemeter.base = SystemClock.elapsedRealtime()+1*60*1000+lastpause
        chronemeter.start()

        chronemeter.setOnChronometerTickListener {
            val time=(it.base-SystemClock.elapsedRealtime()).toInt()/1000
            if (time<1){
                chronemeter.stop()//when->countdown=false
            }
            Toast.makeText(this,"${chronemeter.text}",Toast.LENGTH_SHORT).show()

        }

        buttonstart.setOnClickListener {

            start()
        }
        buttonshow.setOnClickListener {
            showtime()
        }
        buttonpause.setOnClickListener {
            pause()
        }


    }

    fun showtime(){
        //val time=SystemClock.elapsedRealtime()-chronemeter.base
        //Toast.makeText(this,"${time/1000}",Toast.LENGTH_SHORT).show()
        Toast.makeText(this,"${SystemClock.elapsedRealtime()}\n${chronemeter.base}\n${SystemClock.elapsedRealtime()-chronemeter.base}", Toast.LENGTH_SHORT).show()
        textView.text="${SystemClock.elapsedRealtime()}\n${chronemeter.base}\n${chronemeter.base-SystemClock.elapsedRealtime()}"
    }




    fun start(){
        chronemeter.base = SystemClock.elapsedRealtime()+lastpause
        chronemeter.start()
    }
    fun pause(){
        lastpause=(chronemeter.base-SystemClock.elapsedRealtime().toInt()).toInt()
        chronemeter.stop()
    }


}