package ooo.chko.tests

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Question.questions.shuffle()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, QuestionFragment())
                .commit()
        }
    }

    fun repeat() {
        Question.questions.shuffle()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, QuestionFragment())
            .addToBackStack(null)
            .commit()
    }

    fun showResults(answers: List<Int>) {
        val resultFragment = ResultFragment()
        resultFragment.setAnswers(answers)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, resultFragment)
            .addToBackStack(null)
            .commit()
    }
}