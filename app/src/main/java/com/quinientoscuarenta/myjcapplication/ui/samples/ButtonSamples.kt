package com.quinientoscuarenta.myjcapplication.ui.samples

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.quinientoscuarenta.myjcapplication.ui.atoms.JCButton

@Preview
@Composable
fun ButtonSample() {
    JCButton(onClick = { /* Do something! */ }) { Text("Button") }
}