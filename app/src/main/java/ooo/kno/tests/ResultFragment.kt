package ooo.kno.tests

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import ooo.chko.tests.R

class ResultFragment : Fragment() {
    private var userAnswers: List<Int>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)

        val resultText = view.findViewById<TextView>(R.id.resultText)
        val repeatButton = view.findViewById<Button>(R.id.repeatButton)
        var score = 0

        userAnswers?.forEachIndexed { index, answer ->
            if (answer == Question.questions[index].correctAnswerIndex)
                score++
        }

        resultText.text = buildString {
            append(getString(R.string.your_result))
            append(score)
            append(getString(R.string.from))
            append(userAnswers?.size ?: getString(R.string.zero))
        }

        repeatButton.setOnClickListener { _ ->
            (activity as MainActivity).repeat()
        }

        return view
    }

    fun setAnswers(answers: List<Int>) {
        userAnswers = answers
    }
}