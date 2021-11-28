package dev.dorssers.materialsync.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.dorssers.materialsync.data.createTheme
import dev.dorssers.materialsync.data.getNamedColors
import dev.dorssers.materialsync.ui.components.ClipboardButton
import dev.dorssers.materialsync.ui.components.ColorList
import dev.dorssers.materialsync.ui.components.SyncThemeExample
import dev.dorssers.materialsync.ui.components.ThemeButton
import timber.log.Timber

@Composable
fun ThemeScreen() {
    val context = LocalContext.current
    var isDark by remember { mutableStateOf(false) }
    var syncTheme by remember { mutableStateOf(createTheme(context, isDark)) }
    var colorOptions by remember { mutableStateOf(getNamedColors(context, isDark)) }
    Column(
        Modifier
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Material Sync",
            modifier = Modifier.padding(top = 24.dp),
            style = MaterialTheme.typography.displayLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            ThemeButton(false) {
                Timber.d("Update")
//                isDark = false
                syncTheme = createTheme(context, false)
                colorOptions = getNamedColors(context, false)
            }
            ThemeButton(true) {
//                isDark = true
                syncTheme = createTheme(context, true)
                colorOptions = getNamedColors(context, true)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Divider()
        SyncThemeExample(syncTheme = syncTheme)
        Divider()
        Spacer(modifier = Modifier.height(16.dp))
        ClipboardButton(text = syncTheme.toJson().toString())
        ColorList(syncTheme = syncTheme, colorOptions = colorOptions)
    }
}

@Preview
@Composable
fun ThemeScreenPreview() {
    ThemeScreen()
}
