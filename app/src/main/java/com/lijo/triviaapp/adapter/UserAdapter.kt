package com.lijo.triviaapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lijo.triviaapp.R
import com.lijo.triviaapp.data.db.entities.User

class UserAdapter (private val context: Context, private val users: List<User>?) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, index: Int): ViewHolder {
        val rootView = LayoutInflater.from(viewGroup.context).inflate(R.layout.listitem_users, viewGroup, false)
        return ViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return users?.size!!
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, index: Int) {
        viewHolder.messageTV.text = users?.get(index)?.name
        viewHolder.tvGameNo.text = "GAME : " + users?.get(index)?.id.toString() + " : " + users?.get(index)?.date
        viewHolder.tvAnsOne.text = users?.get(index)?.answer_one
        viewHolder.tvAnsTwo.text = users?.get(index)?.answer_two
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var messageTV: TextView = itemView.findViewById(R.id.messageTextView) as TextView
        var tvGameNo: TextView = itemView.findViewById(R.id.tvGameNo) as TextView
        var tvAnsOne: TextView = itemView.findViewById(R.id.tvAnsOne) as TextView
        var tvAnsTwo: TextView = itemView.findViewById(R.id.tvAnsTwo) as TextView
    }

}