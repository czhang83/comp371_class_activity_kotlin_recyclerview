package com.example.classactivity8

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.classactivity8.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySecondBinding
    private lateinit var textViewGreeting : TextView
    private lateinit var buttonHistory : Button

    private final val baseURL = "https://www.behindthename.com/name/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textViewGreeting = binding.textViewGreeting

        val message = intent.getStringExtra("name")
        textViewGreeting.text = "Hello, " + message

        buttonHistory = binding.buttonHistory
        // set the text of this button to be history about NANME
        buttonHistory.text = "History about " + message

        buttonHistory.setOnClickListener {
            if (message != null) {
                launchBrowser(message)
            }
        }
    }

    // when the button is clicked, send an implicit intent to open a link
    private fun launchBrowser(name:String){
        // Uri to parse the url, start an activity with action view
        val queryURL : Uri = Uri.parse("${baseURL}${name}")
        // template string, $ - variable
        val intent = Intent(Intent.ACTION_VIEW, queryURL)
        startActivity(intent)
    }
}