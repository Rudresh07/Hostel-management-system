package com.example.hostelmanagementsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hostelmanagementsystem.databinding.ActivityStudentSectionBinding

class Student_Section : AppCompatActivity() {


    var binding:ActivityStudentSectionBinding? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStudentSectionBinding.inflate(layoutInflater)
        val view = binding?.root

        setContentView(view)

        binding?.sdetails?.setOnClickListener {

            val intent = Intent(this,Student_Information::class.java)

            startActivity(intent)
        }

        binding?.sproblems?.setOnClickListener {
            val intent = Intent(this,Problem::class.java)

            startActivity(intent)
        }

    }
}

class ActivityStudentSectionBinding {

}
