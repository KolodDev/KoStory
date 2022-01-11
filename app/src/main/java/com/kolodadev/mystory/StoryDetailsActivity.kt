package com.kolodadev.mystory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class StoryDetailsActivity : AppCompatActivity() {

    private var toolbar:Toolbar? = null
    private var txtViewStoryDesc:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_details)

        connectViews()
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Receive Variables
        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")

        supportActionBar?.title = title
        toolbar?.setNavigationOnClickListener {
            onBackPressed()
        }

        txtViewStoryDesc?.text = description
        txtViewStoryDesc?.movementMethod = ScrollingMovementMethod()

    }

    private fun connectViews() {
        toolbar = findViewById(R.id.toolbar)
        txtViewStoryDesc = findViewById(R.id.tvDesc)
    }
}