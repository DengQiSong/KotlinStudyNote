package com.dqs.kotlinnote

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotterknife.bindView

class MainActivity : AppCompatActivity() {
    val firstName: TextView by bindView(R.id.first_name)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val next = findViewById(R.id.Button02) as Button
        next.setOnClickListener {
            Toast.makeText(this, "测试", Toast.LENGTH_SHORT).show()
            firstName.setText("测试")
        }
        firstName.setText("Hello World!")
    }
}
