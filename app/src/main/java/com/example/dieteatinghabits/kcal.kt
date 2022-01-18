package com.example.dieteatinghabits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_kcal.*

class kcal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kcal)



            rdogrp.setOnCheckedChangeListener { radioGroup, i ->
                when(i) {
                    R.id.btn1 -> {
                        var finalresult = ((wheel2.text.toString().toInt() - 100) * 0.9)  * 25
                        calbtn.setOnClickListener {
                            kcalresult.text = finalresult.toString().toDouble().toString()
                        }
                    }
                    R.id.btn2 -> {
                        var finalresult = ((wheel2.text.toString().toInt() - 100) * 0.9) * 35
                        calbtn.setOnClickListener {
                            kcalresult.text = finalresult.toString().toDouble().toString()
                        }
                    }
                    R.id.btn3 -> {
                        var finalresult = ((wheel2.text.toString().toInt() - 100) * 0.9) * 40
                        calbtn.setOnClickListener {
                            kcalresult.text = finalresult.toString().toDouble().toString()
                        }
                    }
                }
            }


    }
}