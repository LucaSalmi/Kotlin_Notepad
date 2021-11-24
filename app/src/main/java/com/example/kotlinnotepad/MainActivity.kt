package com.example.kotlinnotepad

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinnotepad.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val array = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.notesList.layoutManager = LinearLayoutManager(this)
        val adapter = Adapter(array)
        binding.notesList.adapter = adapter

        binding.saveBtn.setOnClickListener {

            var s = binding.noteSpace.text.toString()
            array.add(s)
            adapter.notifyItemInserted(array.size)
            Writer(s, this)

        }

    }
}