package com.ascustomtextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aslib.AsTextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val asTextView: AsTextView = findViewById(R.id.asTextView)
        asTextView.setGradeText("1")
    }
}