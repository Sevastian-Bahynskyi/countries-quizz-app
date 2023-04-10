package com.example.quizapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonStart: Button = findViewById(R.id.buttonStart)
        val editTextName: EditText = findViewById(R.id.editTextName)

        buttonStart.setOnClickListener {
            if(editTextName.text.isEmpty())
                Toast.makeText(this, "You should enter your name first.",
                    Toast.LENGTH_SHORT).show()
            else {
                Constants.name = editTextName.text.toString()

                val intent = Intent(this, QuizQuestionsActivity::class.java)
                Constants.getQuestions()
                startActivity(intent)
            }
        }
    }


}