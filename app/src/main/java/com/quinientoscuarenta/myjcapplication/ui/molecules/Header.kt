package com.quinientoscuarenta.myjcapplication.ui.molecules

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.quinientoscuarenta.myjcapplication.ui.atoms.CircularButton
import com.quinientoscuarenta.myjcapplication.ui.atoms.JCText

@Composable
fun Header(
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable HeaderContentScope.() -> Unit,
) {
    val contentScope = remember { HeaderContentScope() }
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        CircularButton(onClick = onButtonClick) {
            Icon(
                imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowLeft,
                contentDescription = "Back"
            )
        }
        Box(
            modifier = Modifier.align(Alignment.Center)
        ) {
            with(contentScope) { content() }
        }
    }
}

@Stable
class HeaderContentScope {
    @Composable
    fun Title(
        title: String,
        modifier: Modifier = Modifier,
    ) {
        JCText(
            text = title,
            fontSize = 18.sp,
            modifier = modifier
        )
    }
}