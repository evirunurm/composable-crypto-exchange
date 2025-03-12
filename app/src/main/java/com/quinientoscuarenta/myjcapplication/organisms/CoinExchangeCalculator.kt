package com.quinientoscuarenta.myjcapplication.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.quinientoscuarenta.myjcapplication.R
import com.quinientoscuarenta.myjcapplication.molecules.ExchangeCard
import com.quinientoscuarenta.myjcapplication.molecules.ExchangeCardAction

@Composable
fun CoinExchangeCalculator(
    coins: Array<ExchangeCoin>
) {
    val coin1 = coins.first()
    val coin2 = coins.last()
    val primaryCoinActions: List<ExchangeCardAction> = listOf(
        ExchangeCardAction(
            description = "Send",
            action = { /*TODO: Logic to send. */ },
            primary = true
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
            action = { /*TODO: Logic to send. */ },
            primary = true
        ),
    )

    ConstraintLayout {
        val (coin1Card, backButton, coin2Card) = createRefs()

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
        IconButton(
            onClick = { /*TODO: Logic to switch places the coins. */ },
            modifier = Modifier
                .background(shape = CircleShape, color = colorScheme.onTertiary)
                .padding(8.dp)
                .constrainAs(backButton) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_exchange_alt),
                tint = Color.White,
                contentDescription = "Switch",
            )
        }
    }
}


data class ExchangeCoin(
    val name: String,
    val value: Double,
    val balance: Double,
    val coinImageVector: ImageVector
)