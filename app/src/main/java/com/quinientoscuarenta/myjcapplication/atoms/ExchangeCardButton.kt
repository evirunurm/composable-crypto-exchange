package com.quinientoscuarenta.myjcapplication.atoms

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ExchangeCardButton(
    text: String,
    modifier: Modifier = Modifier,
    variant: ButtonVariant = ButtonVariant.Normal,
    onClick: () -> Unit
) {
    val border = if (variant == ButtonVariant.Filled) null else BorderStroke(
        1.dp,
        MaterialTheme.colorScheme.onTertiary.copy(alpha = 0.5f)
    )
    val containerColor =
        if (variant == ButtonVariant.Filled) MaterialTheme.colorScheme.onSecondary
        else MaterialTheme.colorScheme.tertiary
    val contentColor =
        if (variant == ButtonVariant.Filled) MaterialTheme.colorScheme.secondary
        else MaterialTheme.colorScheme.onTertiary

    OutlinedButton(
        onClick,
        modifier,
        border = border,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    ) {
        Text(text = text, color = contentColor)
    }
}

enum class ButtonVariant {
    Normal,
    Filled
}