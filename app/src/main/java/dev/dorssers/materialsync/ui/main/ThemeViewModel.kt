package dev.dorssers.materialsync.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.dorssers.materialsync.data.NamedColor
import dev.dorssers.materialsync.data.SyncTheme
import dev.dorssers.materialsync.data.createTheme
import dev.dorssers.materialsync.data.getNamedColors
import kotlinx.coroutines.flow.*


class ThemeViewModel(application: Application) : AndroidViewModel(application) {

    private val initialValue = true

    private val _isDark = MutableStateFlow(initialValue)
    val isDark: StateFlow<Boolean> get() = _isDark

    val syncTheme: StateFlow<SyncTheme>
        get() = isDark.map {
            createTheme(
                getApplication<Application>().applicationContext,
                _isDark.value
            )
        }.stateIn(
            viewModelScope, SharingStarted.Eagerly, createTheme(
                getApplication<Application>().applicationContext,
                initialValue
            )
        )

    val namedColors: StateFlow<List<NamedColor>>
        get() = isDark.map {
            getNamedColors(getApplication<Application>().applicationContext, _isDark.value)
        }.stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            getNamedColors(getApplication<Application>().applicationContext, _isDark.value)
        )


    fun setDark(dark: Boolean) {
        _isDark.value = dark
//        _isDark.map {
//            createTheme(
//                getApplication<Application>().applicationContext,
//                _isDark.value
//            )
//        }
    }
}
