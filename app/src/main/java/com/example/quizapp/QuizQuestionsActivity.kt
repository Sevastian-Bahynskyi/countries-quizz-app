package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener
{
    private var name: String? = null

    private var tvQuestion: TextView? = null
    private var imageCountry: ImageView? = null
    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var option_1: TextView? = null
    private var option_2: TextView? = null
    private var option_3: TextView? = null
    private var option_4: TextView? = null
    private var buttonSubmit: Button? = null


    private var options = ArrayList<TextView>()
    private var lastSelectedOption = -1
    private var correctAnswers = 0
    private var curQuestion = 0
    private val questions = Constants.getQuestions()




    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)


        tvQuestion = findViewById(R.id.tvQuestion)
        imageCountry = findViewById(R.id.imageCountry)
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        option_1 = findViewById(R.id.option_1)
        option_2 = findViewById(R.id.option_2)
        option_3 = findViewById(R.id.option_3)
        option_4 = findViewById(R.id.option_4)
        buttonSubmit = findViewById(R.id.buttonSubmit)

        Log.i("Try shuffle", questions.toString())

        option_1?.let {
            options.add(it)
        }
        option_2?.let {
            options.add(it)
        }
        option_3?.let {
            options.add(it)
        }
        option_4?.let {
            options.add(it)
        }

        progressBar?.max = questions.size - 1


        for (option in options) {
            option.setOnClickListener(this)
        }

        setQuestion()
    }

    private fun setQuestion() {
        val i = curQuestion
        tvQuestion?.text = questions[i].question
        imageCountry?.setImageResource(questions[i].image)
        progressBar?.progress = i
        tvProgress?.text = "$i / ${questions.size - 1}"
        option_1?.text = questions[i].options[0]
        option_2?.text = questions[i].options[1]
        option_3?.text = questions[i].options[2]
        option_4?.text = questions[i].options[3]
        buttonSubmit?.setOnClickListener {
            onSubmit()
        }

        if(i == questions.size - 1)
        {
            buttonSubmit?.text = "FINISH"
            buttonSubmit?.setOnClickListener {
                val intent = Intent(this, EndActivity::class.java)
                Constants.correctAnswers = correctAnswers
                startActivity(intent)
            }
        }
    }

    //TODO make options random


    private fun deselectAllButtons() {
        for (option in options){
            option.background = ContextCompat.getDrawable(
                this, R.drawable.default_button_bg
            )
            option.setTextColor(ContextCompat.getColor(
                applicationContext, R.color.default_button_text
            ))
        }
    }
    private fun onOptionClick(option: TextView) {

        deselectAllButtons()

        option.background = ContextCompat.getDrawable(
            this, R.drawable.selected_button_bg
        )
        option.setTextColor(ContextCompat.getColor(
            applicationContext, R.color.selected_button_text
        ))

        for (i in options.indices) {
            if(options[i] == option)
                lastSelectedOption = i + 1
        }
    }

    private fun onSubmit() {
        val question = questions[curQuestion]
        if(lastSelectedOption == -1)
            return
        else if(question.answer(lastSelectedOption)) {
            options[lastSelectedOption - 1].background = ContextCompat.getDrawable(
                this, R.drawable.correct_answer_button_bg
            )
            correctAnswers++
        }
        else{
            options[lastSelectedOption - 1].background = ContextCompat.getDrawable(
                this, R.drawable.incorrect_answer_button_bg
            )

            options[question.getIndexOfRightAnswer()].background = ContextCompat.getDrawable(
                this, R.drawable.correct_answer_button_bg
            )
        }

        buttonSubmit?.text = "OK"
        buttonSubmit?.setOnClickListener {
            curQuestion++
            deselectAllButtons()
            lastSelectedOption = -1
            buttonSubmit?.text = "SUBMIT"
            setQuestion()
        }
    }

    override fun onClick(view: View?)
    {
        for (option in options) {
            if(view is TextView && option == view) {
                onOptionClick(option)
                return
            }
        }
    }
}