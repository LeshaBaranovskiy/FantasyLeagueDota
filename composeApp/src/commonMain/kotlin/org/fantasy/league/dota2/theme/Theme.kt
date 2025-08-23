package com.example.compose
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.fantasy.league.dota2.theme.Typography

val LightColorTheme = lightColorScheme(
    primary = Primary,
    secondary = Secondary,
    tertiaryContainer = Tertiary,
    error = Error,
    surface = Surface,
    background = Background,
    onSurface = OnSurface,

)

@Composable
fun extendedColor(light: Color, dark: Color): Color {
    return if(isSystemInDarkTheme()) dark else light
}

val ColorScheme.extraColor: Color @Composable get() = extendedColor(
    light = Color(0xFF000000),
    dark = Color(0xFFFFFFFF)
)

val Shapes = Shapes(
    extraSmall = RoundedCornerShape(5.dp),
    medium = RoundedCornerShape(15.dp)
)

@Composable
fun FantasyLeagueTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorTheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
