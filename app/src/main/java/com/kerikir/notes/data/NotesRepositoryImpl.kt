package com.kerikir.notes.data

import android.content.Context
import com.kerikir.notes.domain.Note
import com.kerikir.notes.domain.NotesRepository
import kotlinx.coroutines.flow.Flow

class NotesRepositoryImpl(context: Context) : NotesRepository {

    private val notesDatabase = NotesDatabase.getInstance(context)
    private val notesDao = notesDatabase.notesDao()


    override suspend fun addNote(
        title: String,
        content: String,
        isPinned: Boolean,
        updatedAt: Long
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNote(noteId: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun editNote(note: Note) {
        TODO("Not yet implemented")
    }

    override fun getAllNotes(): Flow<List<Note>> {
        TODO("Not yet implemented")
    }

    override suspend fun getNote(noteId: Int): Note {
        TODO("Not yet implemented")
    }

    override fun searchNotes(query: String): Flow<List<Note>> {
        TODO("Not yet implemented")
    }

    override suspend fun switchPinnedStatus(noteId: Int) {
        TODO("Not yet implemented")
    }
}