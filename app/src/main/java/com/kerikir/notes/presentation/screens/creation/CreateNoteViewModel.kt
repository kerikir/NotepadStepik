package com.kerikir.notes.presentation.screens.creation

import androidx.lifecycle.ViewModel

class CreateNoteViewModel: ViewModel() {
}


sealed interface CreateNoteCommand {

    data class InputTitle(val title: String) : CreateNoteCommand

    data class InputContent(val content: String) : CreateNoteCommand

    data object Save : CreateNoteCommand

    data object Back : CreateNoteCommand
}


sealed interface CreateNoteState {

    data class Creation(
        val title: String,
        val content: String,
        val isSaveEnabled: Boolean
    ) : CreateNoteState

    data object Finished: CreateNoteState
}