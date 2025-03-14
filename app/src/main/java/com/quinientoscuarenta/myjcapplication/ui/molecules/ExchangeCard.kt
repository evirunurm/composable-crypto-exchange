package com.quinientoscuarenta.myjcapplication.ui.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.quinientoscuarenta.myjcapplication.ui.atoms.ButtonVariant
import com.quinientoscuarenta.myjcapplication.ui.atoms.ExchangeCardButton
import com.quinientoscuarenta.myjcapplication.ui.atoms.JCText
import com.quinientoscuarenta.myjcapplication.ui.theme.LocalCustomColors

data class ExchangeCardAction(
    val description: String,
    val action: () -> Unit,
    val primary: Boolean = true
)

@Composable
fun ExchangeCard(
    coinImageVector: ImageVector,
    coinName: String,
    coinValue: String,
    coinBalance: String,
    modifier: Modifier = Modifier,
    actions: List<ExchangeCardAction> = listOf()
) {
    var expanded by remember { mutableStateOf(false) }
    val primaryButton: @Composable ((Modifier) -> Unit)? = actions.firstOrNull { it.primary }?.let {
        @Composable { modifier: Modifier ->
            ExchangeCardButton(
                text = it.description,
                onClick = it.action,
                modifier = modifier
            )
        }
    }
    val secondaryButton: @Composable ((Modifier) -> Unit)? =
        actions.firstOrNull { !it.primary }?.let {
            @Composable { modifier: Modifier ->
                ExchangeCardButton(
                    text = it.description,
                    onClick = it.action,
                    variant = ButtonVariant.Filled,
                    modifier = modifier
                )
            }
        }

    Card(
        colors = CardDefaults.cardColors(
            LocalCustomColors.current.neutral100,
            LocalCustomColors.current.genericWhite
        ),
        shape = RoundedCornerShape(32.dp),
        modifier = modifier
    ) {
        Column(Modifier.padding(8.dp, 8.dp, 16.dp, 8.dp)) {
            ExchangeCardHeader(
                coinName = coinName,
                coinImageVector = coinImageVector,
                button = primaryButton,
                onTitleClick = {
                    expanded = true
                },
                modifier = Modifier.fillMaxWidth()
            )
            ExchangeCardContent(
                coinValue = coinValue,
                modifier = Modifier.fillMaxWidth(),
                button = secondaryButton
            )
            ExchangeCardFooter(
                coinBalance = coinBalance,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
    DropdownMenu(
        expanded,
        onDismissRequest = { expanded = false },
        modifier = Modifier.fillMaxWidth()
    ) {
        listOf("ETH", "BTC", "XRP").map {
            DropdownMenuItem(
                { JCText(it) },
                onClick = {
                    expanded = false
                }
            )
        }
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
        JCText(
            text = stringResource(id = R.string.balance_prefix) + " ",
            fontWeight = FontWeight.W400,
            fontSize = 14.sp,
            modifier = Modifier.alpha(0.5f)
        )
        JCText(
            text = coinBalance,
            fontWeight = FontWeight.W400,
            fontSize = 14.sp
        )
    }
}

@Composable
fun ExchangeCardContent(
    coinValue: String,
    modifier: Modifier = Modifier,
    button: @Composable ((Modifier) -> Unit)? = {}
) {
    ConstraintLayout(modifier = modifier.padding(0.dp, 16.dp)) {
        val (coinValueRef, buttonRef) = createRefs()
        JCText(
            coinValue,
            fontWeight = FontWeight.W500,
            fontSize = 36.sp,
            modifier = Modifier.constrainAs(coinValueRef) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        button?.invoke(
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
    onTitleClick: () -> Unit,
    modifier: Modifier = Modifier,
    button: @Composable ((Modifier) -> Unit)? = {}
) {
    ConstraintLayout(modifier = modifier) {
        val (iconRef, titleRef, buttonRef) = createRefs()
        Icon(
            imageVector = coinImageVector,
            contentDescription = coinName,
            modifier = Modifier
                .background(Color.White, shape = CircleShape)
                .padding(18.dp)
                .constrainAs(iconRef) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
        )
        ExchangeCardTitle(
            coinName = coinName,
            onTitleClick = onTitleClick,
            modifier = Modifier.constrainAs(titleRef) {
                start.linkTo(iconRef.end, 16.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
        )
        button?.invoke(
            Modifier.constrainAs(buttonRef) {
                end.linkTo(parent.end)
            }
        )
    }
}

// Must be clickable
@Composable
fun ExchangeCardTitle(
    coinName: String,
    onTitleClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier
            .clickable { onTitleClick() }) {
        JCText(coinName, fontWeight = FontWeight.Normal, fontSize = 28.sp)
        Spacer(Modifier.width(8.dp))
        Icon(
            imageVector = Icons.Rounded.KeyboardArrowDown,
            contentDescription = coinName,
            tint = Color.White,
            modifier = Modifier
                .alpha(0.4f)
                .align(Alignment.CenterVertically)
        )
    }
}