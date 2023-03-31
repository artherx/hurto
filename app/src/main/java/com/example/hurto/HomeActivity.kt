package com.example.hurto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val tvPerfil = findViewById<TextView>(R.id.textPer)
        val name:String = intent.extras?.getString("Extra name").orEmpty()
        tvPerfil.text = "$name"
    }
}