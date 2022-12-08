package com.ascustomtextview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aslib.AsTextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val asTextView: AsTextView = findViewById(R.id.asTextView)
        asTextView.setSort("co2")
        asTextView.setIndexText("1200")
        Toast.makeText(this, asTextView.getSort(), Toast.LENGTH_SHORT).show();
    }
}