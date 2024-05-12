package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notesapp.databinding.ActivityMainBinding
import com.example.notesapp.databinding.ActivityUpdateNoteBinding

class UpdateNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateNoteBinding
    private lateinit var db:NoteDataBaseHelper
    private var noteId: Int=-1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityUpdateNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db=NoteDataBaseHelper(this)

        noteId=intent.getIntExtra("note_id",-1)
        if(noteId==-1){
            finish()
            return
        }
        val note=db.getNoteByID(noteId)
        binding.updateTitleEditText.setText(note.title)
        binding.updatecontentEditText.setText(note.content)

        binding.updateSaveButton.setOnClickListener{
            val newTitle=binding.updateTitleEditText.text.toString()
            val newContent=binding.updatecontentEditText.text.toString()
            val updateNote=Note(noteId,newTitle,newContent)
            db.updateNote(updateNote)
            finish()
            Toast.makeText(this,"changes saved",Toast.LENGTH_SHORT).show()

        }
    }
}