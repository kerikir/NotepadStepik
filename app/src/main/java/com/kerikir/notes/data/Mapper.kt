package com.kerikir.notes.data

import com.kerikir.notes.domain.ContentItem
import com.kerikir.notes.domain.Note

fun Note.toDbModel(): NoteDbModel {
    return NoteDbModel(id, title, content, updatedAt, isPinned)
}


fun List<ContentItem>.toContentItemsDbModel(): List<ContentItemDbModel> {
    return map { contentItem ->
        when (contentItem) {
            is ContentItem.Image -> {
                ContentItemDbModel.Image(url = contentItem.url)
            }
            is ContentItem.Text -> {
                ContentItemDbModel.Text(content = contentItem.content)
            }
        }
    }
}


fun List<ContentItemDbModel>.toContentItems(): List<ContentItem> {
    return map { contentItem ->
        when (contentItem) {
            is ContentItemDbModel.Image -> {
                ContentItem.Image(url = contentItem.url)
            }
            is ContentItemDbModel.Text -> {
                ContentItem.Text(content = contentItem.content)
            }
        }
    }
}


fun NoteDbModel.toEntity(): Note {
    return Note(id, title, content, updatedAt, isPinned)
}


fun List<NoteDbModel>.toEntities(): List<Note> {
    return this.map { it.toEntity() }
}