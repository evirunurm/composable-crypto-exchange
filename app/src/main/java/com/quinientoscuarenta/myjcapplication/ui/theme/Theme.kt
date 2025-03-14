package com.quinientoscuarenta.myjcapplication.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color


@Immutable
data class ColorScheme(
    val genericWhite: Color,
    val genericBlack: Color,
    val brand100: Color,
    val brand200: Color,
    val neutral100: Color,
    val secondary100: Color,
    val red100: Color
)

@Immutable
class SemanticColors(
    val globalWhite: Color,
    val textDefault: Color,
    val textSubtle: Color,
    val textLinks: Color,
    val iconDefault: Color,
    val containerBackgroundDefault: Color
)

//@Immutable
//data class ComponentColors(
//    val buttonBackgroundPrimaryDefault: Color,
//    val buttonBackgroundPrimaryDisabled: Color,
//    val buttonBackgroundPrimaryError: Color,
//    val buttonBackgroundSecondaryDefault: Color,
//    val buttonBackgroundSecondaryDisabled: Color,
//    val buttonBackgroundSecondaryError: Color,
//)

// Returns a instance of all Core colors, taken from tokens.
fun coreColorsScheme(): ColorScheme {
    return ColorScheme(
        genericWhite = Color(0xFFFFFFFF),
        genericBlack = Color(0xFF000000),
        brand100 = Color(0xFF000000),
        neutral100 = Color(0xFF000000),
        secondary100 = Color(0xFF000000),
        red100 = Color(0xFF000000),
        brand200 = Color(0xFF4E55F1)
    )
}

// Loads the custom colors from the tokens.
// Substitutes the Core colors with the custom ones.
// Returns a instance of the mix of Core and Custom colors.
fun customColorsScheme(): ColorScheme {
    val coreColors = coreColorsScheme()

    return ColorScheme(
        genericWhite = Color(0xFFFFFFFF),
        genericBlack = Color(0xFF000000),
        brand100 = Color(0xFF2D2121),
        neutral100 = Color(0xFF333333),
        secondary100 = Color(0xFF4BABB4),
        red100 = Color(0xFF000000),
        brand200 = coreColors.brand200
    )
}

// Returns Semantic colors based on the provided final local ColorScheme.
fun semanticColorsScheme(
    // ?? Provide by default. Not sure if this makes sense.
    // Just so it can be called without parameters during LocalSemanticColors initialization.
    colorScheme: ColorScheme = customColorsScheme()
): SemanticColors {
    return SemanticColors(
        globalWhite = colorScheme.genericWhite,
        textDefault = colorScheme.genericWhite,
        textSubtle = colorScheme.genericWhite,
        textLinks = colorScheme.brand100,
        iconDefault = colorScheme.genericWhite,
        containerBackgroundDefault = colorScheme.neutral100
    )
}

val LocalCustomColors = compositionLocalOf { customColorsScheme() }
val LocalSemanticColors = compositionLocalOf { semanticColorsScheme() }

@Composable
fun GenuineTheme(
    customColors: ColorScheme,
    content: @Composable () -> Unit
) {
    // With the passed custom colors, generate the semantic colors, etc
    val semanticColors = semanticColorsScheme(customColors)

    CompositionLocalProvider(
        LocalCustomColors provides customColors,
        LocalSemanticColors provides semanticColors,
        content = content
    )
}

// Why is this used? To have everything centralized in a single object, maybe?
object GenuineTheme {
    val customColors: ColorScheme
        @Composable
        get() = LocalCustomColors.current
}