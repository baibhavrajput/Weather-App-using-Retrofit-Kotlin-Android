package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.adapter.CityAdapter
import com.example.weatherapp.adapter.TemperatureAdapter
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.activity_main.*

class ListActivity : AppCompatActivity() {

    lateinit var mAdapter: CityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val bundle : Bundle? = intent.extras
        val cityList : ArrayList<String> = bundle?.getStringArrayList("city_list") as ArrayList<String>

        val h = HashSet<String>()
        for(element in cityList){
            h.add(element)
        }

        mAdapter = CityAdapter()
        val layoutManager = LinearLayoutManager(this)
        cityRecycle.layoutManager = layoutManager
        cityRecycle.adapter = mAdapter

        mAdapter.getAllCity(h)

    }
}