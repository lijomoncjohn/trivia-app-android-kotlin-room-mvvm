package com.lijo.triviaapp.ui.question

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import com.lijo.triviaapp.R
import kotlinx.android.synthetic.main.activity_cricket_question.*

class CricketQuestionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cricket_question)

        val name: String = intent.getStringExtra("name")

        btnNextOne.setOnClickListener{
            var answer_one:String? = null
            // Get the checked radio button id from radio group
            var id: Int = rgQuestionOne.checkedRadioButtonId
            if (id!=-1){ // If any radio button checked from radio group
                // Get the instance of radio button using id
                val radio: RadioButton = findViewById(id)
                answer_one = radio.text as String?
                Toast.makeText(applicationContext, "${radio?.text}",
                    Toast.LENGTH_SHORT).show()
            }else{
                // If no radio button checked in this radio group
                Toast.makeText(applicationContext, "Select one choice",
                    Toast.LENGTH_SHORT).show()
            }

            intent = Intent(this, FlagQuestionActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("answer_one", answer_one)
            startActivity(intent)
            finish()
        }
    }
}
