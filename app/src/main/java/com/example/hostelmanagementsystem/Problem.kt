package com.example.hostelmanagementsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import android.widget.Spinner
import android.widget.Toast
import com.example.hostelmanagementsystem.databinding.ActivityProblemBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.UUID

class Problem : AppCompatActivity() {

    var binding: ActivityProblemBinding? = null
    private lateinit var dbref: DatabaseReference
    private var selectedText: String = " "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProblemBinding.inflate(layoutInflater)
        val view = binding?.root
        setContentView(view)

        dbref = FirebaseDatabase.getInstance()
            .getReference("Problems") // Use "Problems" instead of "Problem"

        // Find the FrameLayout that contains the Spinner
        val frameLayout = findViewById<FrameLayout>(R.id.frameLayoutContainingSpinner)

        // Find the Spinner inside the FrameLayout
        val spinner = frameLayout.findViewById<Spinner>(R.id.spinner1)

        // Define the options
        val options = listOf(
            "-- Choose Problem Category --",
            "Electricity",
            "Water",
            "Cleanliness",
            "Internet",
            "Other"
        )

        // Create an ArrayAdapter using the options and the default layout
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)

        // Set the layout for the dropdown items
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Set the adapter to the Spinner
        spinner.adapter = adapter

        // Initialize the selectedText with an empty string
        selectedText = ""

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position > 0) {
                    // Valid option selected, you can proceed
                    selectedText = options[position] // Update selectedText
                } else {
                    // Invalid option selected, reset selectedText
                    selectedText = ""
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle the case when nothing is selected, if needed
            }
        }

        binding?.submit?.setOnClickListener {

            // Check if a category has been selected
            if (selectedText.isNotEmpty()) {
                val problemType = selectedText
                val problemEditText = binding?.Problem?.editText

                // Extract the text from the TextInputEditText widget
                val problemText = problemEditText?.text.toString()

                // Check if the problem text is not empty
                if (problemText.isNotBlank()) {
                    // Generate a unique ID for the problem using UUID
                    val problemId = UUID.randomUUID().toString()

                    // Create a map to represent the problem data
                    val problemData = mapOf(
                        "Problem" to problemText,
                        "Problem_type" to problemType
                    )

                    // Set the value of the new child node with the problem data
                    dbref.child(problemType).child(problemId).setValue(problemData)
                        .addOnSuccessListener {
                            Toast.makeText(
                                this@Problem,
                                "Problem Submitted successfully",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        .addOnFailureListener {
                            Toast.makeText(
                                this@Problem,
                                "Failed to submit problem",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                } else {
                    // Show an error message if the problem text is empty
                    Toast.makeText(this@Problem, "Please enter a problem", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                // Show an error message if no category has been selected
                Toast.makeText(this@Problem, "Please choose category to submit", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}
