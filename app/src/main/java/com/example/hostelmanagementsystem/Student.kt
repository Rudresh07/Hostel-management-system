package com.example.hostelmanagementsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hostelmanagementsystem.databinding.ActivityStudentBinding

class Student : AppCompatActivity() {


    var binding: ActivityStudentBinding? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityStudentBinding.inflate(layoutInflater)
        val view = binding?.root

        setContentView(view)

        binding?.Problems?.setOnClickListener {
            val intent = Intent(this,Problem::class.java)
            startActivity(intent)
        }
    }
}