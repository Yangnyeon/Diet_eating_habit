package com.example.dieteatinghabits

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class CustomAdapter(context: Context, image: ArrayList<Int>, arrayList: ArrayList<HashMap<String, String>>) : BaseAdapter() {


    var image = image
    var arrayList = arrayList
    var context = context


    var tempArrayList = ArrayList(image)
    var tempNameVersionList = ArrayList(arrayList)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var myview = convertView
        val holder: ViewHolder

        if (convertView == null) {

            val mInflater = (context as Activity).layoutInflater


            myview = mInflater!!.inflate(R.layout.list_row, parent, false)
            holder = ViewHolder()
            holder.mImageView = myview!!.findViewById<ImageView>(R.id.imageview) as ImageView
            holder.mHeader = myview!!.findViewById<TextView>(R.id.title) as TextView
            holder.mSubHeader = myview!!.findViewById<TextView>(R.id.text) as TextView


            myview.setTag(holder)
        } else {
            holder = myview!!.getTag() as ViewHolder
        }

        val map = arrayList.get(position)
        holder.mImageView!!.setImageResource(image[position])
        holder.mHeader!!.setText(map.get("title"))
        holder.mSubHeader!!.setText(map.get("text"))

        return myview

    }


    override fun getItem(p0: Int): Any {
        return arrayList[p0]
    }


    override fun getItemId(p0: Int): Long {
        return 0
    }



    override fun getCount(): Int {
        return arrayList.size
    }


    class ViewHolder {
        var mImageView: ImageView? = null
        var mHeader: TextView? = null
        var mSubHeader: TextView? = null
    }



    fun filter(text: String?) {
        val text = text!!.toLowerCase(Locale.getDefault())
        image.clear()
        arrayList.clear()


        if (text.isEmpty()) {

            image.addAll(tempArrayList)
            arrayList.addAll(tempNameVersionList)


        } else {


            for (i in 0 until tempNameVersionList.size) {

                if (tempNameVersionList[i]["title"]!!.toLowerCase(Locale.getDefault()).contains(text)) {

                    image.add(tempArrayList[i])
                    arrayList.add(tempNameVersionList[i])


                }


            }
        }
        notifyDataSetChanged()


    }


}