package com.kerikir.notes.presentation.screens.notes

import androidx.lifecycle.ViewModel
import com.kerikir.notes.data.TestNotesRepositoryImpl
import com.kerikir.notes.domain.AddNoteUseCase
import com.kerikir.notes.domain.DeleteNoteUseCase
import com.kerikir.notes.domain.EditNoteUseCase
import com.kerikir.notes.domain.GetAllNotesUseCase
import com.kerikir.notes.domain.GetNoteUseCase
import com.kerikir.notes.domain.Note
import com.kerikir.notes.domain.SearchNotesUseCase
import com.kerikir.notes.domain.SwitchPinnedStatusUseCase


class NotesViewModel : ViewModel() {

    private val repository = TestNotesRepositoryImpl

    private val getAllNotesUseCase = GetAllNotesUseCase(repository)
    private val searchNotesUseCase = SearchNotesUseCase(repository)
    private val switchPinnedStatusUseCase = SwitchPinnedStatusUseCase(repository)

    private val addNoteUseCase = AddNoteUseCase(repository)
    private val editNoteUseCase = EditNoteUseCase(repository)
    private val deleteNoteUseCase = DeleteNoteUseCase(repository)
    private val getNoteUseCase = GetNoteUseCase(repository)
}


data class NotesScreenState(
    val query: String = "",
    val pinnedNotes: List<Note> = listOf(),
    val otherNotes: List<Note> = listOf()
)