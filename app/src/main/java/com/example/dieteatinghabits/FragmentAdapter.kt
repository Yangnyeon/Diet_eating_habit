package com.example.dieteatinghabits

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.pager.view.*

class FragmentAdapter: PagerAdapter() {

    ///첫번째페이지 뷰페이져

    private var context1 : Context?= null

    private var imglist = arrayListOf<Int>(R.drawable.img1,R.drawable.img2, R.drawable.img3)

    fun ViewpatgerAdapter(context: Context) {
        context1 = context
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var view = LayoutInflater.from(container.context).inflate(R.layout.pager, container,false)

        var item = imglist
        view.img.setImageResource(item[position])
        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }


    override fun getCount(): Int {
        return 3
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return (view == `object`)
    }
}