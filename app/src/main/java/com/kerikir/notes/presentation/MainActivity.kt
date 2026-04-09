package com.kerikir.notes.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.kerikir.notes.presentation.screens.notes.NotesScreen
import com.kerikir.notes.presentation.ui.theme.NotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotesTheme {
                NotesScreen(
                    onNoteClick = {
                        Log.d("MainActivity", "onNoteClick: $it")
                    },
                    onFabClick = {
                        Log.d("MainActivity", "on FAB click")
                    }
                )
            }
        }
    }
}