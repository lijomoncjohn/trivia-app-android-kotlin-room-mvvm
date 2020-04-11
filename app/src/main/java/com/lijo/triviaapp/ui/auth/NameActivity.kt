package com.lijo.triviaapp.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.lijo.triviaapp.R
import com.lijo.triviaapp.data.db.entities.User
import com.lijo.triviaapp.ui.question.CricketQuestionActivity
import kotlinx.android.synthetic.main.activity_name.*

class NameActivity : AppCompatActivity() {

    private var authViewModel: AuthViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
        authViewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)

        // enable button when name field !empty
        etName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                btEnter.isEnabled = charSequence.toString().trim { it <= ' ' }.isNotEmpty()
            }

            override fun afterTextChanged(editable: Editable) {}
        })

        btEnter.setOnClickListener{
//            val user = User(0,etName.getText().toString())
//            authViewModel?.upsert(user)
            intent = Intent(this, CricketQuestionActivity::class.java)
            intent.putExtra("name", etName.getText().toString())
            startActivity(intent)
            // clear input text
            etName.setText("")
        }
    }
}
