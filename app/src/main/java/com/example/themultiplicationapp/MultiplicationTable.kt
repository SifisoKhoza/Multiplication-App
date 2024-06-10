package com.example.themultiplicationapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MultiplicationTable : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_multiplication_table)

        // Get the input number from bundle
        val bundle = intent.extras
        val tableString = bundle?.getString("inputNumber")
        val inputNumber = tableString!!.toInt()

        // Display the heading and initialize the display string
        val multiplicationTable = findViewById<TextView>(R.id.tableDisplayTextView)
        var tableDisplayTextView = "$inputNumber × multiplication\n\n"

        // Loop to generate multiplication table
        for (count in 1..10) {
            val answer = inputNumber * count
            tableDisplayTextView += "$inputNumber × $count = $answer\n"
        }

        // Update the TextView with the generated table
        multiplicationTable.text = tableDisplayTextView

        // Find the back button and set its click listener to go back to MainActivity
        val backButton2 = findViewById<Button>(R.id.backButton2)
        backButton2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Handle window insets for edge-to-edge support
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}


