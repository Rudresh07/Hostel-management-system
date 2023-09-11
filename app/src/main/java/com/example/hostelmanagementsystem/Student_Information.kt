package com.example.hostelmanagementsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hostelmanagementsystem.databinding.ActivityStudentInformationBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Student_Information : AppCompatActivity() {

    var binding: ActivityStudentInformationBinding? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStudentInformationBinding.inflate(layoutInflater)
        val view = binding?.root
        setContentView(view)


        val intent = intent
        if (intent != null && intent.hasExtra(Student_Login_Page.Key)) {
            val bundle = intent.getBundleExtra(Student_Login_Page.Key)

            val name = bundle?.getString("name")
            val email = bundle?.getString("email")
            val branch = bundle?.getString("branch")
            val room = bundle?.getString("room")
            val year = bundle?.getString("year")
            val roll = bundle?.getString("roll")
            val phone = bundle?.getString("phone")

            binding?.nameShow?.text = "$name"
            binding?.branchShow?.text = "$branch"
            binding?.emailShow?.text = "$email"
            binding?.rollShow?.text = "$roll"
            binding?.roomShow?.text = "$room"
            binding?.yearShow?.text = "$year"
            binding?.phoneShow?.text = "$phone"

            // Now you can use the data as needed
        }


    }


}