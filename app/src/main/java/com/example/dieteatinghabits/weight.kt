package com.example.dieteatinghabits

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_weight.*
import java.util.*
import kotlin.collections.ArrayList
import android.view.View

import android.widget.AdapterView

import android.widget.AdapterView.OnItemLongClickListener




class weight : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weight)

        val instance = Calendar.getInstance()
        val yearr = instance.get(Calendar.YEAR).toString() + "년 "
        val monthh = (instance.get(Calendar.MONTH) + 1).toString() + "월 "
        val datee = instance.get(Calendar.DATE).toString() + "일 "

        var arraylist = ArrayList<String>()

        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arraylist)

        weigh_listview.adapter = adapter

        add.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            var View = layoutInflater.inflate(R.layout.dialog, null)
            var txt1 = View.findViewById<TextView>(R.id.txt1)
            var edt1 = View.findViewById<EditText>(R.id.edt1)
            var txt2 = View.findViewById<TextView>(R.id.txt2)

            builder.setView(View)
                .setPositiveButton("확인",
                    DialogInterface.OnClickListener { dialog, id ->
                        arraylist.add(yearr + monthh + datee + edt1.text.toString() + "Kg")
                        adapter.notifyDataSetChanged();
                    })
                .setNegativeButton("취소") { dialogInterface, i ->
                }
            builder.show()
        }

        weigh_listview.onItemLongClickListener =
            OnItemLongClickListener { parent, view, position, id ->
                arraylist.removeAt(position)
                adapter.notifyDataSetChanged()
                true
            }

    }
}