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
fun ThemeScreen(viewModel: ThemeViewModel) {
    val isDark by viewModel.isDark.collectAsState()
    val syncTheme by viewModel.syncTheme.collectAsState()
    val colorOptions by viewModel.namedColors.collectAsState()

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
                viewModel.setDark(false)
            }
            ThemeButton(true) {
                viewModel.setDark(true)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Divider()
        SyncThemeExample(syncTheme = syncTheme)
        Divider()
        Spacer(modifier = Modifier.height(16.dp))
        ClipboardButton(text = syncTheme.toJson().toString())
        ColorList(syncTheme = syncTheme, colorOptions = colorOptions)
        Text(text = "${isDark}")
    }
}
