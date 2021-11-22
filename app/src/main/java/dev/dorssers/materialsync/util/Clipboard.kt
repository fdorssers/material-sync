package dev.dorssers.materialsync.util

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.core.content.ContextCompat

fun copyToClipboard(text: String, context: Context) {
    val clipboard: ClipboardManager? = ContextCompat.getSystemService(
        context,
        ClipboardManager::class.java
    )
    val clip = ClipData.newPlainText("Reddit Sync Theme", text)
    clipboard?.setPrimaryClip(clip)
}
