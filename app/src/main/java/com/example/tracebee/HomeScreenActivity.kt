package com.example.tracebee

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_home_screen.*
import kotlinx.android.synthetic.main.content_home_screen.*

class HomeScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        //setSupportActionBar(toolbar)

        //Go to AddTopicActivity
        addTopicBtn.setOnClickListener {
            startActivity(Intent(this, AddTopicActivity::class.java))
        }


    }
}
