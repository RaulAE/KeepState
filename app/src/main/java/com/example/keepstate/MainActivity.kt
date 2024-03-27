package com.example.keepstate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var textInfo: TextView
    lateinit var textView1: TextView
    lateinit var textView2: TextView
    lateinit var textView3: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val textInfo = findViewById<TextView>(R.id.textInfo)
        val textView1 = findViewById<TextView>(R.id.textView1)
        val textView2 = findViewById<TextView>(R.id.textView2)
        val textView3 = findViewById<TextView>(R.id.textView3)

        button.setOnClickListener {
            textInfo.setText("I have been clicked")
            textView1.setText("I have also been clicked")
            textView2.setText("I too have been clicked")
            textView3.setText("Same here")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("saved_text", textInfo.text.toString())
        outState.putString("Saved_text_1", textView1.text.toString())
        outState.putString("Saved_text_2", textView2.text.toString())
        outState.putString("Saved_text_3", textView3.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        textInfo.setText(savedInstanceState.getString("saved_text"))
        textView1.setText(savedInstanceState.getString("saved_text_1"))
        textView2.setText(savedInstanceState.getString("saved_text_2"))
        textView3.setText(savedInstanceState.getString("saved_text_3"))
    }

}