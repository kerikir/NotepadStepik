package com.kerikir.notes.data

import com.kerikir.notes.domain.ContentItem
import com.kerikir.notes.domain.Note
import kotlinx.serialization.json.Json

fun Note.toDbModel(): NoteDbModel {
    return NoteDbModel(id, title, updatedAt, isPinned)
}


fun List<ContentItem>.toContentItemDbModels(noteId: Int): List<ContentItemDbModel> {
    return mapIndexed { index, contentItem ->
        when (contentItem) {
            is ContentItem.Image -> {
                ContentItemDbModel(
                    noteId = noteId,
                    contentType = ContentType.IMAGE,
                    content = contentItem.url,
                    order = index
                )
            }
            is ContentItem.Text -> {
                ContentItemDbModel(
                    noteId = noteId,
                    contentType = ContentType.TEXT,
                    content = contentItem.content,
                    order = index
                )
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
    val contentItemDbModels = Json.decodeFromString<List<ContentItemDbModel>>(content)
    return Note(id, title, contentItemDbModels.toContentItems(), updatedAt, isPinned)
}


fun List<NoteDbModel>.toEntities(): List<Note> {
    return this.map { it.toEntity() }
}