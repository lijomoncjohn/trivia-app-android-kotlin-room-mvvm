package com.lijo.triviaapp.ui.question

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.lijo.triviaapp.R
import com.lijo.triviaapp.data.db.entities.User
import com.lijo.triviaapp.ui.auth.AuthViewModel
import com.lijo.triviaapp.ui.auth.HistoryActivity
import kotlinx.android.synthetic.main.activity_summary.*
import java.text.SimpleDateFormat
import java.util.*


class SummaryActivity : AppCompatActivity() {

    private var authViewModel: AuthViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)
        authViewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)

        val name: String = intent.getStringExtra("name")
        val answer_one: String = intent.getStringExtra("answer_one")
        val answer_two: String = intent.getStringExtra("answer_two")

        // get user completed date time
        val pattern = "EEE, d MMM yyyy HH:mm"
        val simpleDateFormat = SimpleDateFormat(pattern)
        val date: String = simpleDateFormat.format(Date())

        // save summary of the quiz to db
        val user = User(0, name, date, answer_one, answer_two)
        authViewModel?.upsert(user)

        tvName.text = "Hello " + name
        tvAnswerOne.text = answer_one
        tvAnswerTwo.text = answer_two

        btFinish.setOnClickListener{
            finish()
        }

        btnHistory.setOnClickListener{
            intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }
    }
}
