package com.example.dieteatinghabits

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AlertDialogLayout
import androidx.cardview.widget.CardView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.diettip.*
import kotlinx.android.synthetic.main.diettip.view.*
import kotlinx.android.synthetic.main.fragment_main1.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var currentPosition = 0



    val handler = Handler(Looper.getMainLooper()) {
        setPage()
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view =  inflater.inflate(R.layout.fragment_main1, container, false)
        var view2 = inflater.inflate(R.layout.diettip, container, false)


        //

        var viewPager11 = view.findViewById<ViewPager>(R.id.viewpager11)
        var weight_history = view.findViewById<CardView>(R.id.weight_history)

        val adapter11 = FragmentAdapter()
        viewPager11.adapter = adapter11

        val thread = Thread(PagerRunnable())
        thread.start()

        //

        var habit = view.findViewById<CardView>(R.id.habit)


        habit.setOnClickListener {

            var dialogView:View = layoutInflater.inflate(R.layout.diettip, null)
            var builder = AlertDialog.Builder(view2.context)
            builder.setView(dialogView)
                .setPositiveButton("확인",
                    DialogInterface.OnClickListener { dialog, id ->
                    })
            builder.show()
        }


        weight_history.setOnClickListener {
            var intent3 = Intent(requireActivity(), weight::class.java)
            startActivity(intent3)
        }




        return view
    }

    //

    private fun setPage() {
        if(currentPosition == 3 ) {
            currentPosition = 0
        }
        if(viewpager11 != null) {
            viewpager11.setCurrentItem(currentPosition, true)
        }

        currentPosition += 1
    }

    inner class PagerRunnable : Runnable {
        override fun run() {
            while(true) {
            Thread.sleep(3000)
            handler.sendEmptyMessage(0)
            }
        }
    }

    //

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}