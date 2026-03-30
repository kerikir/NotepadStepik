package com.kerikir.notes.domain

import kotlinx.coroutines.flow.Flow

class SearchNotesUseCase {

    operator fun invoke(search: String): Flow<List<Note>> {
        TODO()
    }
}