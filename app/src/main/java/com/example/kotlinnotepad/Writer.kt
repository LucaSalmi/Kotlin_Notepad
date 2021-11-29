package com.example.kotlinnotepad

import android.content.Context
import android.widget.Toast
import java.io.File

class Writer(text: String, context: Context) {



    init {

        val path = context.filesDir
        val letDirectory = File(path, context.getString(R.string.folder_name))
        letDirectory.mkdirs()

        var file = File(letDirectory, text)
        val isNewFileCreated : Boolean = file.createNewFile()

        if (isNewFileCreated){
            Toast.makeText(context, context.getString(R.string.save_note_text), Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, context.getString(R.string.note_exist_text), Toast.LENGTH_SHORT).show()
        }
    }
}