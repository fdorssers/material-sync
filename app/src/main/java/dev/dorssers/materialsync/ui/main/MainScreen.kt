package dev.dorssers.materialsync.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import dev.dorssers.materialsync.data.SyncTheme
import dev.dorssers.materialsync.data.createTheme

@Composable
fun MainScreen() {
    var syncTheme by remember { mutableStateOf(SyncTheme.default()) }
    var textFieldValue = TextFieldValue(syncTheme.toJson().toString())
    val context = LocalContext.current
    Column(Modifier.padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Material Sync", style = MaterialTheme.typography.displayLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            ThemeButton(false) { syncTheme = createTheme(context, false) }
            ThemeButton(true) { syncTheme = createTheme(context, true) }
        }
        BasicTextField(modifier = Modifier.onFocusChanged { focusState ->
            if (focusState.isFocused) {
                textFieldValue = textFieldValue.copy(
                    selection = TextRange(
                        0,
                        textFieldValue.text.length
                    )
                )
            }
        }, value = textFieldValue, onValueChange = {})
        SyncThemeExample(syncTheme = syncTheme)
        ClipboardButton(text = syncTheme.toJson().toString())
        ColorList(syncTheme = syncTheme)
    }
}
