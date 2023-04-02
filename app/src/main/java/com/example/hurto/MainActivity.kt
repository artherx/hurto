package com.example.hurto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    private lateinit var stateListener:FirebaseAuth.AuthStateListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnRegis = findViewById<AppCompatButton>(R.id.btnRegis)
        val etUser = findViewById<AppCompatEditText>(R.id.usuario)
        val etPass = findViewById<AppCompatEditText>(R.id.password)
        val txtPassRe = findViewById<TextView>(R.id.passSingh)
        val name:String = intent.extras?.getString("recordarI").orEmpty()
        etUser.setText(name)


        btnRegis.setOnClickListener {
            val name = etUser.text.toString()
            val pass = etPass.text.toString()
            if (name.isNotEmpty()){
                if (pass.isNotEmpty()){
                    signIn(name,pass)
                    val intent = Intent(this,HomeActivity::class.java)
                    intent.putExtra("Extra name",name)
                    startActivity(intent)
                }
            }

        }
        txtPassRe.setOnClickListener {
            val nameR = etUser.text.toString()
            val intent = Intent(this, RegisActivity::class.java)
            if (nameR.isNotEmpty()){
                intent.putExtra("recordarR", nameR)
            }
            startActivity(intent)
        }
    }

    private fun signIn(email:String,password:String){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {task->
                if (task.isSuccessful){
                    val user = auth.currentUser
                    Toast.makeText(baseContext,"signInWithEmail:success", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(baseContext,"Authentication failed.", Toast.LENGTH_SHORT).show()
                }
            }
    }
}