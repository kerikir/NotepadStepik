package com.kerikir.notes.presentation.utils

import java.util.concurrent.TimeUnit

object DateFormatter {

    fun formatDateToString(timespan: Long): String {
        val now = System.currentTimeMillis()
        val diff = now - timespan

        return when {
            diff < TimeUnit.HOURS.toMillis(1) -> "Just now"
        }
    }
}