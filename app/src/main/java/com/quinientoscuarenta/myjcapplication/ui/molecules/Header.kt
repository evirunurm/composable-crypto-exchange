package com.quinientoscuarenta.myjcapplication.ui.molecules

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.quinientoscuarenta.myjcapplication.ui.atoms.CircularButton
import com.quinientoscuarenta.myjcapplication.ui.atoms.JCText

@Composable
fun Header(
    title: String,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        CircularButton(
            onClick = onButtonClick,

            ) {
            Icon(
                imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowLeft,
                contentDescription = "Back"
            )
        }
        JCText(
            text = title,
            fontSize = 18.sp,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}