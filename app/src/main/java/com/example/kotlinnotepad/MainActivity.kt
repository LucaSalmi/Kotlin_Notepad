package com.example.kotlinnotepad

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinnotepad.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
private lateinit var adapter: Adapter

class MainActivity : AppCompatActivity() {

    val notesArray = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Reader.readFiles(notesArray, this)

        binding.notesList.layoutManager = LinearLayoutManager(this)
        adapter = Adapter(notesArray) { position -> onListItemClick(position) }
        binding.notesList.adapter = adapter

        binding.saveBtn.setOnClickListener {

            var s = binding.noteSpace.text.toString()

            if (Reader.checkFilesForSame(s, this)){

                return@setOnClickListener
            }

            notesArray.add(s)
            adapter.notifyItemInserted(notesArray.size)
            binding.noteSpace.text?.clear()
            Writer(s, this)

        }



    }

    private fun onListItemClick(position: Int){

        Log.d(TAG, "onListItemClick: $position")
        Log.d(TAG, "onListItemClick: $notesArray")
        binding.noteSpace.setText(notesArray[position])
        Reader.deleteNote(notesArray[position], this)
        notesArray.removeAt(position)
        adapter.notifyItemRemoved(position)

    }

}