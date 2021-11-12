package com.example.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.GeneratedAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.adapter.TemperatureAdapter
import com.example.weatherapp.modals.Hour
import com.example.weatherapp.networking.WeatherService
import com.example.weatherapp.repo.WeatherRepository
import com.example.weatherapp.viewModels.WeatherViewModel
import com.example.weatherapp.viewModels.WeatherViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var nameOfCity : String

    lateinit var mAdapter: TemperatureAdapter

    lateinit var list : ArrayList<Pair>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        mAdapter = TemperatureAdapter()
        val layoutManager = LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false)
        recycler.layoutManager = layoutManager
        recycler.adapter = mAdapter

        val weatherInstance = WeatherService.getInstance()
        val repository = WeatherRepository(weatherInstance)
        val viewModel = ViewModelProvider(this, WeatherViewModelFactory(repository)).get(WeatherViewModel::class.java)

        button.setOnClickListener {
            nameOfCity = editText.text.toString()
            editText.visibility = View.GONE
            button.visibility = View.GONE
            viewModel.getCurrTemp("f5f79c7077e3422fb67153224210510",nameOfCity,7)
            city.visibility = View.VISIBLE
        }

        city.setOnClickListener {
            editText.visibility = View.VISIBLE
            button.visibility = View.VISIBLE
            city.visibility = View.GONE
            editText.text.clear()
        }

        val cityList = ArrayList<String>()
        temperature.setOnClickListener {
            cityList.add(city.text.toString())
        }

        imageView.setOnClickListener {
            val intent = Intent(this , ListActivity::class.java)
            intent.putExtra("city_list" , cityList)
            startActivity(intent)
        }

        list = ArrayList<Pair>()
        viewModel.weather.observe(this , Observer {
            city.text = it.location.name
            temperature.text = it.current.temp_c.toString()
            type.text = it.current.condition.text
            date.text = it.location.localtime
            temp.text = it.current.temp_c.toString()
            humid.text = it.current.humidity.toString()
            wind.text = it.current.wind_kph.toString()
            uv.text = it.current.uv.toString()
            visibility.text = it.current.vis_km.toString()
            pressure.text = it.current.pressure_mb.toString()
            max.text = it.forecast.forecastday[0].day.maxtemp_c.toString()
            min.text = it.forecast.forecastday[0].day.mintemp_c.toString()
            val hour : ArrayList<Hour> = it.forecast.forecastday[0].hour as ArrayList<Hour>
            for(i in 1..10){
                list.add(Pair(hour[i].temp_c , hour[i].time))
            }
            mAdapter.getAllList(list)
        })

        viewModel.getCurrTemp("f5f79c7077e3422fb67153224210510","Ranchi",7)

    }
}

class Pair(val temp : Double , val date : String)