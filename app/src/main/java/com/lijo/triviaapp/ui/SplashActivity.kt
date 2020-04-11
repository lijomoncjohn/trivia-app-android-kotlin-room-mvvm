package com.lijo.triviaapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.lijo.triviaapp.R
import com.lijo.triviaapp.data.db.entities.User
import com.lijo.triviaapp.ui.auth.NameActivity
import com.lijo.triviaapp.ui.question.CricketQuestionActivity
import kotlinx.android.synthetic.main.activity_name.*

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long = 3000 // 1 sec


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            startActivity(Intent(this, NameActivity::class.java))

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)
    }
}
