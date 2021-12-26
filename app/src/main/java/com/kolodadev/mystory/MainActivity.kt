package com.kolodadev.mystory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var textViewEmail:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val email = intent.getStringExtra("email")
        connectView()
        textViewEmail?.text = email
    }

    private fun connectView() {
        textViewEmail = findViewById(R.id.tvEmail)
    }
}