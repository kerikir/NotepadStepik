package com.kerikir.notes.presentation.screens.creation

import androidx.lifecycle.ViewModel
import com.kerikir.notes.data.TestNotesRepositoryImpl
import com.kerikir.notes.domain.AddNoteUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CreateNoteViewModel: ViewModel() {

    private val repository = TestNotesRepositoryImpl
    private val addNoteUseCase = AddNoteUseCase(repository)

    private val _state = MutableStateFlow<CreateNoteState>(CreateNoteState.Creation())
    val state = _state.asStateFlow()
}


sealed interface CreateNoteCommand {

    data class InputTitle(val title: String) : CreateNoteCommand

    data class InputContent(val content: String) : CreateNoteCommand

    data object Save : CreateNoteCommand

    data object Back : CreateNoteCommand
}


sealed interface CreateNoteState {

    data class Creation(
        val title: String = "",
        val content: String = "",
        val isSaveEnabled: Boolean = false
    ) : CreateNoteState

    data object Finished: CreateNoteState
}