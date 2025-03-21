package com.quinientoscuarenta.myjcapplication.ui.atoms

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.quinientoscuarenta.myjcapplication.ui.theme.LocalCustomColors

// TODO: Isolate this into a JKButton
@Composable
fun ExchangeCardButton(
    text: String,
    modifier: Modifier = Modifier,
    variant: ButtonVariant = ButtonVariant.Normal,
    onClick: () -> Unit
) {
    val border = if (variant == ButtonVariant.Filled) null else BorderStroke(
        1.dp,
        MaterialTheme.colorScheme.onTertiary.copy(alpha = 0.1f)
    )
    val containerColor =
        if (variant == ButtonVariant.Filled) LocalCustomColors.current.brand100.run {
            copy(alpha = 0.2f)
        }
        else LocalCustomColors.current.neutral100
    val contentColor =
        if (variant == ButtonVariant.Filled) LocalCustomColors.current.brand100
        else LocalCustomColors.current.genericWhite

    OutlinedButton(
        onClick,
        modifier,
        border = border,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    ) {
        JCText(text = text, color = contentColor)
    }
}

enum class ButtonVariant {
    Normal,
    Filled
}