package com.quinientoscuarenta.myjcapplication.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.quinientoscuarenta.myjcapplication.R

// We create the different
@Immutable
data class GenuineColors(
    val primary: Color,
    val font: Color,
    val positive: Color,
    val negative: Color,
    val background: Color,
    val foregroundMid: Color,
    val foregroundTop: Color
)

@Immutable
data class GenuineTypography(
    val body: TextStyle,
    val title: TextStyle
)

@Immutable
class GenuineIcons {
    val exchange: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_exchange_alt)

    val backArrow: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_exchange_alt)
}

val LocalGenuineColors = staticCompositionLocalOf {
    GenuineColors(
        primary = Purple,
        font = White,
        positive = Green,
        negative = Color.Red,
        background = Black,
        foregroundMid = Gray,
        foregroundTop = LightGray
    )
}

val LocalGenuineTypography = staticCompositionLocalOf {
    GenuineTypography(
        body = Typography.bodyLarge,
        title = TextStyle.Default
    )
}

internal val LocalGenuineIcons = staticCompositionLocalOf { GenuineIcons() }

@Composable
fun GenuineTheme(
    icons: GenuineIcons = GenuineTheme.icons,
    content: @Composable () -> Unit
) {
    val genuineColors = GenuineColors(
        primary = Purple,
        font = White,
        positive = Green,
        negative = Color.Red,
        background = Black,
        foregroundMid = Gray,
        foregroundTop = LightGray
    )
    val genuineTypography = GenuineTypography(
        body = TextStyle(fontSize = 16.sp),
        title = TextStyle(fontSize = 32.sp)
    )
    CompositionLocalProvider(
        LocalGenuineColors provides genuineColors,
        LocalGenuineTypography provides genuineTypography,
        LocalGenuineIcons provides icons,
        content = content
    )
}

object GenuineTheme {
    val colors: GenuineColors
        @Composable
        get() = LocalGenuineColors.current
    val typography: GenuineTypography
        @Composable
        get() = LocalGenuineTypography.current
    val icons: GenuineIcons
        @Composable
        get() = LocalGenuineIcons.current
}