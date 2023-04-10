package com.example.quizapp

object Constants
{
    fun getQuestions(): ArrayList<Question>
    {
        var questions = ArrayList<Question>()

        val question1 = Question(
            1, "What country does this flag belongs to?", R.drawable.ic_flag_of_argentina
            , arrayOf<String>("Argentina", "Australia", "Armenia", "Austria"), 1
        )

        val question2 = Question(
            2, "What country does this flag belongs to?", R.drawable.ic_flag_of_germany
            , arrayOf<String>("Ukraine", "Belgium", "Germany", "Great Britain"), 3
        )

        val question3 = Question(
            3, "What country does this flag belongs to?", R.drawable.ic_flag_of_brazil
            , arrayOf<String>("Spain", "Dominica", "Mexico", "Brazil"), 4
        )

        val question4 = Question(
            4, "What country does this flag belongs to?", R.drawable.ic_flag_of_india
            , arrayOf<String>("Madagascar", "India", "Guinea", "Ireland"), 2
        )

        val question5 = Question(
            5, "What country does this flag belongs to?", R.drawable.ic_flag_of_new_zealand
            , arrayOf<String>("United Kingdom", "USA", "New Zealand", "Tuvalu"), 3
        )

        val question6 = Question(
            6, "What country does this flag belongs to?", R.drawable.ic_flag_of_denmark
            , arrayOf<String>("Denmark", "Sweden", "Norway", "Iceland"), 1
        )

        val question7 = Question(
            7, "What country does this flag belongs to?", R.drawable.ic_flag_of_fiji
            , arrayOf<String>("Croatia", "Fiji", "Cameroon", "New Zealand"), 2
        )

        val question8 = Question(
            8, "What country does this flag belongs to?", R.drawable.ic_flag_of_kuwait
            , arrayOf<String>("Ecuador", "Ethiopia", "Iran", "Kuwait"), 4
        )
        questions.add(question1)
        questions.add(question2)
        questions.add(question3)
        questions.add(question4)
        questions.add(question5)
        questions.add(question6)
        questions.add(question7)
        questions.add(question8)

        questions.shuffle()
        for (question in questions)
            question.options.shuffle()

        return questions
    }

    var name:String? = null
    var correctAnswers: Int? = null
}