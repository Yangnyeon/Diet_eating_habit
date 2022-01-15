package com.example.dieteatinghabits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.core.util.rangeTo
import kotlinx.android.synthetic.main.activity_bmi.*

class BMI : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)



        var weightnum = findViewById<EditText>(R.id.weight)
        var wheelnum = findViewById<EditText>(R.id.wheel)
        var bmiresult1 = String



        cal.setOnClickListener {
            var num1 = weightnum.text.toString()
            var num2 = wheelnum.text.toString()

            var realwheel = num2.toString().toInt() * num2.toString().toInt()
            var realresult:Float
            var realrealresult:Float
            var BMI = String()

            realresult = num1.toString().toInt() / realwheel.toFloat()
            realrealresult = realresult * 10000
            BMI = realrealresult.toString().substring(0..4)


            result.text = "결과 : " + BMI.toDouble().toString()
            when {
                18.5 > BMI.toFloat() -> {
                    bmiresult.text = "당신은 저체중입니다."
                }
                25 > BMI.toFloat() -> {
                    bmiresult.text = "당신은 정상입니다."
                }
                30 > BMI.toFloat()  -> {
                    bmiresult.text = "당신은 과제중입니다."
                }
                35 > BMI.toFloat() -> {
                    bmiresult.text = "당신은 경도비만입니다."
                }
                40 > BMI.toFloat() -> {
                    bmiresult.text = "당신은 중등도 비만입니다."
                }
                else -> {
                    bmiresult.text = "당신은 고도비만입니다."
                }
            }

        }

    }
}