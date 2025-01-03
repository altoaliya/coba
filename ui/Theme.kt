package com.example.coba.ui.Theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    onPrimary = White,
    secondary = PurpleGrey40,
    onSecondary = White,
    background = White,
    surface = White,
    onSurface = Black,
)

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    onPrimary = Black,
    secondary = PurpleGrey80,
    onSecondary = Black,
    background = Black,
    surface = Black,
    onSurface = White,
)

@Composable
fun BungaTheme(
    darkTheme: Boolean = false, // Gunakan preferensi sistem atau pengaturan Anda
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
