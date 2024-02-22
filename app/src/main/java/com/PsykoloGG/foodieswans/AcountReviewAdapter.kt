package com.example.foodreviewapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.PsykoloGG.foodieswans.LoginActivity
import com.PsykoloGG.foodieswans.MainActivity
import com.PsykoloGG.foodieswans.R
import com.PsykoloGG.foodieswans.ReviewWriting
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class RestaurantAdapter(private val ImageArrayList: MutableList<RestaurantModel>, val activity: MainActivity) :
    RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return ImageArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Info = ImageArrayList[position]
        auth = Firebase.auth

        holder.ImgView.setImageResource(Info.GetImage())
        holder.NameView.text = Info.GetName()
        holder.locView.text = Info.GetDistance()
        holder.statusView.text = Info.GetStatus()
        holder.priceView.text = Info.GetPrice()
        holder.diningTypeView.text = Info.GetDiningType()
        holder.ratingView.text = Info.GetRating()
        holder.AddReviewButton.isEnabled = auth.currentUser != null

        val bundle: Bundle = Bundle()
        bundle.putString("Name", Info.GetName())
        bundle.putInt("Image", Info.GetImage())
        Log.d("Name", bundle.getString("Name").toString())
        holder.AddReviewButton.setOnClickListener {
            val intent = Intent(activity, ReviewWriting::class.java)
            intent.putExtras(bundle)
            startActivity(activity, intent, null)
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val Inflater = LayoutInflater.from(parent.context)
        val View = Inflater.inflate(R.layout.restaurant_row_layout, parent, false)

        return ViewHolder(View)
    }
    inner class ViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ImgView = itemView.findViewById<View>(R.id.restaurantImage) as ImageView
        var NameView = itemView.findViewById<View>(R.id.restaurantName) as TextView
        var locView = itemView.findViewById<View>(R.id.restaurantLocation) as TextView
        var statusView = itemView.findViewById<View>(R.id.status) as TextView
        var priceView = itemView.findViewById<View>(R.id.price) as TextView
        var diningTypeView = itemView.findViewById<View>(R.id.diningType) as TextView
        var ratingView = itemView.findViewById<View>(R.id.rating) as TextView
        var AddReviewButton = itemView.findViewById<Button>(R.id.addReview) as Button
    }

    private lateinit var auth: FirebaseAuth
}
