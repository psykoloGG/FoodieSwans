package com.example.foodreviewapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RestaurantAdapter(private val ImageArrayList: MutableList<RestaurantModel>) :
    RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return ImageArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Info = ImageArrayList[position]

        holder.ImgView.setImageResource(Info.GetImage())
        holder.TxtView.text = Info.GetName()
        holder.locView.text = Info.GetDistance()
        holder.statusView.text = Info.GetStatus()
        holder.priceView.text = Info.GetPrice()
        holder.diningTypeView.text = Info.GetDiningType()
        holder.ratingView.text = Info.GetRating()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val Inflater = LayoutInflater.from(parent.context)
        val View = Inflater.inflate(R.layout.restaurant_row_layout, parent, false)

        return ViewHolder(View)
    }
    inner class ViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ImgView = itemView.findViewById<View>(R.id.restaurantImage) as ImageView
        var TxtView = itemView.findViewById<View>(R.id.restaurantName) as TextView
        var locView = itemView.findViewById<View>(R.id.restaurantLocation) as TextView
        var statusView = itemView.findViewById<View>(R.id.status) as TextView
        var priceView = itemView.findViewById<View>(R.id.price) as TextView
        var diningTypeView = itemView.findViewById<View>(R.id.diningType) as TextView
        var ratingView = itemView.findViewById<View>(R.id.rating) as TextView
    }
}
