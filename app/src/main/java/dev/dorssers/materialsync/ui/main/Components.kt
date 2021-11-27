package dev.dorssers.materialsync.ui.main

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import dev.dorssers.materialsync.data.SyncTheme
import dev.dorssers.materialsync.util.copyToClipboard

@Composable
fun SyncThemeExample(syncTheme: SyncTheme) {
    Card(
        Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .shadow(6.dp)
    ) {
        Column(
            Modifier
                .background(color = syncTheme.contentColor.color)
                .fillMaxWidth()
        ) {
            Column(
                Modifier
                    .background(color = syncTheme.primaryColor.color)
                    .fillMaxWidth()
            ) {
                Text(text = "Primary color")
            }
            Text(text = "Primary text color", color = syncTheme.primaryTextColor.color)
            Text(text = "Secondary text color", color = syncTheme.secondaryTextColor.color)
            Text(text = "Highlight color", color = syncTheme.highlightColor.color)
            Text(text = "Accent color", color = syncTheme.accentColor.color)
        }
    }
}


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

@Composable
fun ColorList(syncTheme: SyncTheme) {
    val items = syncTheme.toColorList()
    Column(Modifier.fillMaxWidth()) {
        items.forEach { (name, color) -> ColorExample(name = name, color = color.color) }
    }
}

@Composable
fun ColorExample(name: String, color: Color) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = name)
        Box(
            Modifier
                .size(26.dp)
                .clip(CircleShape)
                .background(color)
                .border(2.dp, Color.Black, shape = CircleShape)
        )
    }
}
