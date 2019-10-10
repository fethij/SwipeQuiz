package com.example.swipequiz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_questions_row.view.*

class QuizAdapter (val quizList: MutableList<MainActivity.Quiz>, val listener: (MainActivity.Quiz) -> Unit):
RecyclerView.Adapter<QuizAdapter.CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_questions_row, parent, false))
    }

    override fun getItemCount(): Int {
        return quizList.size
      }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(quizList[position], listener)
    }

    fun bounceItemBackkAfterSwipe(position: Int){
        notifyItemChanged(position)
    }


    inner class CustomViewHolder (private val view : View) : RecyclerView.ViewHolder(view){
        fun bind(quiz: MainActivity.Quiz, listener: (MainActivity.Quiz) -> Unit) = with(view){
            textViewQuestion.setText(quiz.id)
            setOnClickListener{listener(quiz)}
    }
}
}