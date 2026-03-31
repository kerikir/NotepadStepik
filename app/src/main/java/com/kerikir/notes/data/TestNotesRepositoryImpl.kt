package com.kerikir.notes.data

import com.kerikir.notes.domain.Note
import com.kerikir.notes.domain.NotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class TestNotesRepositoryImpl : NotesRepository {

    private val notesListFlow = MutableStateFlow<List<Note>>(listOf())

    override fun addNote(note: Note) {
        TODO("Not yet implemented")
    }

    override fun deleteNote(noteId: Int) {
        TODO("Not yet implemented")
    }

    override fun editNote(note: Note) {
        TODO("Not yet implemented")
    }

    override fun getAllNotes(): Flow<List<Note>> {
        TODO("Not yet implemented")
    }

    override fun getNote(noteId: Int): Note {
        TODO("Not yet implemented")
    }

    override fun searchNotes(query: String): Flow<List<Note>> {
        TODO("Not yet implemented")
    }

    override fun switchPinnedStatus(noteId: Int) {
        TODO("Not yet implemented")
    }
}