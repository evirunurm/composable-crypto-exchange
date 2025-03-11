package com.quinientoscuarenta.myjcapplication.atoms

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ExchangeCardButton(
    text: String,
    modifier: Modifier = Modifier,
    variant: ButtonVariant = ButtonVariant.Normal,
    onClick: () -> Unit
) {
    // TODO: Filled variant should have no border stroke, and it should have a dark green background color with green text color
    OutlinedButton(
        onClick,
        modifier,
        // Todo: Add the correct border color, with opacity 0.5
        border = BorderStroke(1.dp, Color.Gray),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.tertiary,
        )
    ) {
        Text(text = text, color = Color.Gray)
    }
}

enum class ButtonVariant {
    Normal,
    Filled
}