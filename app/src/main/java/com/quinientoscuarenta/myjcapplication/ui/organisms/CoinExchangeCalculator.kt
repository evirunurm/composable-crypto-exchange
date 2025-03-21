package com.quinientoscuarenta.myjcapplication.ui.organisms

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.quinientoscuarenta.myjcapplication.ui.atoms.CircularButton
import com.quinientoscuarenta.myjcapplication.ui.atoms.JCButton
import com.quinientoscuarenta.myjcapplication.ui.atoms.JCText
import com.quinientoscuarenta.myjcapplication.ui.molecules.ExchangeCard
import com.quinientoscuarenta.myjcapplication.ui.molecules.ExchangeCardAction
import com.quinientoscuarenta.myjcapplication.ui.theme.LocalCustomColors

@Composable
fun CoinExchangeCalculator(
    coins: Array<ExchangeCoin>,
    onSwitchCoins: () -> Unit
) {
    val coin1 = coins.first()
    val coin2 = coins.last()
    val primaryCoinActions: List<ExchangeCardAction> = listOf(
        ExchangeCardAction(
            description = "Send",
            action = { /*TODO: Logic to send. */ }
        ),
        ExchangeCardAction(
            description = "Max",
            action = { /*TODO: Logic to receive. */ },
            primary = false
        )
    )
    val secondaryCoinActions: List<ExchangeCardAction> = listOf(
        ExchangeCardAction(
            description = "Receive",
            action = { /*TODO: Logic to send. */ }
        ),
    )

    ConstraintLayout {
        val (coin1Card, backButton, coin2Card, exchangeButton) = createRefs()

        ExchangeCard(
            coinName = coin1.name,
            coinValue = coin1.value.toString(),
            coinBalance = coin1.balance.toString(),
            coinImageVector = coin1.coinImageVector,
            actions = primaryCoinActions,
            modifier = Modifier.constrainAs(coin1Card) {
                top.linkTo(parent.top)
            }
        )
        ExchangeCard(
            coinName = coin2.name,
            coinValue = coin2.value.toString(),
            coinBalance = coin2.balance.toString(),
            coinImageVector = coin2.coinImageVector,
            actions = secondaryCoinActions,
            modifier = Modifier.constrainAs(coin2Card) {
                top.linkTo(coin1Card.bottom, 8.dp)
            },
        )
        CircularButton(
            onClick = { onSwitchCoins() },
            modifier = Modifier.constrainAs(backButton) {
                start.linkTo(coin1Card.start)
                end.linkTo(coin2Card.end)
                top.linkTo(coin1Card.top)
                bottom.linkTo(coin2Card.bottom)
            },
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = LocalCustomColors.current.neutral100
            )
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                tint = Color.White,
                contentDescription = "Switch",
                modifier = Modifier
                    .size(24.dp)
                    .rotate(90f)
            )
        }
        JCButton(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(exchangeButton) { top.linkTo(coin2Card.bottom, 8.dp) }
        ) {
            JCText("Exchange")
        }
    }
}


data class ExchangeCoin constructor(
    val name: String,
    val value: Double,
    val balance: Double,
    val coinImageVector: ImageVector
)