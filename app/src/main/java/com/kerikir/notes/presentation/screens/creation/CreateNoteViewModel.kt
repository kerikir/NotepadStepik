package com.kerikir.notes.presentation.screens.creation

import androidx.lifecycle.ViewModel

class CreateNoteViewModel: ViewModel() {
}


sealed interface CreateNoteState {

    data class Creation(
        val title: String,
        val content: String,
        val isSaveEnabled: Boolean
    ) : CreateNoteState

    data object Finished: CreateNoteState
}