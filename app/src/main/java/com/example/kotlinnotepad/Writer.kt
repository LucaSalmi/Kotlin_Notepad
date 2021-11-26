package com.example.kotlinnotepad

import android.content.Context
import android.widget.Toast
import java.io.File

class Writer(text: String, context: Context) {



    init {

        val path = context.filesDir
        val letDirectory = File(path, "Notes")
        letDirectory.mkdirs()

        var file = File(letDirectory, text)
        val isNewFileCreated : Boolean = file.createNewFile()

        if (isNewFileCreated){
            Toast.makeText(context, "note saved", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "note already exists", Toast.LENGTH_SHORT).show()
        }
    }
}