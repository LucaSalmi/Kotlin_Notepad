package com.example.kotlinnotepad

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import java.io.File

object Reader {

    fun readFiles(array: MutableList<String>, context: Context){

        val path = context.filesDir
        val letDirectory = File(path, "Notes")
        letDirectory.walkTopDown().forEach {
            if (it.name != "Notes"){

                array.add(it.name)
            }

        }
    }

    fun checkFilesForSame(note: String, context: Context): Boolean {

        val path = context.filesDir
        val letDirectory = File(path, "Notes")
        var isSame = false

        letDirectory.walkTopDown().forEach {

            if (it.name == note){

                isSame = true
            }

        }
        Log.d(TAG, "checkFilesForSame: $isSame ")
        return isSame
    }

    fun deleteNote(note: String, context: Context){

        val path = context.filesDir
        val letDirectory = File(path, "Notes")
        letDirectory.walkTopDown().forEach {

            if (it.name == note){
                it.delete()
            }
        }

    }
}