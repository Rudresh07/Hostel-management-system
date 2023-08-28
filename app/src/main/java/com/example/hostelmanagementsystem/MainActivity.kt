package com.example.hostelmanagementsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hostelmanagementsystem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var binding:ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding?. root

        setContentView(view)


        binding?.Admin?.setOnClickListener {

            val intent = Intent(this,Admin::class.java)
            startActivity(intent)
        }

        binding?.Student?.setOnClickListener {
            val intent = Intent(this,Student_Login_Page::class.java)
            startActivity(intent)
        }
    }
}