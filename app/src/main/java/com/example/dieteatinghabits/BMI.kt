package com.example.dieteatinghabits

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import androidx.core.util.rangeTo
import androidx.core.view.isVisible
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
            bmirange.visibility = View.VISIBLE
        }

        bmirange.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("  BMI 등급표 정리 ")
                .setMessage("0 ~ 18.5 : 저체중 , 18.5 ~ 25 : 정상 , 25 ~ 30 : 과체중 , 30 ~ 35 : 경도비만, 35 ~ 40 : 중등도 비만, 40 ~ : 고도비만")

                .setPositiveButton("확인",
                    DialogInterface.OnClickListener { dialog, id ->
                    })
            // 다이얼로그를 띄워주기
            builder1.show()
        }

    }
}