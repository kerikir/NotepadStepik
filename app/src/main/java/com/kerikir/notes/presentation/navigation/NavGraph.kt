package com.kerikir.notes.presentation.navigation

import androidx.compose.runtime.Composable

@Composable
fun NavGraph() {

}


sealed interface Screen {

    data object Notes: Screen

    data object CreateNote: Screen

    data class EditNote(val noteId: Int): Screen
}