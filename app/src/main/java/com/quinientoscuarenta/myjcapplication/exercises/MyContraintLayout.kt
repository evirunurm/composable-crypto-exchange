package com.quinientoscuarenta.myjcapplication.exercises

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun MyConstraintLayout(
    modifier: Modifier = Modifier
) {
    ConstraintLayout(modifier) {
        val (cyanBox, darkGreyBox, blackBox,
            magentaBox, saladBox, yellowBox,
            greyBox, redBox, blueBox)
                = createRefs()
        Box(
            modifier = Modifier
                .size(175.dp)
                .background(Color.Cyan)
                .constrainAs(cyanBox) {
                    bottom.linkTo(saladBox.top)
                    end.linkTo(magentaBox.end)
                }
        )
        Box(
            modifier = Modifier
                .size(175.dp)
                .background(Color.DarkGray)
                .constrainAs(darkGreyBox) {
                    start.linkTo(saladBox.start)
                    bottom.linkTo(saladBox.top)
                }
        )
        Box(
            modifier = Modifier
                .size(75.dp)
                .background(Color.Black)
                .constrainAs(blackBox) {
                    start.linkTo(yellowBox.start)
                    top.linkTo(cyanBox.top)
                    bottom.linkTo(cyanBox.bottom)
                }
        )
        Box(
            modifier = Modifier
                .size(75.dp)
                .background(Color.Magenta)
                .constrainAs(magentaBox) {
                    bottom.linkTo(yellowBox.top)
                    end.linkTo(yellowBox.start)
                }
        )
        Box(
            modifier = Modifier
                .size(75.dp)
                .background(Color.Green)
                .constrainAs(saladBox) {
                    bottom.linkTo(yellowBox.top)
                    start.linkTo(yellowBox.end)
                }
        )
        Box(
            modifier = Modifier
                .size(75.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
        )
        Box(
            modifier = Modifier
                .size(175.dp)
                .background(Color.Blue)
                .constrainAs(blueBox) {
                    top.linkTo(yellowBox.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Box(
            modifier = Modifier
                .size(75.dp)
                .background(Color.Gray)
                .constrainAs(greyBox) {
                    top.linkTo(yellowBox.bottom)
                    end.linkTo(yellowBox.start)
                }
        )
        Box(
            modifier = Modifier
                .size(75.dp)
                .background(Color.Red)
                .constrainAs(redBox) {
                    top.linkTo(yellowBox.bottom)
                    start.linkTo(yellowBox.end)
                }
        )
    }
}