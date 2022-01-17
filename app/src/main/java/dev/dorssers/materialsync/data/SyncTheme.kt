package dev.dorssers.materialsync.data

import android.content.Context
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.google.gson.JsonObject
import com.google.gson.JsonPrimitive
import com.squareup.moshi.JsonClass
import java.time.Instant
import java.time.format.DateTimeFormatter

@JsonClass(generateAdapter = true)
data class SyncTheme(
//    @Json(name = "name") val name: String,
//    @Json(name = "primary_color") val primaryColor: Color,
//    @Json(name = "accent_color") val accentColor: Color,
//    @Json(name = "highlight_color") val highlightColor: Color,
//    @Json(name = "primary_text_color") val primaryTextColor: Color,
//    @Json(name = "secondary_text_color") val secondaryTextColor: Color,
//    @Json(name = "window_color") val windowColor: Color,
//    @Json(name = "content_color") val contentColor: Color,
//    @Json(name = "sticky_text_color") val stickyTextColor: Color

//    @SerializedName("name") val name: String,
//    @SerializedName("primary_color") val primaryColor: NamedColor,
//    @SerializedName("highlight_color") val highlightColor: NamedColor,
//    @SerializedName("accent_color") val accentColor: NamedColor,
//    @SerializedName("content_color") val contentColor: NamedColor,
//    @SerializedName("window_color") val windowColor: NamedColor,
//    @SerializedName("primary_text_color") val primaryTextColor: NamedColor,
//    @SerializedName("secondary_text_color") val secondaryTextColor: NamedColor,
//    @SerializedName("sticky_text_color") val stickyTextColor: NamedColor

    val name: String,
    val primaryColor: NamedColor,
    val highlightColor: NamedColor,
    val accentColor: NamedColor,
    val contentColor: NamedColor,
    val windowColor: NamedColor,
    val primaryTextColor: NamedColor,
    val secondaryTextColor: NamedColor,
    val stickyTextColor: NamedColor
) {
    fun toJson(): JsonObject {
        val jsonObject = JsonObject()
        jsonObject.add("name", JsonPrimitive(name))
        jsonObject.add("primary_color", JsonPrimitive(primaryColor.color.toHex()))
        jsonObject.add("highlight_color", JsonPrimitive(highlightColor.color.toHex()))
        jsonObject.add("accent_color", JsonPrimitive(accentColor.color.toHex()))
        jsonObject.add("content_color", JsonPrimitive(contentColor.color.toHex()))
        jsonObject.add("window_color", JsonPrimitive(windowColor.color.toHex()))
        jsonObject.add("primary_text_color", JsonPrimitive(primaryTextColor.color.toHex()))
        jsonObject.add("secondary_text_color", JsonPrimitive(secondaryTextColor.color.toHex()))
        jsonObject.add("sticky_text_color", JsonPrimitive(stickyTextColor.color.toHex()))
        return jsonObject
    }

    fun toColorList(): List<Pair<String, NamedColor>> {
        return listOf(
            Pair("Primary color", primaryColor),
            Pair("Highlight color", highlightColor),
            Pair("Accent color", accentColor),
            Pair("Content color", contentColor),
            Pair("Window color", windowColor),
            Pair("Primary text color", primaryTextColor),
            Pair("Secondary text color", secondaryTextColor),
            Pair("Sticky text color", stickyTextColor),
        )
    }

    companion object {
        fun default(context: Context): SyncTheme {
            return createTheme(context, false)
        }
    }
}

fun Color.toHex(): String {
    val hex = "#" + Integer.toHexString(this.toArgb()).substring(2)
    return hex
}

fun createTheme(context: Context, dark: Boolean): SyncTheme {
    val colorScheme =
        if (dark) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    return SyncTheme(
        name = "Material You ${if (dark) "Dark" else "Light"} (${
            DateTimeFormatter.ISO_INSTANT.format(
                Instant.now()
            )
        })",
        primaryColor = NamedColor(ColorOption.PRIMARY, colorScheme.primary),
//        accentColor = NamedColor(ColorOption.TERTIARY, colorScheme.tertiary),
        accentColor = if (dark) {
            NamedColor(ColorOption.ON_TERTIARY_CONTAINER, colorScheme.onTertiaryContainer)
        } else {
            NamedColor(ColorOption.INVERSE_PRIMARY, colorScheme.inversePrimary)
        },
//        highlightColor = NamedColor(ColorOption.ON_TERTIARY_CONTAINER, colorScheme.onTertiaryContainer),
        highlightColor = NamedColor(ColorOption.TERTIARY, colorScheme.tertiary),
        primaryTextColor = NamedColor(ColorOption.PRIMARY, colorScheme.primary),
        secondaryTextColor = NamedColor(ColorOption.SECONDARY, colorScheme.secondary),
        windowColor = NamedColor(ColorOption.SURFACE, colorScheme.surface),
        contentColor = NamedColor(ColorOption.SURFACE_VARIANT, colorScheme.surfaceVariant),
        stickyTextColor = NamedColor(ColorOption.TERTIARY, colorScheme.tertiary),
    )
}

