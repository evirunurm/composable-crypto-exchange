package com.quinientoscuarenta.myjcapplication.ui.atoms

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.quinientoscuarenta.myjcapplication.ui.theme.GenuineTheme

@Composable
fun CircularButton(
    // We create a wrapper for IconButton that sets a default size an colors according to DS
    // It accept the same parameters as IconButton.
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: IconButtonColors = IconButtonDefaults.iconButtonColors(
        // Colors are set to theme colors
        contentColor = GenuineTheme.colors.font,
        containerColor = GenuineTheme.colors.foregroundMid,
    ),
    interactionSource: MutableInteractionSource? = null,
    content: @Composable () -> Unit
) {
    IconButton(
        onClick,
        modifier.size(58.dp), // Maybe this could be a themed size?
        enabled,
        colors,
        interactionSource,
        content
    )
}