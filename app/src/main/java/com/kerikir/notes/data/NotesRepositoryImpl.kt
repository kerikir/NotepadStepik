package com.kerikir.notes.data

import android.content.Context
import com.kerikir.notes.domain.Note
import com.kerikir.notes.domain.NotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NotesRepositoryImpl(context: Context) : NotesRepository {

    private val notesDatabase = NotesDatabase.getInstance(context)
    private val notesDao = notesDatabase.notesDao()


    override suspend fun addNote(
        title: String,
        content: String,
        isPinned: Boolean,
        updatedAt: Long
    ) {
        val noteDbModel = NoteDbModel(0, title, content, updatedAt, isPinned)
        notesDao.addNote(noteDbModel)
    }

    override suspend fun deleteNote(noteId: Int) {
        notesDao.deleteNote(noteId)
    }

    override suspend fun editNote(note: Note) {
        notesDao.addNote(note.toDbModel())
    }

    override fun getAllNotes(): Flow<List<Note>> {
        return notesDao.getAllNotes().map { it.toEntities() }
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