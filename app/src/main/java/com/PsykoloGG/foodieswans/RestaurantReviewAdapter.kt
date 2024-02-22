package com.PsykoloGG.foodieswans

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth

class AccountReviewAdapter(private val ReviewArrayList: MutableList<AccountReviewModel>) :
    RecyclerView.Adapter<AccountReviewAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return ReviewArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Info = ReviewArrayList[position]

        holder.NameView.text = Info.GetName()
        holder.ReviewView.text = Info.GetReview()

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val Inflater = LayoutInflater.from(parent.context)
        val View = Inflater.inflate(R.layout.account_review_row_layout, parent, false)

        return ViewHolder(View)
    }
    inner class ViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        var NameView = itemView.findViewById<View>(R.id.restaurantReviewName) as TextView
        var ReviewView = itemView.findViewById<View>(R.id.reviewBody) as TextView
    }

    private lateinit var auth: FirebaseAuth
}
