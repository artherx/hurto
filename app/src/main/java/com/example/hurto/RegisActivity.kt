package com.example.hurto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText

class RegisActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regis)

        val txtUserR = findViewById<AppCompatEditText>(R.id.usuario)
        val txtSingh = findViewById<TextView>(R.id.passSingh)
        val name:String = intent.extras?.getString("recordarR").orEmpty()
        txtUserR.setText(name)
        txtSingh.setOnClickListener {
            val nameI = txtUserR.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            if (nameI.isNotEmpty()){
                intent.putExtra("recordarI", nameI)
            }
            startActivity(intent)
        }
    }
}