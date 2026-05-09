package com.kerikir.notes.data

data class NoteWithContentDbModel(
    val noteDbModel: NoteDbModel,
    val content: List<ContentItemDbModel>
)