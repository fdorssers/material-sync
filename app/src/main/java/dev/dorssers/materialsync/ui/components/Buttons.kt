package dev.dorssers.materialsync.ui.components

import android.widget.Toast
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import dev.dorssers.materialsync.util.copyToClipboard

@Composable
fun ThemeButton(dark: Boolean, onClick: () -> Unit) {
    OutlinedButton(onClick = onClick) {
        Text(text = if (dark) "Dark" else "Light")
    }
}


@Composable
fun ClipboardButton(text: String) {
    val context = LocalContext.current
    FilledTonalButton(onClick = {
        copyToClipboard(
            text,
            context
        )
        Toast.makeText(context, "Copied theme to clipboard", Toast.LENGTH_SHORT).show()
    }) {
        Text(text = "Copy to clipboard")
    }
}
