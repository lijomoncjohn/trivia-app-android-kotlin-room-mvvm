package com.lijo.triviaapp.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.lijo.triviaapp.R
import com.lijo.triviaapp.adapter.UserAdapter
import com.lijo.triviaapp.data.db.entities.User
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : AppCompatActivity() {

    private var authViewModel: AuthViewModel? = null
    lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        authViewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)

        authViewModel?.getUsers()?.observe(this, Observer<List<User>> { this.render(it) })

    }

    private fun render(messages: List<User>?){
        adapter = UserAdapter(this, messages)
        val layoutManager = LinearLayoutManager(this)
        messageRecyclerView.layoutManager = layoutManager
        messageRecyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}
