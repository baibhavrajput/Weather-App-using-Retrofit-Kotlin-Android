package com.example.weatherapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.Pair
import com.example.weatherapp.R

class CityAdapter : RecyclerView.Adapter<CityViewHolder>() {

    private val list = HashSet<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_city, parent, false)
        return CityViewHolder(view)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val s = list.elementAt(position)
        holder.city.text = s
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun getAllCity(mList : HashSet<String>){
        list.clear()
        list.addAll(mList)
        notifyDataSetChanged()
    }

}

class CityViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val city : TextView = view.findViewById(R.id.bokaro)
}