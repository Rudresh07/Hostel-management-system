package com.example.hostelmanagementsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hostelmanagementsystem.databinding.ActivityAdminBinding

class Admin : AppCompatActivity() {

    var binding:ActivityAdminBinding? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAdminBinding.inflate(layoutInflater)
        val view = binding?.root

        setContentView(view)


        binding?.sregistration?.setOnClickListener {

            val intent = Intent(this, Student_Registration_Page::class.java)
            startActivity(intent)

        }


    }
}