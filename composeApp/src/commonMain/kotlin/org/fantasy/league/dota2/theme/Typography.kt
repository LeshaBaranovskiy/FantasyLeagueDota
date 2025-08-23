package org.fantasy.league.dota2.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import fantasyleaguedota.composeapp.generated.resources.PTSerif_Bold
import fantasyleaguedota.composeapp.generated.resources.PTSerif_BoldItalic
import fantasyleaguedota.composeapp.generated.resources.PTSerif_Italic
import fantasyleaguedota.composeapp.generated.resources.PTSerif_Regular
import fantasyleaguedota.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

val PtSerifRegular @Composable get() = FontFamily(
    Font(
        resource = Res.font.PTSerif_Regular,
        weight = FontWeight.Normal
    )
)

val PtSerifBold @Composable get() = FontFamily(
    Font(
        resource = Res.font.PTSerif_Bold,
        weight = FontWeight.Bold
    ),
)

val PtSerifItalic @Composable get() = FontFamily(
    Font(
        resource = Res.font.PTSerif_Italic,
        weight = FontWeight.Normal
    ),
)

val PtSerifBoldItalic @Composable get() = FontFamily(
    Font(
        resource = Res.font.PTSerif_BoldItalic,
        weight = FontWeight.Bold
    ),
)

val Typography: Typography @Composable get() = Typography(
    bodyLarge = TextStyle(
        fontFamily = PtSerifRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        lineHeight = 24.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = PtSerifRegular,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        lineHeight = 20.sp
    ),
    bodySmall = TextStyle(
        fontFamily = PtSerifRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = 20.sp
    ),
    titleLarge = TextStyle(
        fontFamily = PtSerifBold,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 36.sp
    ),
    titleSmall = TextStyle(
        fontFamily = PtSerifBold,
        fontWeight = FontWeight.Medium,
        fontSize = 17.sp,
        lineHeight = 24.sp
    ),
)