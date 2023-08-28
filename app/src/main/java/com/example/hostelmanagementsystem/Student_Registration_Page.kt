package com.example.hostelmanagementsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hostelmanagementsystem.databinding.ActivityStudentRegistrationPageBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Student_Registration_Page : AppCompatActivity(){

    var binding: ActivityStudentRegistrationPageBinding? =null
    private lateinit var dbref: DatabaseReference
    private lateinit var dbroom:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStudentRegistrationPageBinding.inflate(layoutInflater)
        val view = binding?.root

        setContentView(view)

        dbref = FirebaseDatabase.getInstance().getReference("Students")
        dbroom = FirebaseDatabase.getInstance().getReference("Room")


        binding?.Submit?.setOnClickListener {

            val stname = binding?.name?.text?.toString()!!
            val stroll = binding?.rollno?.text?.toString()!!
            val stemail = binding?.email?.text?.toString()!!
            val stpassword = binding?.password?.text?.toString()!!
            val stroom = binding?.room?.text?.toString()!!
            val styear = binding?.year?.text?.toString()!!
            val stbranch = binding?.branch?.text?.toString()!!

            val Studentdetail = Student_Detail(stname,stroll,stbranch,stroom,stpassword,stemail,styear)
            val Roomdetail = Room_Details(stroom,stname,stroll,stemail)

            dbref.child(stroll).setValue(Studentdetail).addOnSuccessListener {
                Toast.makeText(this, "Successfully added student", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "failed to add student", Toast.LENGTH_SHORT).show()
            }

            dbroom.child(stroom).setValue(Roomdetail).addOnSuccessListener {
                Toast.makeText(this, "Successfully added Room details", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "failed to add Room details", Toast.LENGTH_SHORT).show()
            }


        }


    }
}