package com.kolodadev.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddStoryActivity : AppCompatActivity() {

    private var edTextTitle:EditText? = null
    private var edSubTitle:EditText? = null
    private var edTextDesc:EditText? = null
    private var btnAddStory:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_story)

        connectViews()
        fieldsValidation()
    }

    private fun connectViews() {
        edTextTitle = findViewById(R.id.etTitle)
        edSubTitle = findViewById(R.id.etSubtitle)
        edTextDesc = findViewById(R.id.etDesc)
        btnAddStory = findViewById(R.id.btnAdd)
    }

    private fun  fieldsValidation(){
        btnAddStory?.setOnClickListener {
            val title = edTextTitle?.text.toString()
            val subtitle = edSubTitle?.text.toString()
            val desc = edTextDesc?.text.toString()

            when {
                title.isEmpty() -> {
                    edTextTitle?.error = getString(R.string.enter_title)
                }
                subtitle.isEmpty() -> {
                    edSubTitle?.error = getString(R.string.enter_subtitle)
                }
                desc.isEmpty() -> {
                    edTextDesc?.error = getString(R.string.enter_desc)
                }
                else ->{
                    this.finish()
                    val i = Intent(this,MainActivity::class.java)
                    i.putExtra("title",title)
                    i.putExtra("subtitle",subtitle)
                    i.putExtra("desc",desc)
                    startActivity(i)
                }
            }
        }
    }
}