package com.example.dieteatinghabits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.transition.FragmentTransitionSupport
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 첫번째 소개페이지 , 머먹을지 추천, 다이어트 하루 식습관, 어제먹은 칼로리
        // 두번째 다이어트 음식,간식
        // 세 번째 오늘 쳐먹은거 ex.물마신양,오늘쳐먹은 칼로리 계산,

        var main = findViewById<BottomNavigationView>(R.id.bottonavi)



        main.run {
            setOnNavigationItemSelectedListener {
                when(it.itemId) {
                    R.id.first -> {
                        val MainFragment1 = MainFragment1()
                        supportFragmentManager.beginTransaction().replace(R.id.container, MainFragment1).commit()
                    }
                    R.id.second -> {
                        val MainFragment2 = MainFragment2()
                        supportFragmentManager.beginTransaction().replace(R.id.container, MainFragment2).commit()
                    }
                    R.id.third -> {
                        val MainFragment3 = MainFragment3()
                        supportFragmentManager.beginTransaction().replace(R.id.container, MainFragment3).commit()
                    }
                }
                true
            }
            selectedItemId = R.id.first
        }
    }
}