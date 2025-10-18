package com.wazeet.app

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var clickCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titleText = findViewById<TextView>(R.id.titleText)
        val subtitleText = findViewById<TextView>(R.id.subtitleText)
        val counterText = findViewById<TextView>(R.id.counterText)
        val actionButton = findViewById<Button>(R.id.actionButton)

        titleText.text = "Welcome to WAZEET"
        subtitleText.text = "Your App is Ready!"
        
        actionButton.setOnClickListener {
            clickCount++
            counterText.text = "Button clicked: $clickCount times"
        }
    }
}
