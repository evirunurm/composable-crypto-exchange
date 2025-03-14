package com.quinientoscuarenta.myjcapplication.ui.atoms

import androidx.compose.material3.DropdownMenu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.quinientoscuarenta.myjcapplication.ui.theme.LocalCustomColors

@Composable
fun JCDropdownMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    DropdownMenu(
        expanded,
        onDismissRequest,
        modifier,
        containerColor = LocalCustomColors.current.neutral100,
    ) {
        content()
    }
}