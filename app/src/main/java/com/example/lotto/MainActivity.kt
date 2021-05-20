package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardConstellation = findViewById<CardView>(R.id.cardConstellation)
        val cardName = findViewById<CardView>(R.id.cardName)

        cardConstellation.setOnClickListener{
            startActivity(Intent(this@MainActivity, ConstellationActivity::class.java))
        }
        cardName.setOnClickListener{
            startActivity(Intent(this@MainActivity, NameActivity::class.java))
        }
    }
    }
}