package com.kerikir.notes.data

import android.content.Context
import androidx.core.net.toUri
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import java.util.UUID
import javax.inject.Inject

class ImageFileManager @Inject constructor(
    @ApplicationContext private val context: Context
) {

    private val imagesDir: File = context.filesDir


    fun copyImageToInternalStorage(url: String): String {

        val fileName = "IMG_${UUID.randomUUID()}.jpg"
        val file = File(imagesDir, fileName)

        context.contentResolver.openInputStream(url.toUri())?.use { inputStream ->
            file.outputStream().use { outputStream ->
                inputStream.copyTo(outputStream)
            }
        }

        return file.absolutePath
    }
}