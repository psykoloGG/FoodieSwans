package com.PsykoloGG.foodieswans

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.topAppBar))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_app_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        Log.v("MainActivity", "called");
        return when (item.itemId)
        {
            R.id.account ->
            {
                if (FirebaseAuth.getInstance().currentUser != null)
                {
                    openAccountActivity()
                }
                else
                {
                    openLoginActivity()
                }
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun openAccountActivity()
    {
        val intent = Intent(this, AccountPage::class.java)
        startActivity(intent)
    }

    private fun openLoginActivity()
    {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}