package dev.dorssers.materialsync.data

import android.content.Context
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ExperimentalGraphicsApi
import androidx.compose.ui.graphics.toArgb
import com.google.gson.JsonObject
import com.google.gson.JsonPrimitive
import com.google.gson.annotations.SerializedName
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

    @SerializedName("name") val name: String,
    @SerializedName("primary_color") val primaryColor: Color,
    @SerializedName("highlight_color") val highlightColor: Color,
    @SerializedName("accent_color") val accentColor: Color,
    @SerializedName("content_color") val contentColor: Color,
    @SerializedName("window_color") val windowColor: Color,
    @SerializedName("primary_text_color") val primaryTextColor: Color,
    @SerializedName("secondary_text_color") val secondaryTextColor: Color,
    @SerializedName("sticky_text_color") val stickyTextColor: Color
) {
    fun toJson(): JsonObject {
        val jsonObject = JsonObject()
        jsonObject.add("name", JsonPrimitive(name))
        jsonObject.add("primary_color", JsonPrimitive(primaryColor.toHex()))
        jsonObject.add("highlight_color", JsonPrimitive(highlightColor.toHex()))
        jsonObject.add("accent_color", JsonPrimitive(accentColor.toHex()))
        jsonObject.add("content_color", JsonPrimitive(contentColor.toHex()))
        jsonObject.add("window_color", JsonPrimitive(windowColor.toHex()))
        jsonObject.add("primary_text_color", JsonPrimitive(primaryTextColor.toHex()))
        jsonObject.add("secondary_text_color", JsonPrimitive(secondaryTextColor.toHex()))
        jsonObject.add("sticky_text_color", JsonPrimitive(stickyTextColor.toHex()))
        return jsonObject
    }

    fun toColorList(): List<Pair<String, Color>> {
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
        @OptIn(ExperimentalGraphicsApi::class)
        fun default(): SyncTheme {
            return SyncTheme(
                name = "Default",
                primaryColor = Color.White,
                accentColor = Color.Blue,
                highlightColor = Color.hsv(23f, 0.94f, 0.97f),
                primaryTextColor = Color.Black,
                secondaryTextColor = Color.Gray,
                windowColor = Color.hsv(0f, 0f, 0.93f),
                contentColor = Color.White,
                stickyTextColor = Color.Green,
            )
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
        primaryColor = colorScheme.primary,
        accentColor = colorScheme.tertiary,
        highlightColor = colorScheme.secondary,
        primaryTextColor = colorScheme.primary,
        secondaryTextColor = colorScheme.secondary,
        windowColor = colorScheme.surface,
        contentColor = colorScheme.surfaceVariant,
        stickyTextColor = colorScheme.tertiary,
    )
}

