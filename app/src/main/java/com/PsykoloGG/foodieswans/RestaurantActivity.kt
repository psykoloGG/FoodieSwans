package com.PsykoloGG.foodieswans

import android.accounts.Account
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodreviewapp.RestaurantModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.storage
import java.io.File

class AccountPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_page)
        auth = Firebase.auth

        val accountName = findViewById<TextView>(R.id.acountName)
        val signOutButton = findViewById<Button>(R.id.signOutButton)

        val storage = Firebase.storage
        val storageRef = storage.reference

        accountName.text = "Name:" + auth.currentUser?.displayName
        val ref = storageRef.child(auth.currentUser?.photoUrl.toString())
        val localFile = File.createTempFile("acountImage", "jpg")

        val reviewArrayList = PopulateList()

        val recyclerView = findViewById<RecyclerView>(R.id.accountReviewsView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val mAdapter = AccountReviewAdapter(reviewArrayList)
        recyclerView.adapter = mAdapter

        signOutButton.setOnClickListener {
            auth.signOut()
            finish()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

    fun PopulateList(): ArrayList<AccountReviewModel> {
        val list = ArrayList<AccountReviewModel>()
        db.collection("users").whereEqualTo("User", auth.currentUser?.displayName).get().addOnSuccessListener {
            val documents = it.documents
            for (document in documents)
            {
                Log.d("log", document.get("RestaurantName").toString())
                val accountReviewModel = AccountReviewModel()
                accountReviewModel.Name = document.get("RestaurantName").toString()
                accountReviewModel.Review = document.get("ReviewMessage").toString()
                list.add(accountReviewModel)
            }
            val recyclerView = findViewById<RecyclerView>(R.id.accountReviewsView)
            val layoutManager = LinearLayoutManager(this)
            recyclerView.layoutManager = layoutManager
            val mAdapter = AccountReviewAdapter(list)
            recyclerView.adapter = mAdapter
        }

        return list
    }

    private lateinit var auth: FirebaseAuth
    val db = Firebase.firestore
}