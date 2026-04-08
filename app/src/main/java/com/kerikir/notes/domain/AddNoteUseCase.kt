package com.kerikir.notes.domain

class AddNoteUseCase(
    private val repository: NotesRepository
) {

    operator fun invoke(
        title: String,
        content: String
    ) {
        repository.addNote(
            title = title,
            content = content,
            isPinned = false,
            updatedAt = System.currentTimeMillis()
        )
    }
}