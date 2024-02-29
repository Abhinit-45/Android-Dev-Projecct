package com.example.notesapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notesTable")
data class Note(
    @ColumnInfo(name = "Id")
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val notesName:String,
    val content:String

)
