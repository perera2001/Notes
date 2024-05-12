package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notesapp.databinding.ActivityAddNoteBinding

class AddNoteActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAddNoteBinding
    private lateinit var db:NoteDataBaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db=NoteDataBaseHelper(this)
        binding.saveButton.setOnClickListener{
            val title=binding.titleEditText.text.toString()
            val content=binding.contentEditText.toString()
            val note=Note(0,title,content)
            db.insertNote(note)
            finish()
            Toast.makeText(this,"Note saved",Toast.LENGTH_SHORT).show()

        }
    }
}