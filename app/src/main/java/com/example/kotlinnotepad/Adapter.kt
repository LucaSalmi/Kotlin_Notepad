package com.example.kotlinnotepad

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinnotepad.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class Adapter (private val list: MutableList<String>, private val onItemClicked: (position: Int) -> Unit) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_layout, parent, false)

        
        return ViewHolder(view, onItemClicked)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.textView.text = list[position]


    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(ItemView: View, private val onItemClicked: (position: Int) -> Unit) : RecyclerView.ViewHolder(ItemView), View.OnClickListener {

        val textView: TextView = itemView.findViewById(R.id.textView)

        init {
            textView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

            val position = adapterPosition
            onItemClicked(position)
        }


    }

}