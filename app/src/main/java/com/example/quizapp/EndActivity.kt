package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class EndActivity : AppCompatActivity()
{
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        val name = Constants.name
        val correctAnswers = Constants.correctAnswers

        val textName: TextView = findViewById(R.id.textName)
        val textDescription: TextView = findViewById(R.id.textDescription)

        if (name != null && correctAnswers != null)
        {
            textName.text = textName.text.toString().replace("{name}", name)
            textDescription.text = "You answered $correctAnswers questions out of 7 correctly."
        }
    }
}