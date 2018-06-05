package com.minhtetoo.myfirstkotlinapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import com.minhtetoo.myfirstkotlinapp.R
import com.minhtetoo.myfirstkotlinapp.data.vos.Forecast
import com.minhtetoo.myfirstkotlinapp.data.vos.ForecastList
import com.minhtetoo.myfirstkotlinapp.utils.ctx
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

class ForeCastListAdapter(val weekForecast: ForecastList,
                                 val itemClick: ForeCastListAdapter.OnItemClickListener) :
        RecyclerView.Adapter<ForeCastListAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast.dailyForecast[position])
    }

    override fun getItemCount(): Int {
        weekForecast.dailyForecast.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_item_forecast_list, parent, false)
        return ViewHolder(view, itemClick)
    }


    class ViewHolder(view: View, val itemClick: AdapterView.OnItemClickListener) :
            RecyclerView.ViewHolder(view) {
        private val iconView = view.find<ImageView>(R.id.icon)
        private val dateView = view.find<TextView>(R.id.date)
        private val descriptionView =
                view.find<TextView>(R.id.description)
        private val maxTemperatureView =
                view.find<TextView>(R.id.maxTemperature)
        private val minTemperatureView =
                view.find<TextView>(R.id.minTemperature)
        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "$high"
                minTemperatureView.text = "$low"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }

    interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)
    }
}