package com.example.notesapp
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.db.Note
import com.example.notesapp.db.NoteDatabase
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(),notesAdapter.ClickListener {
    private lateinit var repo: Repo
    private lateinit var notesViewModel: NotesViewModel
    private lateinit var notesViewModelFactory: NotesViewModelFactory
    private lateinit var noteDatabase: NoteDatabase
    private lateinit var Notesadapter: notesAdapter
    private lateinit var rv: RecyclerView
    private lateinit var fab:FloatingActionButton
    private lateinit var dialog:Dialog
    private lateinit var edtNoteName:EditText
    private lateinit var edtNoteContent:EditText
    private lateinit var btnSave:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        notesViewModel.getAllNotes().observe(this) {
            Notesadapter = notesAdapter(it,this)
            rv.adapter = Notesadapter
            rv.layoutManager = LinearLayoutManager(this)

        }

        fab.setOnClickListener{
           Opendialog(comingFromFAB = true)

        }

    }
    private fun Opendialog(comingFromFAB:Boolean){
        dialog=Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.layout_dialog)

        edtNoteName=dialog.findViewById(R.id.edt_note_name)
        edtNoteContent=dialog.findViewById(R.id.edt_note_content)
        btnSave=dialog.findViewById(R.id.btn_save_note)

        btnSave.setOnClickListener{
            // create a note
            val note=Note(
                notesName = edtNoteName.text.toString(),
                content = edtNoteContent.text.toString()
            )
            if (comingFromFAB){
                //if user clicked on floating action button then we have TO INSERT THE ENTERY
                notesViewModel.insert(note)
            }else{
                // if user clicked to inserted notr then open UPdate entery pannel
                notesViewModel.update(note)
            }

            dialog.dismiss()
        }
        dialog.show()
    }

    private fun init() {
        noteDatabase = NoteDatabase(this)
        repo = Repo(noteDatabase.getNoteDao())
        notesViewModelFactory = NotesViewModelFactory(repo)
        notesViewModel = ViewModelProvider(this, notesViewModelFactory).get(NotesViewModel::class.java)
        rv = findViewById(R.id.recyclerview)
        fab=findViewById(R.id.fab)
    }

    override fun updateNote(note: Note) {
        //we can write the logic of updating the  node
       Opendialog(comingFromFAB = false)
    }

    override fun deleteNote(note: Note) {
        // we can write the logic of deleting Note by Clicking on delete image
        notesViewModel.delete(note)
    }
}