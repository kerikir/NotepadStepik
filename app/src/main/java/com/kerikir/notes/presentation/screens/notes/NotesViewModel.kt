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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class NotesViewModel : ViewModel() {

    private val repository = TestNotesRepositoryImpl

    private val getAllNotesUseCase = GetAllNotesUseCase(repository)
    private val searchNotesUseCase = SearchNotesUseCase(repository)
    private val switchPinnedStatusUseCase = SwitchPinnedStatusUseCase(repository)

    private val addNoteUseCase = AddNoteUseCase(repository)
    private val editNoteUseCase = EditNoteUseCase(repository)
    private val deleteNoteUseCase = DeleteNoteUseCase(repository)
    private val getNoteUseCase = GetNoteUseCase(repository)

    private val _state = MutableStateFlow(NotesScreenState())
    val state = _state.asStateFlow()
}



sealed interface NotesCommand {

    data class InputSearchQuery(val query: String) : NotesCommand

    data class SwitchPinnedStatus(val noteId: Int) : NotesCommand

    // Temp

    data class DeleteNote(val noteId: Int) : NotesCommand

    data class EditNote(val note: Note) : NotesCommand
}



data class NotesScreenState(
    val query: String = "",
    val pinnedNotes: List<Note> = listOf(),
    val otherNotes: List<Note> = listOf()
)