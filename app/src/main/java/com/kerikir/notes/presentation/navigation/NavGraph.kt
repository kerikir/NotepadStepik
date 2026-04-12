package com.kerikir.notes.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.kerikir.notes.presentation.screens.creation.CreateNoteScreen
import com.kerikir.notes.presentation.screens.editing.EditNoteScreen
import com.kerikir.notes.presentation.screens.notes.NotesScreen

@Composable
fun NavGraph() {

}



@Composable
fun CustomNavGraph() {
    val screen = remember {
        mutableStateOf<CustomScreen>(CustomScreen.Notes)
    }

    when (val currentScreen = screen.value) {
        CustomScreen.CreateNote -> {
            CreateNoteScreen(
                onFinished = {
                    screen.value = CustomScreen.Notes
                }
            )
        }

        is CustomScreen.EditNote -> {
            EditNoteScreen(
                noteId = currentScreen.noteId,
                onFinished = {
                    screen.value = CustomScreen.Notes
                }
            )
        }

        CustomScreen.Notes -> {
            NotesScreen(
                onNoteClick = {
                    screen.value = CustomScreen.EditNote(it.id)
                },
                onAddNoteClick = {
                    screen.value = CustomScreen.CreateNote
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


sealed interface CustomScreen {

    data object Notes: CustomScreen

    data object CreateNote: CustomScreen

    data class EditNote(val noteId: Int): CustomScreen
}