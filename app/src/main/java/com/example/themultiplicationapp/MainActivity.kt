package com.example.themultiplicationapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.themultiplicationapp.R.id.multiplyButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the views
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val inputNumberEditText = findViewById<EditText>(R.id.inputNumberEditText)

        multiplyButton.setOnClickListener {
            //storing variable for prompt string
            val prompt = "please enter a number of your choice"
            if (inputNumberEditText.text.isEmpty()) {
                Toast.makeText(this, prompt, Toast.LENGTH_SHORT).show()
            } else {
                // Intent to open another activity (next page)
                val intent = Intent(this, MultiplicationTable::class.java)
                // Add the input number to the Intent
                intent.putExtra("inputNumber", inputNumberEditText.text.toString())
                // Start the next activity
                startActivity(intent)
            }
        }

        // Handle window insets for edge-to-edge support
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
