package ooo.kno.tests

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import ooo.chko.tests.R

class QuestionFragment : Fragment() {
    private var questionIndex = 0
    private var userAnswers = mutableListOf<Int>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_question, container, false)

        val questionText = view.findViewById<TextView>(R.id.questionText)
        val questionImage = view.findViewById<ImageView>(R.id.questionImage)
        val radioGroup = view.findViewById<RadioGroup>(R.id.radioGroup)
        val nextButton = view.findViewById<Button>(R.id.nextButton)

        fun updateQuestion() {
            val question = Question.questions[questionIndex]
            questionText.text = question.text
            questionImage.setImageResource(question.imageRes ?: 0)
            questionImage.visibility = if (question.imageRes != null) View.VISIBLE else View.GONE

            (view.findViewById<RadioButton>(R.id.radioButtonA)).text = question.answers[0]
            (view.findViewById<RadioButton>(R.id.radioButtonB)).text = question.answers[1]
            (view.findViewById<RadioButton>(R.id.radioButtonC)).text = question.answers[2]
            (view.findViewById<RadioButton>(R.id.radioButtonD)).text = question.answers[3]
        }

        nextButton.setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId
            if (selectedId != -1) {
                val answerIndex = when (selectedId) {
                    R.id.radioButtonA -> 0
                    R.id.radioButtonB -> 1
                    R.id.radioButtonC -> 2
                    R.id.radioButtonD -> 3
                    else -> -1
                }

                answerQuestion(answerIndex)

                if (questionIndex < Question.questions.size - 1) {
                    questionIndex++
                    updateQuestion()
                    radioGroup.clearCheck() // Сброс выбора
                } else {
                    (activity as MainActivity).showResults(userAnswers)
                }
            } else {
                Toast.makeText(activity, "Пожалуйста, выберите ответ", Toast.LENGTH_SHORT).show()
            }
        }

        updateQuestion()
        return view
    }

    private fun answerQuestion(answerIndex: Int) {
        userAnswers.add(answerIndex)
    }
}