package dev.dorssers.materialsync.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.dorssers.materialsync.data.SyncTheme

@Composable
fun SyncThemeExample(syncTheme: SyncTheme) {
    val horizontalTextPadding = 16.dp
    val verticalTextPadding = 12.dp
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = syncTheme.windowColor.color)
    ) {
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .shadow(6.dp),
            shape = RoundedCornerShape(4.dp)
        ) {
            Column(
                Modifier
                    .background(color = syncTheme.contentColor.color)
                    .fillMaxWidth()
            ) {
                Column(
                    Modifier
                        .background(color = syncTheme.primaryColor.color)
                        .padding(horizontal = horizontalTextPadding, vertical = verticalTextPadding)
                        .fillMaxWidth()
                ) {
                    Text(text = "Primary color")
                }
                Column(
                    Modifier.padding(
                        horizontal = horizontalTextPadding,
                        vertical = verticalTextPadding
                    )
                ) {
                    Text(text = "Primary text color", color = syncTheme.primaryTextColor.color)
                    Text(text = "Secondary text color", color = syncTheme.secondaryTextColor.color)
                    Text(text = "Highlight color", color = syncTheme.highlightColor.color)
                    Text(text = "Accent color", color = syncTheme.accentColor.color)
                }
            }
        }
    }
}

@Preview
@Composable
fun SyncThemeExamplePreview() {
    SyncThemeExample(syncTheme = SyncTheme.default(LocalContext.current))
}
