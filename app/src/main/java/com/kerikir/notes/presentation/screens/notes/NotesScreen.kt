package com.kerikir.notes.presentation.screens.notes

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun NotesScreen(
    modifier: Modifier = Modifier,
    viewModel: NotesViewModel = viewModel()
) {

    val state = viewModel.state.collectAsState()

    val currentState = state.value

    val scrollState = remember {
        ScrollState(0)
    }

    Column(
        modifier = Modifier
            .padding(top = 48.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        currentState.otherNotes.forEach { note ->
            Text(
                modifier = Modifier.clickable {
                    viewModel.processCommand(NotesCommand.EditNote(note))
                },
                text = "${note.title} - ${note.content}",
                fontSize = 24.sp
            )
        }
    }
}