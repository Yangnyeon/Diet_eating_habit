package com.example.dieteatinghabits

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.fragment_main2.*
import com.google.android.material.tabs.TabLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"



/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment2 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var myFragment: View
    lateinit var viewPagers: ViewPager
    lateinit var tabLayouts: TabLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =  inflater.inflate(R.layout.fragment_main2, container, false)

        val listview = view.findViewById(R.id.listView) as ListView
        val searchView = view.findViewById(R.id.searchView) as SearchView

        val image = ArrayList<Int>()
        image.add(R.drawable.almond)
        image.add(R.drawable.banana)
        image.add(R.drawable.egg)
        image.add(R.drawable.greentea)
        image.add(R.drawable.salmon)

        val title = arrayOf("아몬드", "바나나", "계란", "녹차", "연어")

        val text = arrayOf("하루 권장량 25알 기준 : 150kcal ", "88kcal", "155kcal", "180ml 기준 : 1kcal", "100g당 146kcal")


        val info = ArrayList<HashMap<String, String>>()


        var hashMap: HashMap<String, String> = HashMap<String, String>()

        for (i in 0 until title.size) {
            hashMap = HashMap<String, String>()
            hashMap.put("title", title[i])
            hashMap.put("text", text[i])


            info.add(hashMap)

        }


        val customAdapter = CustomAdapter(requireActivity(), image, info)



        listview.adapter = customAdapter


        listview.setOnItemClickListener { adapterView, view, position, l ->


            val hashMap: HashMap<String, String> = customAdapter.getItem(position) as HashMap<String, String>


        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                val text = newText

                customAdapter.filter(text)
                return false
            }
        })

        return view


    }





    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}