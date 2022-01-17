package dev.dorssers.materialsync.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.dorssers.materialsync.data.NamedColor
import dev.dorssers.materialsync.data.SyncTheme
import dev.dorssers.materialsync.data.getNamedColors


@Composable
fun ColorList(syncTheme: SyncTheme, colorOptions: List<NamedColor>) {
    val items = syncTheme.toColorList()
    val collapsedState = remember(items) { items.map { true }.toMutableStateList() }
    Column(Modifier.fillMaxWidth().padding(start=16.dp, end=16.dp)) {
//        items.forEach { (name, color) -> ColorExample(name = name, color = color.color)}
        items.forEachIndexed { index, (name, color) ->
            val collapsed = collapsedState[index]
            ColorExample(
                name = name,
                color = color.color,
                colorOptions = colorOptions,
                collapsed = collapsed,
                onClick = { collapsedState[index] = !collapsed }
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ColorExample(
    name: String,
    color: Color,
    colorOptions: List<NamedColor> = listOf(),
    collapsed: Boolean = true,
    onClick: () -> Unit = {}
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onClick() },
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
    if (!collapsed) {
        colorOptions.forEach {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(it.color)
                    .padding(8.dp)
            ) {
                Text(text = it.option.name)
            }
        }
    }
}


@Preview
@Composable
fun ColorListPreview() {
    ColorList(
        syncTheme = SyncTheme.default(LocalContext.current),
        colorOptions = getNamedColors(LocalContext.current, false)
    )
}

@Preview
@Composable
fun ColorExamplePreviewCollapsed() {
    ColorExample("Example color", Color.Yellow)
}

@Preview
@Composable
fun ColorExamplePreviewOpen() {
    ColorExample(
        name = "Example color",
        color = Color.Yellow,
        colorOptions = getNamedColors(LocalContext.current, false),
        collapsed = false
    )
}
