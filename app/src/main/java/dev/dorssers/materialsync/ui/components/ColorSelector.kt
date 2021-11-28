package dev.dorssers.materialsync.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.dorssers.materialsync.data.SyncTheme


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

@Preview
@Composable
fun ColorListPreview() {
    ColorList(syncTheme = SyncTheme.default(LocalContext.current))
}

@Preview
@Composable
fun ColorExamplePreview() {
    ColorExample("Example color", Color.Yellow)
}
