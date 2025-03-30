package com.example.quizmaster.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.quizmaster.Domain.QuestionModel
import com.example.quizmaster.R
import com.example.quizmaster.databinding.ViewholderQuestionBinding

class QuestionAdapter(
    val correctAnswer: String,
    var users:MutableList<String> = mutableListOf(),
    var returnScore:score
) :RecyclerView.Adapter<QuestionAdapter.ViewHolder>(){

    interface score{
        fun amount(number:Int,clickedAnswer: String)
    }

    private lateinit var binding: ViewholderQuestionBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionAdapter.ViewHolder {
    val inflater = LayoutInflater.from(parent.context)
        binding = ViewholderQuestionBinding.inflate(inflater,parent,false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: QuestionAdapter.ViewHolder, position: Int) {
        val binding = ViewholderQuestionBinding.bind(holder.itemView)
        binding.answerTxt.text=differ.currentList[position]
        var currentPas=0
        when(correctAnswer){
            "a"->{
                currentPas=0
            }
            "b"->{
                currentPas=1
            }
            "c"->{
                currentPas=2
            }
            "d"->{
                currentPas=3
            }
        }

        if(differ.currentList.size==5 && currentPas==position){
            binding.answerTxt.setBackgroundResource(R.drawable.green_background)
            binding.answerTxt.setTextColor(
                ContextCompat.getColor(
                    binding.root.context,
                    R.color.white
                )
            )
            val drawable=ContextCompat.getDrawable(binding.root.context,R.drawable.tick)
            binding.answerTxt.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, drawable, null)

        }

        if(differ.currentList.size==5){
            var clickedPas=0
            when(differ.currentList[4]){
                "a"->{
                    clickedPas=0
                }
                "b"->{
                    clickedPas=1
                }
                "c"->{
                    clickedPas=2
                }
                "d"->{
                    clickedPas=3
                }
            }
            if(clickedPas==position && clickedPas!= currentPas){
                binding.answerTxt.setBackgroundResource(R.drawable.red_background)
                binding.answerTxt.setTextColor(
                    ContextCompat.getColor(
                        binding.root.context,
                        R.color.white
                    )
                )
                val drawable=ContextCompat.getDrawable(binding.root.context,R.drawable.thieves)
                binding.answerTxt.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, drawable, null)
            }
        }
        if(position==4){
            binding.root.visibility= View.GONE
        }

        holder.itemView.setOnClickListener {
            var str=""
            when(position){
                0->{
                    str="a"
                }
                1->{
                    str="b"
                }
                2->{
                    str="c"
                }
                3->{
                    str="d"
                }
            }

            users.add(4,str)
            notifyDataSetChanged()

            if(currentPas==position){
                binding.answerTxt.setBackgroundResource(R.drawable.green_background)
                binding.answerTxt.setTextColor(
                    ContextCompat.getColor(
                        binding.root.context,
                        R.color.white
                    )
                )
                val drawable=ContextCompat.getDrawable(binding.root.context,R.drawable.tick)
                binding.answerTxt.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, drawable, null)
                returnScore.amount(5,str)
            }else{
                binding.answerTxt.setBackgroundResource(R.drawable.red_background)
                binding.answerTxt.setTextColor(
                    ContextCompat.getColor(
                        binding.root.context,
                        R.color.white
                    )
                )
                val drawable=ContextCompat.getDrawable(binding.root.context,R.drawable.thieves)
                binding.answerTxt.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, drawable, null)
                returnScore.amount(0,str)
            }
        }
        if (differ.currentList.size==5) holder.itemView.setOnClickListener(null)
    }

    override fun getItemCount() = differ.currentList.size

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)
}