package dev.dorssers.materialsync.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import dev.dorssers.materialsync.data.SyncTheme

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
