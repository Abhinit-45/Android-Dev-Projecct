package com.example.notesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.db.Note

class notesAdapter(
    private val listOfNotes: List<Note>,
    private val clickListener:ClickListener
) : RecyclerView.Adapter<notesAdapter.NotesViewHolder>() {

    class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textName: TextView = itemView.findViewById(R.id.heading)
        val textContent: TextView = itemView.findViewById(R.id.subtittle)
        val imgDelete: ImageView = itemView.findViewById(R.id.delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        //create the view and return it
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_note, parent, false)
        return NotesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfNotes.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
       //getting current note
        val currentnote = listOfNotes[position]
        holder.textName.text = currentnote.notesName
        holder.textContent.text = currentnote.content

        holder.itemView.setOnClickListener{
            clickListener.updateNote(currentnote)
        }
       holder.imgDelete.setOnClickListener{
           clickListener.deleteNote(currentnote)
       }
    }

    interface ClickListener{
        fun updateNote(note:Note)
        fun deleteNote(note:Note)
    }

}