package com.quinientoscuarenta.myjcapplication.designsystem.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.quinientoscuarenta.myjcapplication.R
import com.quinientoscuarenta.myjcapplication.ui.theme.Grey


@Composable
fun ExchangeCard(
    coinImageVector: ImageVector,
    coinName: String,
    coinValue: String,
    coinBalance: String,
    modifier: Modifier = Modifier,
    mainButton: @Composable (Modifier) -> Unit = {},
    secondaryButton: @Composable (Modifier) -> Unit = {}
) {
    Column(
        modifier = modifier
            .background(Grey, shape = RoundedCornerShape(32.dp))
            .padding(8.dp)
    ) {
        ExchangeCardHeader(
            coinName = coinName,
            coinImageVector = coinImageVector,
            button = { modifier ->
                mainButton(modifier)
            },
            modifier = Modifier.fillMaxWidth()
        )
        ExchangeCardContent(
            coinValue = coinValue,
            modifier = Modifier.fillMaxWidth(),
            button = { modifier ->
                secondaryButton(modifier)
            }
        )
        ExchangeCardFooter(
            coinBalance = coinBalance,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ExchangeCardFooter(
    coinBalance: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.padding(0.dp, 0.dp, 0.dp, 21.dp)
    ) {
        Text(
            text = stringResource(id = R.string.balance_prefix) + " " + coinBalance,
            fontWeight = FontWeight.W500,
            fontSize = 12.sp
        )
    }
}

@Composable
fun ExchangeCardContent(
    coinValue: String,
    modifier: Modifier = Modifier,
    button: @Composable (Modifier) -> Unit = {}
) {
    ConstraintLayout(modifier = modifier.padding(16.dp)) {
        val (coinValueRef, buttonRef) = createRefs()
        Text(
            coinValue,
            fontWeight = FontWeight.W500,
            fontSize = 32.sp,
            modifier = Modifier.constrainAs(coinValueRef) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        button(
            Modifier.constrainAs(buttonRef) {
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
        )
    }
}

@Composable
fun ExchangeCardHeader(
    coinName: String,
    coinImageVector: ImageVector,
    modifier: Modifier = Modifier,
    button: @Composable (modifier: Modifier) -> Unit = {}
) {
    ConstraintLayout(modifier = modifier) {
        val (iconRef, titleRef, buttonRef) = createRefs()
        Icon(
            imageVector = coinImageVector,
            contentDescription = coinName,
            modifier = Modifier
                .background(Color.White, shape = CircleShape)
                .padding(12.dp)
                .constrainAs(iconRef) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
        )
        ExchangeCardTitle(
            coinName = coinName,
            modifier = Modifier.constrainAs(titleRef) {
                start.linkTo(iconRef.end, 16.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
        )
        button(
            Modifier.constrainAs(buttonRef) {
                end.linkTo(parent.end)
            }
        )
    }
}

@Composable
fun ExchangeCardTitle(
    coinName: String,
    modifier: Modifier = Modifier
) {
    Row(modifier) {
        Text(coinName, fontWeight = FontWeight.SemiBold, fontSize = 20.sp)
        Icon(
            imageVector = Icons.Rounded.KeyboardArrowDown,
            contentDescription = coinName,
            tint = Color.White,
            modifier = Modifier.alpha(0.4f)
        )
    }
}