package com.kerikir.notes.presentation.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.kerikir.notes.presentation.screens.creation.CreateNoteScreen
import com.kerikir.notes.presentation.screens.editing.EditNoteScreen
import com.kerikir.notes.presentation.screens.notes.NotesScreen

@Composable
fun NavGraph() {
    val screen = remember {
        mutableStateOf<Screen>(Screen.Notes)
    }
    val currentScreen = screen.value

    when (currentScreen) {
        Screen.CreateNote -> {
            CreateNoteScreen(
                onFinished = {

                }
            )
        }

        is Screen.EditNote -> {
            EditNoteScreen(
                noteId = 5,
                onFinished = {

                }
            )
        }

        Screen.Notes -> {
            NotesScreen(
                onNoteClick = {
                    screen.value = Screen.EditNote(it.id)
                },
                onAddNoteClick = {
                    screen.value = Screen.CreateNote
                }
            )
        }
    }
}


sealed interface Screen {

    data object Notes: Screen

    data object CreateNote: Screen

    data class EditNote(val noteId: Int): Screen
}