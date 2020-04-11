package com.lijo.triviaapp.ui.question

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.lijo.triviaapp.R
import com.lijo.triviaapp.ui.auth.HistoryActivity
import kotlinx.android.synthetic.main.activity_cricket_question.*
import kotlinx.android.synthetic.main.activity_flag_question.*
import kotlinx.android.synthetic.main.activity_name.*

class FlagQuestionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flag_question)

        val name: String = intent.getStringExtra("name")
        val answer_one: String = intent.getStringExtra("answer_one")

        var answer_two: String? = null
        cbOptionOne.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                answer_two = cbOptionOne.text.toString()
            }
        }
        cbOptionTwo.setOnCheckedChangeListener{ buttonView, isChecked ->
            if (isChecked) {
                answer_two = answer_two + ", " + cbOptionTwo.text.toString()
            }
        }
        cbOptionThree.setOnCheckedChangeListener{ buttonView, isChecked ->
            if (isChecked) {
                answer_two = answer_two + ", " + cbOptionThree.text.toString()
            }
        }
        cbOptionFour.setOnCheckedChangeListener{ buttonView, isChecked ->
            if (isChecked) {
                answer_two = answer_two +  ", " + cbOptionFour.text.toString()
            }
        }

        btnNextTwo.setOnClickListener{

            Toast.makeText(applicationContext, answer_two,
                Toast.LENGTH_SHORT).show()

            intent = Intent(this, SummaryActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("answer_one", answer_one)
            intent.putExtra("answer_two", answer_two)
            startActivity(intent)
            finish()
        }

    }

}
