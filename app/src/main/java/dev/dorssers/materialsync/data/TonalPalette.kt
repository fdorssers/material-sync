package dev.dorssers.materialsync.data

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color

enum class ColorOption {
    PRIMARY,
    ON_PRIMARY,
    PRIMARY_CONTAINER,
    ON_PRIMARY_CONTAINER,
    INVERSE_PRIMARY,
    SECONDARY,
    ON_SECONDARY,
    SECONDARY_CONTAINER,
    ON_SECONDARY_CONTAINER,
    TERTIARY,
    ON_TERTIARY,
    TERTIARY_CONTAINER,
    ON_TERTIARY_CONTAINER,
    BACKGROUND,
    ON_BACKGROUND,
    SURFACE,
    ON_SURFACE,
    SURFACE_VARIANT,
    ON_SURFACE_VARIANT,
    INVERSE_SURFACE,
    INVERSE_ON_SURFACE,
    ERROR,
    ON_ERROR,
    ERROR_CONTAINER,
    ON_ERROR_CONTAINER,
    OUTLINE,
}

fun ColorScheme.getColor(colorOption: ColorOption): Color {
    return when (colorOption) {
        ColorOption.PRIMARY -> primary
        ColorOption.ON_PRIMARY -> onPrimary
        ColorOption.PRIMARY_CONTAINER -> primaryContainer
        ColorOption.ON_PRIMARY_CONTAINER -> onPrimaryContainer
        ColorOption.INVERSE_PRIMARY -> inversePrimary
        ColorOption.SECONDARY -> secondary
        ColorOption.ON_SECONDARY -> onSecondary
        ColorOption.SECONDARY_CONTAINER -> secondaryContainer
        ColorOption.ON_SECONDARY_CONTAINER -> onSecondaryContainer
        ColorOption.TERTIARY -> tertiary
        ColorOption.ON_TERTIARY -> onTertiary
        ColorOption.TERTIARY_CONTAINER -> tertiaryContainer
        ColorOption.ON_TERTIARY_CONTAINER -> onTertiaryContainer
        ColorOption.BACKGROUND -> background
        ColorOption.ON_BACKGROUND -> onBackground
        ColorOption.SURFACE -> surface
        ColorOption.ON_SURFACE -> onSurface
        ColorOption.SURFACE_VARIANT -> surfaceVariant
        ColorOption.ON_SURFACE_VARIANT -> onSurfaceVariant
        ColorOption.INVERSE_SURFACE -> inverseSurface
        ColorOption.INVERSE_ON_SURFACE -> inverseOnSurface
        ColorOption.ERROR -> error
        ColorOption.ON_ERROR -> onError
        ColorOption.ERROR_CONTAINER -> errorContainer
        ColorOption.ON_ERROR_CONTAINER -> onErrorContainer
        ColorOption.OUTLINE -> outline
    }
}

data class NamedColor(val option: ColorOption, val color: Color)

fun ColorScheme.getNamedColors(): List<NamedColor> {
    return listOf(
        NamedColor(option=ColorOption.PRIMARY, color=this.primary),
        NamedColor(option=ColorOption.ON_PRIMARY, color=this.onPrimary),
        NamedColor(option=ColorOption.PRIMARY_CONTAINER, color=this.primaryContainer),
        NamedColor(option=ColorOption.ON_PRIMARY_CONTAINER, color=this.onPrimaryContainer),
        NamedColor(option=ColorOption.INVERSE_PRIMARY, color=this.inversePrimary),
        NamedColor(option=ColorOption.SECONDARY, color=this.secondary),
        NamedColor(option=ColorOption.ON_SECONDARY, color=this.onSecondary),
        NamedColor(option=ColorOption.SECONDARY_CONTAINER, color=this.secondaryContainer),
        NamedColor(option=ColorOption.ON_SECONDARY_CONTAINER, color=this.onSecondaryContainer),
        NamedColor(option=ColorOption.TERTIARY, color=this.tertiary),
        NamedColor(option=ColorOption.ON_TERTIARY, color=this.onTertiary),
        NamedColor(option=ColorOption.TERTIARY_CONTAINER, color=this.tertiaryContainer),
        NamedColor(option=ColorOption.ON_TERTIARY_CONTAINER, color=this.onTertiaryContainer),
        NamedColor(option=ColorOption.BACKGROUND, color=this.background),
        NamedColor(option=ColorOption.ON_BACKGROUND, color=this.onBackground),
        NamedColor(option=ColorOption.SURFACE, color=this.surface),
        NamedColor(option=ColorOption.ON_SURFACE, color=this.onSurface),
        NamedColor(option=ColorOption.SURFACE_VARIANT, color=this.surfaceVariant),
        NamedColor(option=ColorOption.ON_SURFACE_VARIANT, color=this.onSurfaceVariant),
        NamedColor(option=ColorOption.INVERSE_SURFACE, color=this.inverseSurface),
        NamedColor(option=ColorOption.INVERSE_ON_SURFACE, color=this.inverseOnSurface),
        NamedColor(option=ColorOption.ERROR, color=this.error),
        NamedColor(option=ColorOption.ON_ERROR, color=this.onError),
        NamedColor(option=ColorOption.ERROR_CONTAINER, color=this.errorContainer),
        NamedColor(option=ColorOption.ON_ERROR_CONTAINER, color=this.onErrorContainer),
        NamedColor(option=ColorOption.OUTLINE, color=this.outline),
    )
}

class NamedColorScheme
