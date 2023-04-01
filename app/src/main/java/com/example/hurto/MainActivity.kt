package com.example.hurto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var  auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnRegis = findViewById<AppCompatButton>(R.id.btnRegis)
        val etUser = findViewById<AppCompatEditText>(R.id.usuario)
        val etPass = findViewById<AppCompatEditText>(R.id.password)

        btnRegis.setOnClickListener {
            val name = etUser.text.toString()
            if (name.isNotEmpty()){
                val intent = Intent(this,HomeActivity::class.java)
                intent.putExtra("Extra name",name)
                startActivity(intent)
            }

        }
    }
}