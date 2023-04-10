package com.example.quizapp

import java.lang.IllegalArgumentException

class Question(
    val ID: Int,
    var question: String,
    var image: Int,
    var options: Array<String>,
    private var rightAnswer: Int
)
{
    private val size = 4
    var rightAnswerToString: String? = null

    init
    {
        if (options.size != size)
            throw ArrayStoreException("There should be 4 questions.")

        rightAnswerToString = options[rightAnswer - 1]
    }

    fun answer(choice: Int): Boolean{
        if(choice <= 0 || choice > size)
            throw IllegalArgumentException()
        return choice == getIndexOfRightAnswer() + 1
    }

    fun getIndexOfRightAnswer(): Int {
        for (i in options.indices) {
            if(options[i] == rightAnswerToString)
                return i
        }
        return -1
    }

    override fun toString(): String {
        var str = "$ID${options.contentToString()}"
        return str
    }

}
