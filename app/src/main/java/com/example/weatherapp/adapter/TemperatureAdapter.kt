package com.example.weatherapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.Pair
import com.example.weatherapp.R
import kotlinx.android.synthetic.main.activity_forecast.view.*

class TemperatureAdapter : RecyclerView.Adapter<TempViewHolder>() {

    private val list = ArrayList<Pair>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TempViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_forecast, parent, false)
        return TempViewHolder(view)
    }

    override fun onBindViewHolder(holder: TempViewHolder, position: Int) {
        val p = list[position]
        holder.temp.text = p.temp.toString()
        holder.time.text = p.date
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun getAllList(mList : List<Pair>){
        list.clear()
        list.addAll(mList)
        notifyDataSetChanged()
    }

}

class TempViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val temp : TextView = view.findViewById(R.id.tem)
    val time : TextView = view.findViewById(R.id.time)
}