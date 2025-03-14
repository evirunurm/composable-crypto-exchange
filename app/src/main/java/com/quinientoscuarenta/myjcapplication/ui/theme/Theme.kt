package com.quinientoscuarenta.myjcapplication.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

// These classes would, ideally, have a structure similar to:
// - Generic
//      - Transparent: Color
//      - White: Color
//      - Black: Color
//      - Soft: Color
// - Brand
// - Secondary
// - Neutral
// - Red
// ...
@Immutable
data class ColorScheme(
    val genericWhite: Color,
    val genericBlack: Color,
    val brand100: Color,
    val brand900: Color, // Real example
    val neutral100: Color,
    val secondary100: Color,
    val red100: Color
)

// This class would, ideally, have a structure similar to:
// - Generic
//      - Transparent: Color
// - Text
//      - Default: Color
//      - Subtle01: Color
//      - Links: Color
//      - Brand01: Color
//      - Brand02: Color
//      - Disabled: Color
//      - Inverse: Color
// - Icon
// - Container Background
// - Page Background
// ...
@Immutable
data class SemanticColors(
    val containerBackgroundBrand01: Color,
    val containerBackgroundDisabled: Color,
    val supportiveFeedbackError: Color,
    val supportiveFeedbackSuccess: Color,
    val textLinks: Color,
)

// This class would, ideally, have a structure similar to:
// - Button
//      - Background
//          - Primary
//              - Default: Color
//              - Disabled: Color
//              - Error: Color
//          - Secondary
// - Icon
// - Input
@Immutable
data class ComponentColors(
    val buttonBackgroundPrimaryDefault: Color,
    val buttonBackgroundPrimaryDisabled: Color,
    val buttonBackgroundPrimaryError: Color,
    val buttonBackgroundSecondaryDefault: Color,
    val buttonBackgroundSecondaryDisabled: Color,
    val buttonBackgroundSecondaryError: Color,
)

// Returns a instance of all Core colors, taken from tokens.
fun coreColorsScheme(): ColorScheme {
    return ColorScheme(
        genericWhite = Color(0xFFFFFFFF),
        genericBlack = Color(0xFF000000),
        brand100 = Color(0xFF000000),
        neutral100 = Color(0xFF000000),
        secondary100 = Color(0xFF000000),
        red100 = Color(0xFF000000),
        brand900 = Color(0xFF000D44)
    )
}

// Loads the custom colors from the tokens.
// Substitutes the Core colors with the custom ones.
// Returns a instance of the mix of Core and Custom colors.
fun customColorsScheme(): ColorScheme {
    val coreColors = coreColorsScheme()

    return ColorScheme(
        // These would be the overrides
        genericWhite = Color(0xFFFFFFFF),
        genericBlack = Color(0xFF000000),
        brand100 = Color(0xFF2D2121),
        neutral100 = Color(0xFF333333),
        secondary100 = Color(0xFF4BABB4),
        red100 = Color(0xFF000000),
        brand900 = coreColors.brand900 // Real example
    )
}

// Returns Semantic colors based on the provided final local ColorScheme.
fun semanticColorsScheme(
    // ?? Provide by default. Not sure if this makes sense.
    // Just so it can be called without parameters during LocalSemanticColors initialization.
    colorScheme: ColorScheme = customColorsScheme()
): SemanticColors {
    return SemanticColors(
        containerBackgroundBrand01 = colorScheme.brand900,
        containerBackgroundDisabled = colorScheme.neutral100,
        supportiveFeedbackError = colorScheme.red100,
        supportiveFeedbackSuccess = colorScheme.secondary100,
        textLinks = colorScheme.brand900
    )
}

fun componentColorsScheme(
    semanticColors: SemanticColors = semanticColorsScheme()
): ComponentColors {
    return ComponentColors(
        buttonBackgroundPrimaryDefault = semanticColors.containerBackgroundBrand01, // Real examples
        buttonBackgroundPrimaryDisabled = semanticColors.textLinks,
        buttonBackgroundPrimaryError = semanticColors.textLinks,
        buttonBackgroundSecondaryDefault = semanticColors.textLinks,
        buttonBackgroundSecondaryDisabled = semanticColors.textLinks,
        buttonBackgroundSecondaryError = semanticColors.textLinks
    )
}

val LocalCustomColors = compositionLocalOf { customColorsScheme() }
val LocalSemanticColors = compositionLocalOf { semanticColorsScheme() }
val LocalComponentColors = compositionLocalOf { componentColorsScheme() }

@Composable
fun GenuineTheme(
    customColors: ColorScheme,
    content: @Composable () -> Unit
) {
    // With the passed custom colors, generate the semantic.
    val semanticColors = semanticColorsScheme(customColors)
    // Component colors are based on the semantic colors.
    val componentColors = componentColorsScheme(semanticColors)
    // val componentStateColors = componentStateColorsScheme(customColors)

    CompositionLocalProvider(
        LocalCustomColors provides customColors,
        LocalSemanticColors provides semanticColors,
        LocalComponentColors provides componentColors,
        content = content
    )
}

// Why is this used? To have everything centralized in a single object, maybe?
object GenuineTheme {
    val customColors: ColorScheme
        @Composable
        get() = LocalCustomColors.current
    val semanticColors: ColorScheme
        @Composable
        get() = LocalCustomColors.current
    val componentColors: ColorScheme
        @Composable
        get() = LocalCustomColors.current
}