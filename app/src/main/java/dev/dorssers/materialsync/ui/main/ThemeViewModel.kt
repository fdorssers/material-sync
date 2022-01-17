package dev.dorssers.materialsync.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dev.dorssers.materialsync.data.NamedColor
import dev.dorssers.materialsync.data.SyncTheme
import dev.dorssers.materialsync.data.createTheme
import dev.dorssers.materialsync.data.getNamedColors
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class ThemeViewModel(application: Application) : AndroidViewModel(application) {

    private val initialValue = true

    private val _isDark = MutableStateFlow(initialValue)
    val isDark: StateFlow<Boolean> get() = _isDark.asStateFlow()

    private val _syncTheme = MutableStateFlow(
        createTheme(
            getApplication<Application>().applicationContext,
            initialValue
        )
    )
    val syncTheme: StateFlow<SyncTheme> get() = _syncTheme.asStateFlow()

    private val _namedColors = MutableStateFlow(
        getNamedColors(
            getApplication<Application>().applicationContext,
            initialValue
        )
    )
    val namedColors: StateFlow<List<NamedColor>> get() = _namedColors.asStateFlow()


    fun setDark(dark: Boolean) {
        _isDark.value = dark
        _syncTheme.value =
            createTheme(getApplication<Application>().applicationContext, dark)
        _namedColors.value = getNamedColors(getApplication<Application>().applicationContext, dark)
    }
}
